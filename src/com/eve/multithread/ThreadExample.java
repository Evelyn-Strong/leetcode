package com.eve.multithread;

public class ThreadExample {
    public static void main(String[] args) {
        Number num =  new Number();
        Thread a = new Thread(num,"Thread1");
        Thread b = new Thread(num,"Thread2");
        a.start();
        b.start();

    }

}

class Number implements Runnable {
    private int i = 0;
    private char c = 'a';

    @Override
    public void run() {
       while(true){

       }
    }
}
