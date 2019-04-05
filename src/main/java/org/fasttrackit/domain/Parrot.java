package org.fasttrackit.domain;

public class Parrot extends Animal {
    private String parrotRole;
    private String typeParrot;

    public Parrot(String parrotRole,String typeParrot,int age,int healthLevel)
    {
        super(age,healthLevel);
        this.parrotRole=parrotRole;
        this.typeParrot=typeParrot;
    }

    public void moodLevelAnimal(Animal animal)
    {
        System.out.println (animal.getName ()+" is flying in cage");
    }
}
