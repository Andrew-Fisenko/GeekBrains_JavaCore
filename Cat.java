package com.company;

public class Cat extends Animal{

    private static int count = 0;

    public Cat (String name){
        this.getRunDistance(200) ;
        this.getSwimDistance(0);
        this.getName(name);
        count++;
    }

    public static int getCount(){
        return count;
    }

}
