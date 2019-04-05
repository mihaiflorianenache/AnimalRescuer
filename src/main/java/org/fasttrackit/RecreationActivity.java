package org.fasttrackit;

public class RecreationActivity {

    private String name;
    private int timeActivity;
    private String placeActivity;

    RecreationActivity(String name,int timeActivity,String placeActivity)
    {
        this.name=name;
        this.timeActivity=timeActivity;
        this.placeActivity=placeActivity;
    }

    public String getName()
    {
        return name;
    }
}

