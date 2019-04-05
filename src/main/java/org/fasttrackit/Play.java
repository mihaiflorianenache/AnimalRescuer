package org.fasttrackit;

import org.fasttrackit.Service.AnimalService;
import org.fasttrackit.domain.*;
import org.fasttrackit.domain.Animal;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Play {

    private Adopter adopter;
    private Animal animal;
    private Vet vet;
    private int countActivity = 0;
    private int initialMoodLevel;

    private AnimalService animalService = new AnimalService();
    private List<AnimalFood> availableFood = new ArrayList<>();
    private RecreationActivity[] availableActivity = new RecreationActivity[5];

    private void initFood() {

        AnimalFood firstAnimalFood = new AnimalFood("Acana", 20, LocalDateTime.of(2026, 7, 1, 11, 00), true, 6.2);
        AnimalFood secondAnimalFood = new AnimalFood("Peanuts", 33, LocalDateTime.of(2024, 7, 1, 11, 00), true, 9.1);
        AnimalFood thirdAnimalFood = new AnimalFood("Nuts", 30, LocalDateTime.of(2021, 7, 1, 11, 00), true, 10.3);

        availableFood.add(firstAnimalFood);
        availableFood.add(secondAnimalFood);
        availableFood.add(thirdAnimalFood);
    }

    private void initActivities() {

        RecreationActivity firstRecreation = new RecreationActivity("swim in lake", 3, "Chicago, Michigan Lake");
        RecreationActivity secondRecreation = new RecreationActivity("sleep", 5, "London, Green Park");
        RecreationActivity thirdActivity = new RecreationActivity("run the postman", 1, "Paris, Buttes-Chaumont Park");

        availableActivity[0] = firstRecreation;
        countActivity++;

        availableActivity[1] = secondRecreation;
        countActivity++;

        availableActivity[2] = thirdActivity;
        countActivity++;
    }

    private void displayAvailableFood() {
        int i = 0;
        System.out.print("The available types of food are ");

        for (AnimalFood animalFood : availableFood) {
            i++;
            if (i != availableFood.size()) System.out.print(animalFood.getName() + ", ");
            else System.out.print(animalFood.getName() + "\n");
        }
    }

    private void displayActivities() {
        int i;
        System.out.print("The available activities are ");
        for (i = 0; i < availableActivity.length; i++) {
            if (availableActivity[i] != null) {
                if (i < countActivity - 1) System.out.print(availableActivity[i].getName() + ", ");
                else System.out.print(availableActivity[i].getName() + "\n");
            }
        }
    }

    private void callInitAdopter() {
        try {
            initAdopter();
        } catch (MyException exception) {
            System.out.println(exception);
            callInitAdopter();
        }
    }

    private void initAdopter() throws MyException {
        adopter = new Adopter(5000);
        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);
        String nameUser = scanner.nextLine();
        int i;
        for (i = 0; i < nameUser.length(); i++) {
            if (((nameUser.charAt(i) < (int) 'a' || nameUser.charAt(i) > (int) 'z') && (nameUser.charAt(i) < (int) 'A' || nameUser.charAt(i) > (int) 'Z') && nameUser.charAt(i) != (int) ' ' && nameUser.charAt(i) != '\t')) {
                throw new MyException("The name must contain only letters");
            }
        }
        adopter.setName(nameUser.trim());
    }

    private int initAnimal(Adopter adopter) {
        System.out.println(adopter.getName() + " what do you want to adopt between 1-Dog, 2-Cat, 3-Fish, 4-Parrot ?");
        try {
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if (option < 1 || option > 4) return initAnimal(adopter);
            else if (option == 1) {
                animal = new Dog("defend the master", false, 12, 7);
                animal.setFavoriteFood("Pedigree");
                animal.setFavoriteRecreation("catch the stick");
                animal.setHungerLevel(9);
                initialMoodLevel = 5;
                animal.setMoodLevel(initialMoodLevel);
            } else if (option == 2) {
                animal = new Cat("catch the mouse", true, 10, 6);
                animal.setFavoriteFood("Nuts");
                animal.setFavoriteRecreation("drink milk");
                animal.setHungerLevel(8);
                initialMoodLevel = 4;
                animal.setMoodLevel(initialMoodLevel);
            } else if (option == 3) {
                animal = new Fish("swimm in water", "Goldfish", 3, 7);
                animal.setFavoriteFood("worms");
                animal.setFavoriteRecreation("swim and jump");
                animal.setHungerLevel(5);
                initialMoodLevel = 8;
                animal.setMoodLevel(initialMoodLevel);
            } else if (option == 4) {
                animal = new Parrot("repeat words", "Gang gang", 6, 4);
                animal.setFavoriteFood("plants");
                animal.setFavoriteRecreation("eat plants");
                animal.setHungerLevel(3);
                initialMoodLevel = 9;
                animal.setMoodLevel(initialMoodLevel);
            }
        } catch (InputMismatchException exception) {
            System.out.println("You didn't choice a valid option. Try again.");
            return initAnimal(adopter);
        }
        return 0;
    }

    private void callNameAnimal() {
        try {
            nameAnimal();
        } catch (MyException exception) {
            System.out.println(exception);
            callNameAnimal();
        }
    }

    private void nameAnimal() throws MyException {
        System.out.println("Give a name to animal");
        Scanner scanner = new Scanner(System.in);
        String nameAnimal = scanner.nextLine();
        for (int i = 0; i < nameAnimal.length(); i++) {
            if (((nameAnimal.charAt(i) < (int) 'a' || nameAnimal.charAt(i) > (int) 'z') && (nameAnimal.charAt(i) < (int) 'A' || nameAnimal.charAt(i) > (int) 'Z') && nameAnimal.charAt(i) != (int) ' ' && nameAnimal.charAt(i) != '\t'))
                throw new MyException("The name must contains only letters");
        }
        animal.setName(nameAnimal.trim());
    }

    private void choiceRequireFeeding(String answer) {
        if (answer.equals("Y") || answer.equals("y")) {
            callRequireFeeding();
        } else if (answer.equals("N") || answer.equals("n")) {
            callOtherAnimalFood();
        }
    }

    private void offerAnimalFood() {
        try {
            String answer = regardAnimalFood();
            choiceRequireFeeding(answer);
        } catch (MyException exception) {
            System.out.println(exception);
            offerAnimalFood();
        }
    }

    private String regardAnimalFood() throws MyException {
        System.out.print(adopter.getName() + " do you want to offer at " + animal.getName() + " ");
        int i = 1;
        for (AnimalFood animalFood : availableFood) {
            if (i != availableFood.size()) System.out.print(i + "-" + animalFood.getName() + " or ");
            else System.out.print(i + "-" + animalFood.getName() + " Y/N ?\n");
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
            throw new MyException("You must to choice between Y and N");

        return answer;
    }

    private void callOtherAnimalFood() {
        try {
            otherAnimalFood();
        } catch (MyException exception) {
            System.out.println(exception);
            callOtherAnimalFood();
        }
    }

    private void otherAnimalFood() throws MyException {
        int i;
        System.out.println(adopter.getName() + " what do you want to offer at animal ?");
        Scanner myScanner = new Scanner(System.in);
        String nameFoodAnimal = myScanner.nextLine();
        int k = nameFoodAnimal.trim().length();
        for (i = 0; i < nameFoodAnimal.length(); i++) {
            if ((nameFoodAnimal.charAt(i) < (int) 'a' || nameFoodAnimal.charAt(i) > (int) 'z') && (nameFoodAnimal.charAt(i) < (int) 'A' || nameFoodAnimal.charAt(i) > (int) 'Z') && nameFoodAnimal.charAt(i) != ' ' && nameFoodAnimal.charAt(i) != '\t' && (nameFoodAnimal.charAt(i) < (int) '0' || nameFoodAnimal.charAt(i) > '9') && nameFoodAnimal.charAt(i) != '-')
                throw new MyException("Name can contains letters and digits");
        }

        //check if this animal food exists in list
        int counter = 0;
        for (AnimalFood animalFood : availableFood) {
            if (k == animalFood.getName().trim().length()) {
                for (i = 0; i < k; i++) {
                    if (animalFood.getName().trim().charAt(i) == nameFoodAnimal.trim().charAt(i) || animalFood.getName().trim().charAt(i) == nameFoodAnimal.trim().charAt(i) + 32 || animalFood.getName().trim().charAt(i) == nameFoodAnimal.trim().charAt(i) - 32)
                        counter++;
                }

                if (counter == k)
                    throw new MyException("You didn't want to choose animal food from list");
            }
        }

        adopter.feedAnimal(animal, nameFoodAnimal.trim());
    }

    private String callRequireFeeding() {
        int i;
        try {
            System.out.print("Choose a food between: ");
            int j = 1;
            for (AnimalFood animalFood : availableFood) {
                if (j != availableFood.size()) System.out.print(j + "-" + animalFood.getName() + " or ");
                else System.out.print(j + "-" + animalFood.getName() + " who you want to offer at animal\n");
                j++;
            }
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if (option < 1 || option > availableFood.size()) return callRequireFeeding();
            for (i = 1; i < availableFood.size() + 1; i++) {
                if (option == i) {
                    adopter.feedAnimal(animal, availableFood.get(i - 1).getName().trim());
                    break;
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("You didn't choice a valid option. Try again.");
            return callRequireFeeding();
        }
        return null;
    }

    private void callRequireActivities() {
        try {
            String answer = requireActivities();
            choiceRequireActivities(answer);
        } catch (MyException exception) {
            System.out.println(exception);
            callRequireActivities();
        }
    }

    private String requireActivities() throws MyException {
        System.out.print(adopter.getName() + " do you want to play with " + animal.getName() + " ");
        int i;
        for (i = 0; i < availableActivity.length; i++) {
            if (availableActivity[i] != null) {
                if (i < countActivity - 1) System.out.print((i + 1) + "-" + availableActivity[i].getName() + " or ");
                else System.out.println((i + 1) + "-" + availableActivity[i].getName() + " Y/N ?");
            }
        }


        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("N") && !answer.equals("n"))
            throw new MyException("Your answer must to be Y or N");

        else
            return answer;
    }

    private void choiceRequireActivities(String answer) {
        if (answer.equals("Y") || answer.equals("y"))
            activitiesAdopterAnimal();
        if (answer.equals("N") || answer.equals("n"))
            callOtherActivitiesAdopterAnimal();
    }

    private String activitiesAdopterAnimal() {
        System.out.print(adopter.getName() + " choice a recreation activity between ");
        int i = 1, j;
        for (j = 0; j < availableActivity.length; j++) {
            if (availableActivity[j]!= null) {
                if (j < countActivity-1) System.out.print(i + " - " + availableActivity[j].getName() + " or ");
                else System.out.print(i + "-" + availableActivity[j].getName() + "\n");
                i++;
            }
        }

        Scanner scanner = new Scanner(System.in);
        try {
            int choiceActivity = scanner.nextInt();
            if (choiceActivity < 1 || choiceActivity > countActivity) return activitiesAdopterAnimal();
            adopter.recreationAnimal(availableActivity[choiceActivity-1].getName(), animal);
        } catch (InputMismatchException exception) {
            System.out.println("You didn't choice a valid option. Try again.");
            return activitiesAdopterAnimal();
        }
        return null;
    }

    private void callOtherActivitiesAdopterAnimal() {
        try {
            otherActivitiesAdopterAnimal();
        } catch (MyException exception) {
            System.out.println(exception);
            callOtherActivitiesAdopterAnimal();
        }
    }

    private void otherActivitiesAdopterAnimal() throws MyException {
        System.out.println(adopter.getName() + " what do you want to play with " + animal.getName() + " ?");
        Scanner scanner = new Scanner(System.in);
        String otherActivityAdopterAnimal = scanner.nextLine();
        int i;
        for (i = 0; i < otherActivityAdopterAnimal.trim().length(); i++) {
            if ((otherActivityAdopterAnimal.trim().charAt(i) < (int) 'a' || otherActivityAdopterAnimal.trim().charAt(i) > (int) 'z') && (otherActivityAdopterAnimal.trim().charAt(i) < (int) 'A' || otherActivityAdopterAnimal.trim().charAt(i) > (int) 'Z') && otherActivityAdopterAnimal.trim().charAt(i) != ' ' && otherActivityAdopterAnimal.trim().charAt(i) != '\t')
                throw new MyException("You didn't choice a valid name.");
        }

        int k = otherActivityAdopterAnimal.trim().length();
        int contor = 0;
        for (RecreationActivity recreationActivity : availableActivity) {
            if(recreationActivity!=null){
                if (recreationActivity.getName().trim().length() == otherActivityAdopterAnimal.trim().length()) {
                    for (i = 0; i < recreationActivity.getName().trim().length(); i++) {
                        if (recreationActivity.getName().trim().charAt(i) == otherActivityAdopterAnimal.trim().charAt(i) || recreationActivity.getName().trim().charAt(i) == otherActivityAdopterAnimal.trim().charAt(i) + 32 || recreationActivity.getName().trim().charAt(i) == otherActivityAdopterAnimal.trim().charAt(i) - 32)
                            contor++;
                    }
                    if (k == contor)
                        throw new MyException("You choosed that you want to do other activity with " + animal.getName());
                }
            }
        }

        adopter.recreationAnimal(otherActivityAdopterAnimal, animal);
    }

    private void resultContest() throws SQLException, IOException, ClassNotFoundException {
        int finallyMoodLevelFinally = animal.getMoodLevel();
        int i;

        AnimalService animalService = new AnimalService();
        animalService.createAnimalRescuer(animal);
        animalService.getAnimalRescuer();
        //animalService.updateAnimalRescuer();

        switch (finallyMoodLevelFinally - initialMoodLevel) {
            case 1:
                System.out.println("The contest is not won");
                break;

            case 2:
                System.out.println("The contest is won and " + animal.getName() + " is very little happy");
                break;

            case 3:
                System.out.println("The contest is won and " + animal.getName() + " is very many happy");
                break;
        }
    }

    public void start() throws SQLException, IOException, ClassNotFoundException {
        callInitAdopter();
        initAnimal(adopter);
        callNameAnimal();
        initFood();
        initActivities();
        displayAvailableFood();
        displayActivities();
        offerAnimalFood();
        callRequireActivities();
        resultContest();
    }
}

