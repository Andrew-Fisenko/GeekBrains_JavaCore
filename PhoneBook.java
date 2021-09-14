package com.company.JavaCore.Lesson_10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> phoneArchive = new HashMap<>();
    {
            phoneArchive.put("Ivanov", List.of("348578", "557899"));
            phoneArchive.put("Petrov", List.of("534458"));
            phoneArchive.put("Golubev", List.of("859624", "489957"));
            phoneArchive.put("Smirnov", List.of("357488"));
            phoneArchive.put("Chernov", List.of("115862"));
        };

    public void add(String name, String number){
        phoneArchive.put(name, List.of(number));
//        System.out.printf("\nСontact [%s %s] was successfully added!\n", name, number);
    }

     public void get(String name){
        if(phoneArchive.get(name) == null){
            System.out.println(name + " is not founded");
        } else {
            System.out.println(name + phoneArchive.get(name));
        }

    }

}
