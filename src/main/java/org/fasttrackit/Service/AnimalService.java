package org.fasttrackit.Service;

import org.fasttrackit.Persistence.AnimalRepository;
import org.fasttrackit.domain.Animal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AnimalService {
    AnimalRepository animalRescuerRepository=new AnimalRepository();

    public void createAnimalRescuer(Animal animal) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating item: "+animal);
        animalRescuerRepository.createAnimalRescuer(animal);
    }

    public List<Animal> getAnimalRescuer() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Getting to do items: ");
        return animalRescuerRepository.getAnimalRescuer();
    }
}
