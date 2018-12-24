package com.example.concurrency;

class Runner1 {
    public void startRun() {
        for (int i = 0; i< 10; i++) {System.out.println("Runner1:" + i);}
    }
}

class Runner2 {
    public void startRun() {
        for (int i = 0; i< 10; i++) {System.out.println("Runner2:" + i);}
    }
}
public class SequentialExample {

    public static void main(String[] args) {
        Runner1 r1 = new Runner1();
        Runner2 r2 = new Runner2();
        r1.startRun();
        r2.startRun();
    }
}
