package org.example.counter;

public class RaceConditionDemo {

    // 싱글톤 객체가 멀티 쓰레드 환경에서 하나의 자원을 공유하면 Race Condition 발생
    // Race Condition: 여러 쓰레드가 하나의 자원에 접근하기 위해 경쟁하는 상태
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(counter, "Thread-1");
        Thread thread2 = new Thread(counter, "Thread-2");
        Thread thread3 = new Thread(counter, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
