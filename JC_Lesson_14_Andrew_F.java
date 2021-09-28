package gb.ru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JC_Lesson_14_Andrew_F {

    /**
     * 1.	Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. 4
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
     * необходимо выбросить RuntimeException.
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     * 2.	Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки
     * или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * [ 1 1 1 4 4 1 4 4 ] -> true
     * [ 1 1 1 1 1 1 ] -> false
     * [ 4 4 4 4 ] -> false
     * [ 1 4 4 1 1 4 3 ] -> false
     */

    static final Logger log = LogManager.getLogger(JC_Lesson_14_Andrew_F.class);

    public static void main(String[] args) {
    // Не стал удалять блок с запуском методов (хотя все проверено через тесты))


        int[] arr = {1, 4, 5, 8, 4, 4, 8, 0, 5};
        int[] arr2 = {1, 2, 5, 8, 3, 6, 8, 0, 5};
        try {
            String intArrayString = Arrays.toString(returnArrayAfterLastNumber4(arr));
            System.out.println(intArrayString);
            String intArrayString2 = Arrays.toString(returnArrayAfterLastNumber4(arr2));
            System.out.println(intArrayString2);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
//
//        int[] arr3 = {1, 5, 4, 1, 4, 4, 1, 4, 4};
//        int[] arr4 = {1, 1, 1, 4, 1, 1, 1, 1, 1};
//
//       checkArrayFor1and4(arr4);

    }

    public static int[] returnArrayAfterLastNumber4(int[] arr) throws RuntimeException {
        int position4 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                position4 = i;
            }
        }
        int[] arrayNew = new int[arr.length - position4 - 1];
        if (position4 == -1) {
            log.error("There is no number 4 in array!");
            throw new RuntimeException();
        }
        for (int j = 0; position4 + 1 + j < arr.length; j++)
            arrayNew[j] = arr[position4 + 1 + j];
        return arrayNew;
    }

    public static boolean checkArrayFor1and4(int[] arr) {
        // Сначала циклом проверяю - только ли 1 и 4 в массиве
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] == 1 || arr[i] == 4) {
                if (i == arr.length - 1){
                    // Если массив только из 1 и 4 - проверяю одновременное условие на contains 1 и 4
                    Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
                    ArrayList intList = new ArrayList(Arrays.asList(array));
                    if (intList.contains(1) && intList.contains(4)) {
                        System.out.println("The Array contains only 1 and 4 numbers!");
                        return true;
                    } else {
                        System.out.println("The Array contains NOT only 1 and 4 numbers!");
                        return false;
                    }
                }
            } else {
                System.out.println("The Array contains NOT only 1 and 4 numbers!");
                return false;
            }
        }
        System.out.println("The Array contains NOT only 1 and 4 numbers!");
        return false;
    }

}




//}
//  for (int element : arr) {
//          if (element == 1) {
//          for (int element2 : arr) {
//          if (element2 == 4) {
//          return true;
//          }
//          }
//          } else {
//          return false;
//          }
//          } return false;