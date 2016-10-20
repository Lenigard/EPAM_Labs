package train;

import tunnel.Tunnel;

import java.io.IOException;

public class Train extends Thread {
    private String number;
    private int timeGoThrough;
    private boolean going = false;
    private String side;
    Tunnel tunnel;

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
                tunnel.goingThroughFirst(this);
                going = true;
            } else {
                if (tunnel.secondIsFree()) {
                    tunnel.goingThroughSecond(this);
                    going = true;
                }
            }
        }
    }
}
