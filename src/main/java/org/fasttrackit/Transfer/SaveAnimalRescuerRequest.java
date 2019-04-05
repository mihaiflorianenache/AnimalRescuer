package org.fasttrackit.Transfer;

public class SaveAnimalRescuerRequest {

    private String name;
    private int age;
    private int healthLevel;
    private int hungerLevel;
    private int moodLevel;
    private String favoriteFood;
    private String favoriteRecreation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = moodLevel;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteRecreation() {
        return favoriteRecreation;
    }

    public void setFavoriteRecreation(String favoriteRecreation) {
        this.favoriteRecreation = favoriteRecreation;
    }

    @Override
    public String toString() {
        return "SaveAnimalRescuerRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", healthLevel=" + healthLevel +
                ", hungerLevel=" + hungerLevel +
                ", moodLevel=" + moodLevel +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", favoriteRecreation='" + favoriteRecreation + '\'' +
                '}';
    }
}
