package org.fasttrackit.Persistence;

import org.fasttrackit.domain.Animal;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    public void createAnimalRescuer(Animal animal) throws SQLException, IOException, ClassNotFoundException {
        try (Connection connection = DatabaseConfiguration.getConnection()) {
            String insertAnimal = "INSERT INTO animal (`name`,`age`,`healthLevel`,`hungerLevel`,`moodLevel`,`favoriteFood`,`favoriteRecreation`) VALUES (?,?,?,?,?,?,?)" + "ON DUPLICATE KEY UPDATE name_animal=name_animal+1;";

            PreparedStatement preparedStatement = connection.prepareStatement(insertAnimal);
            System.out.println(animal.getName());
            preparedStatement.setString(1, animal.getName());
            System.out.println(animal.getAge());
            preparedStatement.setInt(2, animal.getAge());
            System.out.println(animal.getHealthLevel());
            preparedStatement.setInt(3, animal.getHealthLevel());
            System.out.println(animal.getHungerLevel());
            preparedStatement.setInt(4, animal.getHungerLevel());
            System.out.println(animal.getMoodLevel());
            preparedStatement.setInt(5, animal.getMoodLevel());
            System.out.println(animal.getFavoriteFood());
            preparedStatement.setString(6, animal.getFavoriteFood());
            System.out.println(animal.getFavoriteRecreation());
            preparedStatement.setString(7, animal.getFavoriteRecreation());

            preparedStatement.executeUpdate();
        }
    }

    public List<Animal> getAnimalRescuer() throws SQLException, IOException, ClassNotFoundException {
        try (Connection connection = DatabaseConfiguration.getConnection()) {
            String query = "SELECT id,`name_animal`,`age`,`health_level`,`hunger_level`,`mood_level`,`favorite_food`,`favorite_recreation` FROM animal ORDER BY age desc";

            Statement statement = connection.createStatement();
            statement.execute(query);

            ResultSet resultSet = statement.executeQuery(query);
            List<Animal> response = new ArrayList<>();

            while (resultSet.next()) {
                Animal animalRescuer = new Animal();

                animalRescuer.setId(resultSet.getInt("id"));
                animalRescuer.setName(resultSet.getString("name_animal"));
                animalRescuer.setAge(resultSet.getInt("age"));
                animalRescuer.setHealthLevel(resultSet.getInt("health_level"));
                animalRescuer.setHungerLevel(resultSet.getInt("hunger_level"));
                animalRescuer.setMoodLevel(resultSet.getInt("mood_level"));
                animalRescuer.setFavoriteFood(resultSet.getString("favorite_food"));
                animalRescuer.setFavoriteRecreation(resultSet.getString("favorite_recreation"));

                response.add(animalRescuer);
            }

            return response;
        }
    }
}
