package com.peto.canopy.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EncoderManager {
    private static final String TAG = EncoderManager.class.getSimpleName();

    ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
    Lock writeLock = reentrantLock.writeLock();
    Lock readLock = reentrantLock.readLock();

    Encoder encoder = new Encoder();

    public void encodeA() {
        print("encodeA start a");
        try {
            readLock.lock();
            print("encodeA after lock");
            Thread.sleep(200);
//            encodeB();
            Thread.sleep(200);
            print("encodeA api done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void encodeB() {
        print("encodeB start b");
        try {
            writeLock.lock();
            print("encodeB after lock");
            Thread.sleep(500);
            encodeA();
            print("encodeB api done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    private void print(String msg) {
        System.out.println(TAG + " : " + msg);
    }
}
