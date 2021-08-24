package com.company;

public abstract class Animal {

    private int runDistance;
    private int swimDistance;
    private String name;
    private static int count = 0;

    public Animal(){
       count++;
    }

    public static int getCount(){
        return count;
    }
    public  int getRunDistance(int i){
        return runDistance = i;
    }
    public  int getSwimDistance(int i) {
        return swimDistance = i;
    }
    public String getName(String name){
        return this.name = name;
    }

    public void run (int distance){
        if (distance > runDistance){
            System.out.println(name + " can't run so much!!!");
        } else {
            System.out.println(name + " run " + distance + " meters");
        }
    }

    public void swim(int distance) {
        if (swimDistance == 0){
            System.out.println(getName(name) + " can't swim at all!!!");
        } else if (distance > swimDistance){
            System.out.println(name + " can't swim so much!!!");
        } else {
            System.out.println(name + " swim " + distance + " meters");
        }
    }

}
