package com.company;

public class Dog extends Animal{

    private static int count = 0;

    public Dog (String name){
        super.getRunDistance(500) ;
        super.getSwimDistance(10);
        super.getName(name);
        count++;
    }

    public static int getCount(){
        return count;
    }

}
