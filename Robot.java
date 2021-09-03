package com.company.JavaCore.Lesson_08;

public class Robot implements Participants{

    private int maxRun = 10000;
    private int maxJump = 5;
    private String name;

    public Robot(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Robot " + name;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void run(){
        System.out.println("Robot run...");
    }

    public void jump(){
        System.out.println("Robot jump...");
    }

}

