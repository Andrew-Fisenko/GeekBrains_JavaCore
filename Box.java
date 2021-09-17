package com.company.JavaCore.Lessson_11;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{

    private List<T> fruits = new ArrayList<>();

    public List<T> getFruits() {
        return fruits;
    }

    // этот метод нужен по условию
    public void addIntoBox(T item){
       fruits.add(item);
    }

    // добавил свой метод, чтобы быстрее наполнять коробки
    public void full(T item, int count){
        int i = 0;
        while (i < count){
           fruits.add(item);
            i++;
        }
    }

    public void transferFruits(Box<T> other){
       other.getFruits().addAll(getFruits());
       getFruits().clear();
    }

    public boolean compare(Box<? extends Fruit> other){
        if (getWeight() == other.getWeight()){
            System.out.println("Boxes have equal weight");
            return true;
        } else {
            System.out.println("Boxes have not equal weight");
            return false;
        }
    }

    public float getWeight(){
        if (fruits.size() == 0){
            return 0F;
        } return fruits.size() * fruits.get(0).getWeight();
    }
}
