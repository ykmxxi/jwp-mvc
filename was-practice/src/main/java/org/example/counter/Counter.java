package org.example.counter;

public class Counter implements Runnable {

    private int count = 0;

    public void increase() {
        count++;
    }

    public void decrease() {
        count--;
    }

    public int getValue() {
        return count;
    }

    @Override
    public void run() {
        synchronized (this) {
            this.increase();
            System.out.println(
                    "Value for Thread After increase() " + Thread.currentThread().getName() + " " + this.getValue());

            this.decrease();
            System.out.println(
                    "Value for Thread After decrease() " + Thread.currentThread().getName() + " " + this.getValue());
        }
    }

}
