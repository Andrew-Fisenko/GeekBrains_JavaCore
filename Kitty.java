package com.company;

public class Kitty {

    private String name;
    private int appetite;
    private boolean fullness;

    public boolean getFullness() {
        return fullness;
    }

    public String getName() {
        return name;
    }

    public Kitty(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }
    // Вообще гораздо проще сразу указать наелся ли от или нет - я так и сделал, но я так понял, что по условию задачи
// от меня ждут не этого, а использования параметра fullness. Так и переделал ))
    public void eat(Plate p){
        if(p.decreaseFood(appetite) == true) {
//            System.out.println("Kitty " + this.name + " is full )");
            this.fullness = true;
        }
//        } else {
//            System.out.println("Kitty " + this.name + " is hungry... (((");
//        }
    };


}
