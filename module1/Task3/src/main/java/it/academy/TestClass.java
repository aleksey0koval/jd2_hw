package it.academy;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
            System.out.print(list.get(i) + " ");
        }
        if (!list.isEmpty()) {
            System.out.println();
        }
        System.out.println(average(list));

    }

    public static double average(List<Integer> list) {
        int summ = 0;
        for (Integer s : list) {
            summ += s;
        }

        if (list.isEmpty()) {
            System.out.println("Empty list!!!");
            return 0;
        } else {
            return (double) summ / list.size();
        }
    }
}
