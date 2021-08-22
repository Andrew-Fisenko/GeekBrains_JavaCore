package com.company;

        /**
        *    1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
        *    2. Конструктор класса должен заполнять эти поля при создании объекта.
        *    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
        *    4. Создать массив из 5 сотрудников. Пример: Person[] persArray = new Person[5]; // Вначале объявляем массив
        *    объектов persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        *    // потом для каждой ячейки массива задаем объект persArray[1] = new Person(...); ... persArray[4] = new Person(...);
        *    5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет
        */

public class JC_Lesson_5_Andrew_F {

    public static void main(String[] args) {

        Employee[] employeeArray = new Employee[5];
            employeeArray[0] = new Employee("Serj Fild", "director", "abc.dir@mail.ru", 656501, 6000, 45);
            employeeArray[1] = new Employee("John Khorr", "engineer", "abc.eng@mail.ru", 656510, 4000, 42);
            employeeArray[2] = new Employee("Konstantin Nikolaev", "manager", "abc.man@mail.ru", 656522, 4500, 36);
            employeeArray[3] = new Employee("Stephan Shmith", "developer", "abc.dev1@mail.ru", 656650, 3500, 28);
            employeeArray[4] = new Employee("Andrew Green", "developer", "abc.dev2@mail.ru", 656651, 3500, 30);

    int age = 40;
    printEmployeeSortAge(employeeArray, age);

    }

    static void printEmployeeSortAge (Employee[] employeeArray, int age){
        for(int i = 0; i < employeeArray.length; i++){
            if (employeeArray[i].getAge() > age){
                employeeArray[i].printEmployeeInfo();
            }
        }
    }

}
