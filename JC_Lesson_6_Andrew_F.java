package com.company;

public class JC_Lesson_6_Andrew_F {

    /**
     * 1. Создать классы Собака и Кот с наследованием от класса Животное.
     * 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
     * Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
     * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
     * плавание: кот не умеет плавать, собака 10 м.).
     * 4. Добавить подсчет созданных котов, собак и животных.
     */

    public static void main(String[] args) {

        Cat cat1 = new Cat("Tom");
        cat1.run(150);
        cat1.swim(50);

        Cat cat2 = new Cat("Kitty");
        cat2.run(300);
        cat2.swim(100);

        Dog dog1 = new Dog("Bob");
        dog1.run(100);
        dog1.swim(5);

        Dog dog2 = new Dog("Bobik");
        dog2.run(750);
        dog2.swim(10);

        Dog dog3 = new Dog("Doggie");
        dog3.run(350);
        dog3.swim(15);

        printCountOfAnimals();
    }


    public static void printCountOfAnimals (){
        System.out.println("");
        System.out.println("You create " + Cat.getCount() + " cats");
        System.out.println("You create " + Dog.getCount() + " dogs");
        System.out.println("You create " + Animal.getCount() + " animals");
    }

}
