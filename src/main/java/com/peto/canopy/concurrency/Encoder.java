package com.peto.canopy.concurrency;

public class Encoder {
    private static final String TAG = EncoderManager.class.getSimpleName();

    public void a() {
        try {
            System.out.println("call a start");
            Thread.sleep(100);
            print("call a stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void b() {
        try {
            print("call b start");
            Thread.sleep(200);
            print("call b stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void c() {
        try {
            print("call c start");
            Thread.sleep(300);
            print("call c stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void d() {
        try {
            print("call d start");
            Thread.sleep(400);
            print("call d stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void e() {
        try {
            print("call e start");
            Thread.sleep(500);
            print("call e stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String msg) {
        System.out.println(TAG + " : " + msg);
    }
}
