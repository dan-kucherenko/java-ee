package ua.ukma.kucherenko.cdl;

import java.util.concurrent.CountDownLatch;

public class CDLMyRunnable implements Runnable {
    private final CountDownLatch latch;

    public CDLMyRunnable(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is executing.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println("Thread " + Thread.currentThread().getId() + " has finished executing.");
    }
}