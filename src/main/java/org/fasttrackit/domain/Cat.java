package org.fasttrackit.domain;

public class Cat extends Animal {
    private String catRole;
    private boolean catCleansItself;
    private String catBreed;

    public Cat(String catRole,boolean catCleansItself,int age,int healthLevel)
    {
        super(age,healthLevel);
        this.catRole=catRole;
        this.catCleansItself=catCleansItself;
    }

    public void moodLevelAnimal(Animal animal)
    {
        System.out.println (animal.getName ()+" purrs");
    }
}
