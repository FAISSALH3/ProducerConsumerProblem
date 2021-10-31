package com.Faissal;

import java.util.LinkedList;
import java.util.Queue;


public class Main{

    public static void main(String[] args) throws InterruptedException{
        Buffer buffer = new Buffer(2);
        Thread produceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    buffer.produce();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });
        Thread ConsumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    buffer.conusme();
                }
                catch(InterruptedException e ){
                    e.printStackTrace();
                }
            }
        });
        produceThread.start();
        ConsumerThread.start();


    }


}



