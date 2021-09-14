package com.company.JavaCore.Lesson_08;

public class Human implements Participants {

    private int maxRun = 2000;
    private int maxJump = 2;
    private String name;

    public Human(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Human " + name;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void run(){
        System.out.println("Human run...");
    }

    public void jump(){
        System.out.println("Human jump...");
    }


}

