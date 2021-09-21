package com.company.JavaCore.Lesson_12;

import java.util.Arrays;

public class JC_Lesson_12_Andrew_F {

   /** Необходимо написать два метода, которые делают следующее:
        1) Создают одномерный длинный массив
        2) Заполняют этот массив единицами.
        3) Засекают время выполнения.
        4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле.
        5) Проверяется время окончания метода.
        6) В консоль выводится время работы.
        Отличие первого метода от второго:
            - Первый просто бежит по массиву и вычисляет значения.
            - Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает
            эти массивы обратно в один.
   */

    final static int size = 10_000_000;
    final static int half = size / 2;

    public static void main(String[] args) {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        runMetod1(arr);
        runMetod2(arr);
    }

    public static void runMetod1(float[] arr) {
        System.out.println("\nMethod 1 is starting...");
        long start = System.currentTimeMillis();
        doCount(arr);
        System.currentTimeMillis();
        System.out.println("Method 1 finished!");
        System.out.println("Working time of Method 1 - " + (System.currentTimeMillis() - start));
    }

    public static void runMetod2(float[] arr) {
        System.out.println("\nMethod 2 is starting...");
        long start = System.currentTimeMillis();

        float[] arr1 = new float[half];
        float[] arr2 = new float[half];

        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);

        Thread t1 = new Thread(() -> {
            doCount(arr1);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            doCount(arr2);
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);

        System.currentTimeMillis();
        System.out.println("Method 2 finished!");
        System.out.println("Working time of Method 2 - " + (System.currentTimeMillis() - start));
    }

    public static void doCount(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}

