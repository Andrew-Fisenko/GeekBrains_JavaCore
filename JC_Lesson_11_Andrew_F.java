package com.company.JavaCore.Lessson_11;

import com.company.JavaCore.Lesson_10.PhoneBook;

import java.util.*;

public class JC_Lesson_11_Andrew_F {

    /**
     * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого
     * ссылочного типа);
     * 2. Написать метод, который преобразует массив в ArrayList
     *
     */

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("pear");
        fruits.add("pineapple");
        fruits.add("plum");
        fruits.add("grapes");
        fruits.add("peach");
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("lemon");

        System.out.println(fruits);
        System.out.println(rotateTwoItems("apple", "lemon", fruits));

        Integer[] arr = {11, 31, 48, 33, 21, 27, 87, 54, 10, 96, 1, 76};

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    // Проверил не двух разных массивах и езе раз проверил метод из первой части задания

        System.out.println(arrayToArrayList(arr));
        System.out.println(arrayToArrayList(words));
        System.out.println(rotateTwoItems("apple", "lemon", arrayToArrayList(words)));

        Apple apple  = new Apple();
        Orange orange  = new Orange();

        Box <Apple> box1 = new Box<>();
        Box <Orange> box2 = new Box<>();
        Box <Apple> box3 = new Box<>();

        box1.full(apple,15);
        box2.full(orange, 20);
        box3.full(apple,30);

        box1.compare(box2);
        box2.compare(box3);

        System.out.println("\nThe weight of the box - " + box1.getWeight());
        System.out.println("The weight of the box - " + box2.getWeight());
        System.out.println("The weight of the box - " + box3.getWeight());

        box1.transferFruits(box3);

        System.out.println("\nThe weight of the box - " + box1.getWeight());
        System.out.println("The weight of the box - " + box2.getWeight());
        System.out.println("The weight of the box - " + box3.getWeight());

    }

    public static <T> List<T> rotateTwoItems(T first, T second, List<T> values){
          if(values.contains(first) && values.contains(second)){
                int i = values.indexOf(first);
                int j = values.indexOf(second);
                values.set( i, second );
                values.set( j, first );
                System.out.println("Rotation done!");
            // Добавил эти блоки, чтобы определить какого именно элемента нет в массиве, без них можно в одну строчку -
            // но решил, что иначе причина будет не так ясна
            } else if(values.contains(first)){
                System.out.println("Element " + second + " was not found!");
            } else if(values.contains(second)){
                System.out.println("Element " + first + " was not found!");
            } else {
                System.out.println("Elements " + first + " and " +  second + " were not found!");
            }
            return values;
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] array){
        ArrayList<T> arrayList = new ArrayList<T>();
        int i = 0;
        while (i < array.length){
            arrayList.add(array[i]);
            i++;
        }
        return arrayList;
    }
}

