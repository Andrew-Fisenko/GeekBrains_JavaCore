package com.company.JavaCore.Lesson_08;

public class JC_Lesson_8_Andrew_F {

    /**
     * 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
     * классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
     * консоль).
     * 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
     * должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
     * печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
     * 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
     * этот набор препятствий.
     * 4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
     * на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
     * препятствий не идет.
     */

    /**
     * ВОПРОС. Обязательно ли в своствах участников ставить final, если параметры максимального бега и прыжка не будут
     * меняться. Они Private, setter'ов я не делал - ставить final или это избыточно???
     *
     * Пришлось создавать ЛЕОПАРДОВ, так как КОТЫ и КОТЯТЫ на Git'e уже имеются, полагаю тогда при Merge будет конфликт?
     * Если названия классов одинаковые для разных заданий - раскидывать их по папкам на Git'e или делать разные
     * классы изначально? )))
     *
     * P.S. Очень понравилось, как реализовывалась задержка, поэтому не смог ее не добавить в код )))
     */

    public static void main(String[] args) {

        Participants[] participants = new Participants[3];
            participants[0] = new Human("Bob");
            participants[1] = new Leopard("Martin");
            participants[2] = new Robot("Robocop");

        Barriers[] barriers = new Barriers[5];
            barriers[0] = new Wall(2);
            barriers[1] = new Treadmill(2000);
            barriers[2] = new Wall(3);
            barriers[3] = new Treadmill(5000);
            barriers[4] = new Wall(4);

        startRace(participants, barriers);

    }

    public static void startRace(Participants[] participants, Barriers[] barriers) {
        for (Participants participant : participants) {
            System.out.println(participant.toString() + " start the race!\n");
            for (int j = 0; j < barriers.length; j++) {
                System.out.println("The " + (j + 1) + " barrier is the " + barriers[j].toString());
                if (!barriers[j].overcomeBarrier(participant.getMaxRun(), participant.getMaxJump(), participant.toString())) {
                    System.out.println("\nThe race for " + participant + " is over!\n");
                    break;
                }
                System.out.println(" ");
                if (j == barriers.length - 1) {
                    System.out.println("The " + participant + " finished the race!!!\n");
                }
            }
        }
    }
}
