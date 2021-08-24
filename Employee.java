package com.company;


public class Employee {

    private String name;
    private String position;
    private String email;
    private int phone;
    private int salary;
    private int age;

    public Employee (String name, String position, String email, int phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }
        public int getAge() {
            return age;
        }

    void printEmployeeInfo (){
        System.out.printf("Name: %s Position: %s E-mail: %s Phone: %s Salary: %s Age: %s %n", name, position, email, phone, salary, age);
    }
}


