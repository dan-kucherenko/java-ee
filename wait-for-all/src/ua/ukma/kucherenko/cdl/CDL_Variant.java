package ua.ukma.kucherenko.cdl;

import java.util.concurrent.CountDownLatch;

public class CDL_Variant {
    public static void main(String[] args) {
        final int numThreads = 5;
        CountDownLatch latch = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            new Thread(new CDLMyRunnable(latch)).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished executing.");
    }
}


