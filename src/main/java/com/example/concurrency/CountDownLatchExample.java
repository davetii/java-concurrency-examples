package com.example.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableWorker implements Runnable {

    private int id;
    private CountDownLatch countDownLatch;
    private Random random;

    public RunnableWorker(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        doWork();
        countDownLatch.countDown();
    }

    private void doWork() {
        System.out.println("Thread with id " + this.id  + " starts working...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class CountDownLatchExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CountDownLatch latch =  new CountDownLatch(5);
        for (int i = 0; i<5; i++ ) {
            executorService.execute(new RunnableWorker(i, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("All the pre-requisites have completed...");

    }
}
