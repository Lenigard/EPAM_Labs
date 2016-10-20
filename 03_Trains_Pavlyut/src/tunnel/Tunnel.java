package tunnel;

import train.Train;
import possibleexeption.SemaphoreException;

import java.util.concurrent.Semaphore;

public class Tunnel {
    private final int SEMAPHORE_SIZE = 1;
    private final Semaphore semaphoreFirst = new Semaphore(SEMAPHORE_SIZE, true);
    private final Semaphore semaphoreSecond = new Semaphore(SEMAPHORE_SIZE, true);

    public void goingThroughFirst(Train train) throws SemaphoreException {
        try {
            semaphoreFirst.acquire();
            System.out.println("Поезд номер " + train.getNumber() + " проходит через тоннель А " + train.getSide());
            Thread.sleep(train.getTimeGoThrough());
            System.out.println("Поезд номер " + train.getNumber() + " прошёл через тоннель А " + train.getSide());
        } catch (InterruptedException e) {
            throw new SemaphoreException("Ошибка при работе с первым семафором.", train.getNumber());
        } finally {
            semaphoreFirst.release();
        }

    }

    public void goingThroughSecond(Train train) throws SemaphoreException{
        try {
            semaphoreSecond.acquire();
            System.out.println("Поезд номер " + train.getNumber() + " проходит через тоннель B " + train.getSide());
            Thread.sleep(train.getTimeGoThrough());
            System.out.println("Поезд номер " + train.getNumber() + " прошёл через тоннель B " + train.getSide());
        } catch (InterruptedException e) {
            throw new SemaphoreException("Ошибка при работе с вторым семафором.", train.getNumber());
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