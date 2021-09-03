package com.company.JavaCore.Lesson_08;

import java.lang.reflect.Array;

public class Wall implements Barriers {

    private int height;
    private final String name = "Wall";

    @Override
    public String toString(){
        return name;
    }

    public Wall (int height){
        this.height = height;
    }

    public boolean overcomeBarrier(int maxRun, int maxJump, String participantsName) {
        System.out.print(participantsName + " is jumping");
        for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep(250);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.height <= maxJump) {
            System.out.println("\nThe jump was successful!");
            return true;
        } else {
            System.out.println("\nThe jump was fail! The wall is too high...");
            return false;
        }
    }
}
