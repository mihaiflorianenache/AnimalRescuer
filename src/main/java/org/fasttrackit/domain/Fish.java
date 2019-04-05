package org.fasttrackit.domain;

public class Fish extends Animal {
    private String fishRole;
    private String typeFish;

    public Fish(String fishRole,String typeFish,int age,int healthLevel)
    {
        super(age,healthLevel);
        this.fishRole=fishRole;
        this.typeFish=typeFish;
    }

    public void moodLevelAnimal(Animal animal)
    {
        System.out.println (animal.getName ()+" is swimming in water");
    }
}
