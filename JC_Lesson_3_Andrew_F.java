package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JC_Lesson_3_Andrew_F {

    public static void main(String[] args) {

          playGameGuessWords();
//        playGameGuessNumbers();
    }

    /** 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать
        это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем
        загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
        1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */

    // В качестве доп плюшки сделал визуальное оформление оставшихся жизней в виде сердечек )))


    static void playGameGuessNumbers () {
       Scanner scanner = new Scanner(System.in);
       Random random = new Random();
       int game = 1;

       do {
           System.out.println("Guess the number from 0 to 9!");
           System.out.println("You have only 3 attempts!");
           int rightNum = random.nextInt(10);

           for (int i = 3; i > 0; i--){

               String life = "\u2764  ".repeat(i);
               System.out.println(life);
               int answer = scanner.nextInt();
               if (rightNum == answer){
                   System.out.println("Yes, it is " + rightNum + "\nYou are win!");
                   break;
               } else if (i == 1) {
                   System.out.println("Game Over! \nThe right number is " + rightNum);
                   break;
               } else if (rightNum > answer){
                   System.out.println("The right number is bigger");
               } else {
                   System.out.println("The right number is smaller");
               }
               System.out.println("You have only " + (i - 1) + " attempts!");
           }
           System.out.println("Do you want to repeat? \n 1 - Yes \n 2 - No");
           game = scanner.nextInt();
       } while (game == 1);
       System.out.println("See you later!");
    }

    /** 2. Создать массив из слов
      String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
     "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
     "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
     При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если
     слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
     apple – загаданное
     apricot - ответ игрока
     ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     Для сравнения двух слов посимвольно можно пользоваться:
     String str = "apple";
     char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
     Играем до тех пор, пока игрок не отгадает слово.
     Используем только маленькие буквы.
     */

    // В этом задании добавил цикл из прошлого, который позволяет при желании повторить игру. Не пропадать же добру? )))
    // Можно ли было как то решить задачу напрямую сравнивая буквы без преобразования в массив и обратно ???

    static void playGameGuessWords() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int game = 1;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        do {
            String rightWord = words[random.nextInt(words.length)];
            System.out.println("Guess the word! What I want to eat?");

            char[] result = new char[15];

            for (int j = 0; j < 15; j++) {
                result[j] = '\u0023';
            }

            do {
                String answer = scanner.next();
                if (rightWord.equals(answer)) {
                    System.out.println("Yes, it is " + rightWord + "\nYou are win!");
                    break;
                } else {
                    for (int i = 0; i < answer.length() && i < rightWord.length(); i++) {
                        char a = rightWord.charAt(i);
                        char b = answer.charAt(i);
                        if (a == b) result[i] = a;
                    }

                    System.out.println("Let's see right letters! \n");
                    for (int i = 0; i < result.length; i++) {
                        System.out.print(result[i]);
                    }
                   System.out.println("\nLet's try again! Any ideas?");
                }
            } while (true);

            System.out.println("Do you want to repeat? \n 1 - Yes \n 2 - No");
            game = scanner.nextInt();
        } while (game == 1);
        System.out.println("See you later!");
    }

//            for (int i = 3; i > 0; i--){
//
//                String life = "\u2764  ".repeat(i);
//                System.out.println(life);
//                int answer = scanner.nextInt();
//                if (rightNum == answer){
//                    System.out.println("Yes, it is " + rightNum + "\nYou are win!");
//                    break;
//                } else if (i == 1) {
//                    System.out.println("Game Over! \nThe right number is " + rightNum);
//                    break;
//                }else if (rightNum > answer){
//                    System.out.println("The right number is bigger");
//                } else {
//                    System.out.println("The right number is smaller");
//                }
//                System.out.println("You have only " + (i - 1) + " attempts!");
//            }
//            System.out.println("Do you want to repeat? \n 1 - Yes \n 2 - No");
//            game = scanner.nextInt();
//        } while (game == 1);
//        System.out.println("See you later!");
//
//    }
//     result.replace( "result.charAt(i)", rightWord.charAt(i));
//                        result.charAt(i) = rightWord.charAt(i);
//                        result.charAt(i) = rightWord.charAt(i);

}