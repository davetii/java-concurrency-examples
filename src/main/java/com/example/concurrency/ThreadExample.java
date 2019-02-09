package com.example.concurrency;


import java.util.*;

class Runner extends Thread {
    private List<String> list = new LinkedList<>();
    public Runner(String[] s) {
        Collections.addAll(list, s);
    }
    @Override
    public void run() {
        list.forEach( System.out::println);
    }
}

public class ThreadExample {

    public static void main(String[] args)  {
        String[] list1 = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10"};
        String[] list2 = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10" };
        Runner t1 = new Runner(list1);
        Runner t2 = new Runner(list2);
        t1.start();
        t2.start();

        /*
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        System.out.println("finish the tasks");
    }
}
