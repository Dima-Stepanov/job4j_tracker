package ru.job4j.oop;

/**
 * 1.2.1.Классы и объекты
 * 1.8.Состояние объекта [#167388#127056]
 */
public class Battery {
    private int load;

    public Battery(int charge) {
        this.load = charge;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery = new Battery(30);
        Battery donar = new Battery(45);
        System.out.println("battary load :" + battery.load);
        System.out.println("donar load :" + donar.load);
        donar.exchange(battery);
        System.out.println("battary load :" + battery.load);
        System.out.println("donar load :" + donar.load);
    }
}
