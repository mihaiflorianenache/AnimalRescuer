package org.fasttrackit;

import org.fasttrackit.domain.Animal;

public class Adopter {
    private String name;
    private int salary;

    Adopter(int salary)
    {
        this.salary=salary;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return name;
    }

    public void feedAnimal(Animal animal, String nameAnimalFood)
    {
        System.out.println(name+" just gave some "+nameAnimalFood+" to "+animal.getName());
        int hungerLevel=animal.getHungerLevel ();
        hungerLevel--;
        animal.setHungerLevel (hungerLevel);
        System.out.println ("Hunger level for "+animal.getName()+" decreased at "+animal.getHungerLevel ());

        //if food's name who is given by adopter to animal is same with the favorite food af animal
        //then the mood level for animal will increase with 1
        if(nameAnimalFood.equals (animal.getFavoriteFood ()))
        {
            int moodLevel=animal.getMoodLevel ();
            moodLevel++;
            animal.setMoodLevel (moodLevel);
            System.out.println ("Mood level for "+animal.getName()+" increased at "+animal.getMoodLevel ());
        }
        else{
            System.out.println ("Mood level for "+animal.getName()+" has same value");
        }
    }

    public void recreationAnimal(String nameRecreationActivity, Animal animal)
    {
        System.out.println(name+" play "+nameRecreationActivity+" with "+animal.getName());
        int moodLevel=animal.getMoodLevel ();
        System.out.println ("Mood level for "+animal.getName()+" increased at "+animal.getMoodLevel ());

        //if the recreation activity's name is same with favorite recreation's animal
        //then the mood level of animal will increase with 2
        if(nameRecreationActivity.equals (animal.getFavoriteRecreation ()))
        {
            moodLevel+=2;
            animal.setMoodLevel (moodLevel);
            moodLevel=animal.getMoodLevel ();
            System.out.println ("Mood level for "+animal.getName()+" is "+moodLevel);
        }
        else{
            moodLevel+=1;
            animal.setMoodLevel (moodLevel);
            moodLevel=animal.getMoodLevel ();
            System.out.println ("Mood level for "+animal.getName()+" is "+moodLevel);
        }
    }
}

