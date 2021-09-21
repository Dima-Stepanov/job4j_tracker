package ru.job4j.collection;

import java.util.ArrayList;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 0.Коллекции,ArrayList,List,Обобщения[#10094#127190]
 *
 * @since 21.09.2021
 */
public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Petr");
        arrayList.add("Ivan");
        arrayList.add("Stepan");
        for (String array : arrayList) {
            System.out.print(array + ". : ");
        }
    }
}
