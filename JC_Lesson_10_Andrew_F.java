package com.company.JavaCore.Lesson_10;

import java.util.*;

public class JC_Lesson_10_Andrew_F {

    /** 1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
        вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать, сколько раз встречается каждое слово.
        2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
        телефонных номеров. В этот телефонный справочник с помощью метода add() можно
        добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
        учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не
        добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с
        пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки
        телефонного справочника.
     */

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("pear");
        fruits.add("pineapple");
        fruits.add("plum");
        fruits.add("grapes");
        fruits.add("peach");
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("banana");
        fruits.add("pear");
        fruits.add("plum");
        fruits.add("orange");
        fruits.add("lemon");
        fruits.add("banana");


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Vlasov", "774215");
        phoneBook.get("Vlasov");
        phoneBook.get("Ivanov");
        phoneBook.get("Smirnoff");
        phoneBook.get("Golubev");
        phoneBook.get("Petrov");
        phoneBook.get("Smirnov");
        phoneBook.get("Chernov");


        countItems(fruits);
        System.out.println(fruits);
    }

    public static void countItems(ArrayList<String> array) {
        Collections.sort(array);
        Set<String> arrWithoutDuplicats = new LinkedHashSet<>();
        for (int i = 0; i < array.size(); i++) {
            int count = 1;
            for (int j = 0; j < array.size(); j++) {
                if (i == j) {
                } else if (array.get(i).equals(array.get(j))) {
                    count++;
                }
            }
            arrWithoutDuplicats.add(array.get(i) + " = " + count);
        }
        System.out.println();
        for(String item : arrWithoutDuplicats)
            System.out.println(item);
    }
}
