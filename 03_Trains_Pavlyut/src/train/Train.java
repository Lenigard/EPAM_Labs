package train;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import possibleexeption.SemaphoreException;
import tunnel.Tunnel;

import java.io.IOException;

public class Train extends Thread {

    private String number;
    private int timeGoThrough;
    private boolean going = false;
    private String side;
    private Tunnel tunnel;
    private final static Logger LOG = LogManager.getLogger();

    public Train(String number, double timeGoThrough, Tunnel tunnel, String side) throws IOException {
        this.number = number;
        this.timeGoThrough = (int)(timeGoThrough * 1000);
        this.tunnel = tunnel;
        this.side = side;
    }

    public String getNumber() {
        return number;
    }

    public int getTimeGoThrough() {
        return timeGoThrough;
    }

    public String getSide(){
        return side;
    }

    @Override
    public void run() {
        System.out.println("Поезд номер " + number + " прибыл к тоннелю " + side);
        while (!going) {
            if (tunnel.firstIsFree()) {
                try {
                    tunnel.goingThroughFirst(this);
                } catch (SemaphoreException e) {
                    LOG.error(e.getMessage());
                }
                going = true;
            } else {
                if (tunnel.secondIsFree()) {
                    try {
                        tunnel.goingThroughSecond(this);
                    } catch (SemaphoreException e) {
                        LOG.error(e.getMessage());
                    }
                    going = true;
                }
            }
        }
    }
}
