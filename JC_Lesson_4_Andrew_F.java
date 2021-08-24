package com.company;


import java.util.Random;
import java.util.Scanner;

public class JC_Lesson_4_Andrew_F {

    public static void main(String[] args) {
        start();
    }

    /**
     * 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в
     * методичку.
     * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
     * например, с использованием циклов.
     * 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
     * количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
     * возможных ситуаций;
     * 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрок
     */

    /** README )))
    * Все 4 задания реализованы в одной программе:
    * - есть возможность выбора размера поля (я ограничил для удобства от 3 до 10)
    * - есть возможность выбора количества ячеек для победы (от 3 до размера поля)
    * - проверка победы работает на любом поле с любым количеством ячеек для победы
    * - AI блокирует ходя как по горизонтали и вертикали, так и по диагонали
    *
    * Я почти убежден, что нагородил огромное количество лишнего кода, но к сожалению не придумал как его можно сократить
    * или реализовать идеи по другому. Там где хватило бы небольшого домика - я построил башню )
    * Если есть возможность, подскажи, как можно было бы хоть немного этого избежать )))
    *
    * P.S. Я оставил несколько комментариев в коде, чтобы было чуть проще меня понять, мне кажется я слишком все завернул )
    */

    static void start (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the size of the field! [min 3 - max 10]");
        int size = scanner.nextInt();
        while (size > 10 || size < 3 ){
            System.out.println("Please write correct size!");
            size = scanner.nextInt();
        }
        char[][] field = createField(size);
        System.out.println("Choose the number of cell to win!");
        System.out.println("Note: number must be equal or less than size of the field, but more than 3");
        int cellToWin = scanner.nextInt();
        while (cellToWin > size || cellToWin < 3){
            System.out.println("Please write correct number!");
            cellToWin = scanner.nextInt();
        }

        do{
            doPlayerMove(field, size);
            drawField(field);
            if (isWin(field, 'X', cellToWin)){
                System.out.println("You are winner!!!");
                break;
            }
            if (isDraw(field)){
                System.out.println("Oh! It's look like a draw...");
                break;
            }

            doAIMove(field, cellToWin);
            drawField(field);
            if (isWin(field, 'O', cellToWin)){
                System.out.println("Oops, you are lose :(");
                break;
            }
            if (isDraw(field)){
                System.out.println("Oh! It's look like a draw...");
                break;
            }
        } while (true);
    }

    // Проверка победы проверяет в таком порядке - горизонтали, вертикали, диагонали, обратные диагонали
    // Работает в зависимости от количества ячеек нужных ля победы, постепенно сдвигая матрицу размера (cellToWin) слева направо
    // для каждого ряда

     static boolean isWin(char[][] field, char symbol, int cellToWin ){
           for (int i0 = 0; i0 <= (field.length - cellToWin); i0++){
              for (int j0 = 0; j0 <= (field.length - cellToWin); j0++){
                   for (int i = i0; i < cellToWin + i0; i++ ) {
                       int count = 0;
                       for (int j = j0; j < cellToWin + j0; j++ ) {
                           if (field [i][j] != symbol) {
                           } else {
                               count++;
                               if (count == cellToWin){
                                  return true;
                               }
                           }
                       }
                   }
               }
           }

           for (int i0 = 0; i0 <= (field.length - cellToWin); i0++ ){
               for (int j0 = 0; j0 <= (field.length - cellToWin); j0++){
                   for (int j = i0; j < cellToWin + i0; j++){
                       int count = 0;
                       for (int i = j0; i < cellToWin + j0; i++){
                           if (field [i][j] != symbol){
                           } else {
                               count++;
                               if (count == cellToWin){
                                   return true;
                               }
                           }
                       }
                   }
               }
           }

           for (int i0 = 0; i0 <= (field.length - cellToWin); i0++){
               for (int j0 = 0; j0 <= (field.length - cellToWin); j0++){
                   int count = 0;
                   for (int i = 0; i < cellToWin; i++) {
                      if (field [i + i0][i + j0] != symbol) {
                      } else {
                          count++;
                          if (count == cellToWin){
                              return true;
                          }
                      }
                   }
               }
           }

           for (int i0 = 0; i0 <= (field.length - cellToWin); i0++ ){
               for (int j0 = 0; j0 <= (field.length - cellToWin); j0++){
                   int count = 0;
                   for (int i = 0; i < cellToWin; i++) {
                       if (field [i + i0][field.length - 1 - j0 - i] != symbol) {
                       } else {
                           count++;
                           if (count == cellToWin){
                               return true;
                           }
                       }
                   }
               }
           }
           return false;
       }

    static boolean isDraw(char[][] field){
        for (int i = 0; i < field.length; i ++) {
            for (int j = 0; j < field.length; j++) {
                if (isFreeSell(field, i, j)){
                    return false;
                }
            }
        }
        return true;
     }

    static char [][] createField(int size){
        char[][] field = new char[size][size];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = '-';
            }
        }
        return field;
    }

    static void doPlayerMove(char [][] field, int size){
        int h, v;
        do {
            h = getCoordinate(field.length - 1, 'h', size);
            v = getCoordinate(field.length - 1, 'v', size);
        } while (isNotFreeSell(field, h, v));

        field[h][v] = 'X';
    }

    // AI считает сумму всех Х в каждой строке, столбца, диагонали, обратной диагонали (в таком вот порядке)
    // Работает в два цикла - сначала проверяет есть ли где количество Х на 1 меньшее (иначе не сработает на поле 3х3),
    // чем нужно дл победы, потом на 2 меньшее, чем нужно для победы.
    // Если находит такое место - ставит туда 0, если нет такого места - ставит 0 случайно.
    // Использует 8 методов - 4 метода для определения наличия свободных ячеек во всех видах рядов (верт, гориз, диаг и обр диаг)
    // нужно для того, чтобы избежать ситуации, когда он захочет походить в уже занятую им же ячейку
    // (это используется, когда для победы нужно собрать меньше ячеек, чем размер поля)
    // и еще 4 метода, возвращающие координаты ячейки, в которую будет сделан ход.
    // Слабые сторон AI
    // - на больших полях с условием победы меньше, чем размер поля, не обращает внимания на маленькие диагонали
    // - на больших полях с условием победы меньше, чем размер поля, ставит 0 в нужный ряд, но может поставить далеко
    // от Х (например 5 в ряд на поле из 10 - 0 может встать в нужный ряд, но далеко от XXX и не перекрыть след ход)
    //
    // P.S. Я не знал как сделать полный выход из всех циклов (их получилось слишком много) - поэтому сделал возвратный метод
    // который возвращает значения, которое мне не нужно (просто чтобы выйти). Как это можно было реализовать по-человечески? )))
    // break даже с указанием точки выхода все равно переключается на след цикл for...

    static char doAIMove (char [][] field, int cellToWin){
        Random random = new Random();
        for(int iqAI = 1; iqAI <= 2; iqAI++) {
            for (int h = 0; h < field.length; h++) {
                int count = 0;
                for (int v = 0; v < field.length; v++) {
                    if (field[h][v] == 'X') {
                        count++;
                        if (count == cellToWin - iqAI && isFreeCellStroke(field, h)) {
                            int x = doAICellStroke(field, h);
                            field[h][x] = 'O';
                            return '!';
                        }
                    }
                }
            }

            for (int v = 0; v < field.length; v++) {
                int count = 0;
                for (int h = 0; h < field.length; h++) {
                    if (field[h][v] == 'X') {
                        count++;
                        if (count == cellToWin - iqAI && isFreeCellColumn(field, v)) {
                            int x = doAICellColumn(field, v);
                            field[x][v] = 'O';
                            return '!';
                        }
                    }
                }
            }
            int count = 0;

            for (int h = 0; h < field.length; h++) {
                if (field[h][h] == 'X') {
                    count++;
                    if (count == cellToWin - iqAI && isFreeCellDiag(field)) {
                        int x = doAICellDiag(field);
                        field[x][x] = 'O';
                        return '!';
                    }

                }
            }
            int count2 = 0;
            for (int h = 0; h < field.length; h++) {
                if (field[h][field.length - 1 - h] == 'X') {
                    count2++;
                    if (count2 == cellToWin - iqAI && isFreeCellDiag2(field)) {
                        int x = doAICellDiag2(field);
                        field[x][field.length - 1 - x] = 'O';
                        return '!';
                    }
                }
            }
        }
        int v, h;
        do {
            h = random.nextInt(field.length);
            v = random.nextInt(field.length);
        } while (isNotFreeSell(field, h, v));
        field [h][v] = 'O';
        return '!';
    }

    static boolean isFreeCellDiag (char[][] field){
        for (int h = 0; h < field.length; h++){
            if (field[h][h] == '-'){
                return true;
            }
        } return false;
    }

    static boolean isFreeCellDiag2 (char[][] field){
        for (int h = 0; h < field.length; h++){
            if (field[h][field.length - 1 - h] == '-'){
                return true;
            }
        } return false;
    }

    static boolean isFreeCellStroke (char[][] field, int h){
        for (int v = 0; v < field.length; v++){
            if (field[h][v] == '-'){
                return true;
            }
        } return false;
    }

    static boolean isFreeCellColumn (char[][] field, int v){
        for (int h = 0; h < field.length; h++){
            if (field[h][v] == '-'){
                return true;
            }
        } return false;
    }

    static int doAICellDiag (char[][] field){
        for (int h = 0; h < field.length; h++){
            if (field[h][h] == '-'){
                return h;
            }
        } return 0;
    }

    static int doAICellDiag2 (char[][] field){
        for (int h = 0; h < field.length; h++){
            if (field[h][field.length - 1 - h] == '-'){
                return h;
            }
        } return 0;
    }
    static int doAICellStroke (char[][] field, int h){
        for (int v = 0; v < field.length; v++){
            if (field[h][v] == '-'){
                return v;
            }
        } return 0;
    }

    static int doAICellColumn (char[][] field, int v){
        for (int h = 0; h < field.length; h++){
            if (field[h][v] == '-'){
                return h;
            }
        } return 0;
    }



    static boolean isFreeSell (char[][] field, int h, int v) {
        return field[h][v] == '-';
    }

    static boolean isNotFreeSell (char[][] field, int h, int v) {
        return !isFreeSell(field, h, v);
    }

    static int getCoordinate (int lastIndex, char coordName, int size){
        Scanner scanner = new Scanner(System.in);
        int coord;
        do {
           System.out.printf("Please enter %s-coordinare... [1 - %s]%n", coordName, size);
           coord = scanner.nextInt() - 1;
        } while (coord < 0 || coord > lastIndex);
        return coord;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i ++){
            for (int j = 0; j< field.length; j++){
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
