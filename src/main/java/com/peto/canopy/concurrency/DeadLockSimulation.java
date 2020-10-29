package com.peto.canopy.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockSimulation {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();

        Thread t1 = new Thread(() -> {
            simulator.setPrinterAcquired(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            do {
                System.out.println("waiting for simulator tape to be released");
            } while (simulator.isTapeAcquired);
            System.out.println("simulator tape has been released");
        });
        Thread t2 = new Thread(() -> {
            simulator.setTapeAcquired(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            do {
                System.out.println("waiting for simulator printer to be released");
            } while (simulator.isPrinterAcquired);
            System.out.println("simulator printer has been released");
        });
        t1.start();
        t2.start();
    }

    static class Simulator {
        boolean isPrinterAcquired = false;
        boolean isTapeAcquired = false;

        public void setPrinterAcquired(boolean printerAcquired) {
            isPrinterAcquired = printerAcquired;
        }

        public void setTapeAcquired(boolean tapeAcquired) {
            isTapeAcquired = tapeAcquired;
        }
    }
}
