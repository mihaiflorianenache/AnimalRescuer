package org.fasttrackit.domain;

public class Dog extends Animal {
    private String dogRole;
    private boolean dogCleansItself;
    private String dogBreed;

    public Dog(String dogRole,boolean dogCleansItself,int age,int healthLevel)
    {
        super(age,healthLevel);
        this.dogRole=dogRole;
        this.dogCleansItself=dogCleansItself;
    }

    public void moodLevelAnimal(Animal animal)
    {
        System.out.println (animal.getName ()+" is moving his tail");
    }
}

