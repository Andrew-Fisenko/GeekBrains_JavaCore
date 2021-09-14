package com.company.JavaCore.Lesson_08;

public class Leopard implements Participants {

    private int maxRun = 4000;
    private int maxJump = 3;
    private String name;

    public Leopard(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Leopard " + name;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void run(){
        System.out.println("Leopard run...");
    }

    public void jump(){
        System.out.println("Leopard jump...");
    }

}

