package com.Faissal;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Integer> list ;
    private int size ;

    public Buffer(int size ) {
        this.list = new LinkedList<>();
        this.size =size;
    }
    public void produce() throws InterruptedException {
        int value =0 ;
        while(true ){

            synchronized (this){
                while(list.size() >= size)
                    wait();
            }
            list.add(value);
            System.out.println("Produced" + value);
            value++;
            //Notify the consumer
            notify();//used to wakeup only one thread that is waiting for an object , and that thread then begins execution
            Thread.sleep(1000);
        }
    }
    public void conusme() throws InterruptedException {

        while(true){
            synchronized (this){
                while(list.size() == 0){
                    wait();
                }
            }
            int value = list.poll() ;//the poll method of QUeue interface returns and removes the element at the front end of the container
            System.out.println("Consume" + value);

            //notfy the producer
            notify();
            Thread.sleep(1000);
        }
    }
}
