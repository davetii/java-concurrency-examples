package com.example.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class CallableProcessor implements Callable<String> {

    private int id;

    public CallableProcessor(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        Thread.sleep(1000);
        return "id_" + id;
    }
}
public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<Future<String>>();

        for(int i = 0; i <= 5; i++) {
            Future<String> future = executorService.submit(new CallableProcessor(i));
            list.add(future);
        }

        for(Future<String> future: list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

}
