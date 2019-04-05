package org.fasttrackit.domain;

public class Animal {

    private int id;
    private String name;
    private int age;
    private int healthLevel;
    private int hungerLevel;
    private int moodLevel;
    private String favoriteFood;
    private String favoriteRecreation;

    public Animal(){}

    Animal(int age,int healthLevel){
        this.age=age;
        this.healthLevel=healthLevel;
    }

    public void setId(int id){this.id=id;}

    public void setName(String name)
    {
        this.name=name;
    }

    public void setAge(int age){this.age=age;}

    public void setHealthLevel(int healthLevel){this.healthLevel=healthLevel;}

    public void setHungerLevel(int hungerLevel)
    {
        this.hungerLevel=hungerLevel;
    }

    public void setMoodLevel(int moodLevel)
    {
        this.moodLevel=moodLevel;
    }

    public void setFavoriteFood(String favoriteFood)
    {
        this.favoriteFood=favoriteFood;
    }

    public void setFavoriteRecreation(String favoriteRecreation)
    {
        this.favoriteRecreation=favoriteRecreation;
    }


    public int getId(){return id;}

    public String getName()
    {
        return name;
    }

    public int getAge(){return age;}

    public int getHungerLevel()
    {
        return hungerLevel;
    }

    public int getHealthLevel(){return healthLevel;}

    public int getMoodLevel()
    {
        return moodLevel;
    }

    public String getFavoriteFood()
    {
        return favoriteFood;
    }

    public String getFavoriteRecreation()
    {
        return favoriteRecreation;
    }

    public void moodLevelAnimal(Animal animal)
    {
        System.out.println (animal.getName ()+" is happy");
    }
}

