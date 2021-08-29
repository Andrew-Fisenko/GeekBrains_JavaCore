package com.company;


/**
     * 1. Расширить задачу про котов и тарелки с едой.
     * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
     * (например, в миске 10 еды, а кот пытается покушать 15-20).
     * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
     * удалось покушать (хватило еды), сытость = true.
     * 4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
     * наполовину сыт (это сделано для упрощения логики программы).
     * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
     * потом вывести информацию о сытости котов в консоль.
     * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
     */

public class JC_Lesson_7_Andrew_F {

    public static void main(String[] args) {

        Kitty[] kittyArray = new Kitty[5];
            kittyArray[0] = new Kitty("Murka", 10);
            kittyArray[1] = new Kitty("Lizzi", 15);
            kittyArray[2] = new Kitty("Belka", 20);
            kittyArray[3] = new Kitty("Cherepashchka", 5);
            kittyArray[4] = new Kitty("ProstoKoshka", 15);

        Plate plate = new Plate(50);
        plate.info();

        feedKitty(kittyArray, plate);

        printInfoFullnessKitty(kittyArray);

        plate.cookMoreFood(50);
        plate.info();

    }

    /** Возник вопрос - следующим методам я даю на вход массив Kitty, где Kitty указание класса
     * А как сделать, чтоб метод мог принимать массив другого класса, скажем собак? Если наследование не использовать, можно ли как-то
     * прописать универсальный параметр, чтобы передавался любой массив? И все работало
     * А то получается бессмысленно создавать такие методы - я бы просто в main написал бы просто тело метода и все, так короче,
     * зачем делать метод, который работает только для котов ))
     *
     */

    public static void feedKitty(Kitty Array[], Plate plate){
        for (int i = 0; i < Array.length; i++){
            Array[i].eat(plate);
        }
    }

    public static void printInfoFullnessKitty(Kitty Array[]){
        for(int i = 0; i < Array.length; i++){
            if (Array[i].getFullness() == true){
                System.out.println("Kitty " + Array[i].getName() + " is full )");
            } else {
                System.out.println("Kitty " + Array[i].getName() + " is hungry... (((");
            }
        }
    }

}







