package com.company.JavaCore.Lesson_09;

public class JC_Lesson_9_Andrew_F {

    /**
     * 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
     * подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
     * просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
     * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
     * MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     * 3 В методе main() вызвать полученный метод, обработать возможные исключения
     * MyArraySizeException и MyArrayDataException и вывести результат расчета.
     */

    public static void main(String[] args){

        String[][] array =  {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"}
        };

        try {
            sumArray(array);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void sumArray(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if (array.length != 4) throw new MyArraySizeException ("The number of elements in Array[X][] is not equals 4");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException("The number of elements in Array[" + i + "][X] is not equals 4");
            for (int j = 0; j < array[i].length; j++) {
                if(!isNumber(array[i][j])) throw new MyArrayDataException("The value of array[" + i + "][" + j + "] is not a number");
                sum += Integer.parseInt(array[i][j]);
            }
        }
        System.out.println("\nThe size of Array [4][4] is OK!");
        System.out.println("\nSum of elements = " + sum);
    }

    /**
     * Я так понял, что есть возможность не использовать дополнительный метод isNumber, а отлавливать напрямую
     * через try/catch NumberFormatException и потом уже кидать throw new MyArrayDataException?
     * Но не понял как это реализовать и как передать ему параметры ячейки
     * Поэтому оставил ту реализацию, до которой я дошел сам и которая работает
     * Насколько она правильна и был ли вариант еще упростить ее?
     */


    public static boolean isNumber(String a) {
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException  e) {
            return false;
        }
    }

}

