package com.company.JavaCore.Lesson_08;

public class Treadmill implements Barriers{

    private int length;
    private final String name = "Treadmill";

    @Override
    public String toString(){
        return name;
    }

    public Treadmill (int length){
        this.length = length;
    }

    public boolean overcomeBarrier(int maxRun, int maxJump, String participantsName) {
        System.out.print(participantsName + " is running");
        for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep(250);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.length <= maxRun) {
            System.out.println("\nThe run was successful!");
            return true;
        } else {
            System.out.println("\nThe run was fail! The distance is too long...");
            return false;
        }
    }
}
