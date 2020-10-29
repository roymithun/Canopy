package com.peto.canopy.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockWithLocks {
    public static void main(String[] args) {
        ResourceProvider1 resourceProvider = new ResourceProvider1();
        new Thread(resourceProvider::holdRes1).start();
        new Thread(resourceProvider::holdRes2).start();
    }

    static class ResourceProvider1 {
        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();

        public void holdRes1() {
            lock1.lock();
            System.out.println("holdRes1:: " + Thread.currentThread().getName() + " is going to hold Res1");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("holdRes1:: " + Thread.currentThread().getName() + " is waiting to hold Res2");

            lock2.lock();
            System.out.println("holdRes1:: " + Thread.currentThread().getName() + " acquired both res1 and res2");
        }

        public void holdRes2() {
            lock2.lock();
            System.out.println("holdRes2:: " + Thread.currentThread().getName() + " is going to hold Res2");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("holdRes2:: " + Thread.currentThread().getName() + " is waiting to hold Res1");

            lock1.lock();
            System.out.println("holdRes2:: " + Thread.currentThread().getName() + " acquired both res2 and res1");
        }
    }

    static class ResourceProvider {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        public void holdRes1() {
            synchronized (lock1) {
                System.out.println("holdRes1:: " + Thread.currentThread().getName() + " is going to hold Res1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("holdRes1:: " + Thread.currentThread().getName() + " is waiting to hold Res2");

                synchronized (lock2) {
                    System.out.println("holdRes1:: " + Thread.currentThread().getName() + " acquired both res1 and res2");
                }
            }
        }

        public void holdRes2() {
            synchronized (lock2) {
                System.out.println("holdRes2:: " + Thread.currentThread().getName() + " is going to hold Res2");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("holdRes2:: " + Thread.currentThread().getName() + " is waiting to hold Res1");

                synchronized (lock1) {
                    System.out.println("holdRes2:: " + Thread.currentThread().getName() + " acquired both res2 and res1");
                }
            }
        }
    }
}
