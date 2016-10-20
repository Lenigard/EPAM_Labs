package tunnel;

import train.Train;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tunnel {
    private final int SEMAPHORE_SIZE = 3;
    private final int MAX_CODIRECTIONAL_TRAINS = 2;
    private final Semaphore semaphoreFirst = new Semaphore(SEMAPHORE_SIZE, true);
    private final Semaphore semaphoreSecond = new Semaphore(SEMAPHORE_SIZE, true);
    private int lastCodirectionalSide; //1 - въезд в тоннель был совершён справа, -1 - слева
    private int currentCodirectionalTrainsFirst = 0;
    private int currentCodirectionalTrainsSecond = 0;

    public void goingThroughFirst(Train train) {
        try {
            semaphoreFirst.acquire();
            System.out.println("Поезд номер " + train.getNumber() + " проходит через тоннель А " + train.getSide());
            Thread.sleep(train.getTimeGoThrough());
            System.out.println("Поезд номер " + train.getNumber() + " прошёл через тоннель А " + train.getSide());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreFirst.release();
        }
    }

    public void goingThroughSecond(Train train) {
        try {
            semaphoreSecond.acquire();
            System.out.println("Поезд номер " + train.getNumber() + " проходит через тоннель B " + train.getSide());
            Thread.sleep(train.getTimeGoThrough());
            System.out.println("Поезд номер " + train.getNumber() + " прошёл через тоннель B " + train.getSide());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreSecond.release();
        }

    }



    public boolean firstIsFree() {
        return !semaphoreFirst.hasQueuedThreads();
    }

    public boolean secondIsFree() {
        return !semaphoreSecond.hasQueuedThreads();
    }

}