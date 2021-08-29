package com.company;

public class Plate {

    private int food;

    public Plate(int food){
//        на всякий случай добавил - по условию ТЗ - вдруг кто-то захочет создать тарелку с отрицательной едой )))
        if(food <= 0){
            System.out.println("You can't create plate with negative value of food!!!");
        } else {
            this.food = food;
        }

    }

    public boolean decreaseFood(int n){
        if(food == 0){
            System.out.println("The plate is empty!!!");
            return false;
        } else if (n > food){
            System.out.println("There is not enough food in the plate!");
            return false;
        } else {
            food -= n;
            return true;
        }

    }

    public void cookMoreFood(int newFood){
        food += newFood;
    }

    public void info(){
        System.out.println("Plate " + food);
    }
}
