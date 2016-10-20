package tunnelcontroller;

import train.Train;
import tunnel.Tunnel;

import java.util.ArrayDeque;

/**
 * Created by Lenigard on 20.10.2016.
 */
public class TunnelController {

    Tunnel tunnel;
    ArrayDeque<Train> trainLeft;
    ArrayDeque<Train> trainRight;

    public TunnelController(ArrayDeque<Train> trainLeft, ArrayDeque<Train> trainRight, Tunnel tunnel) {
        this.trainLeft = trainLeft;
        this.trainRight = trainRight;
        this.tunnel = tunnel;
    }

    public void create() {
        while (!trainRight.isEmpty() || !trainLeft.isEmpty()) {
            if (!trainRight.isEmpty()) {
                trainRight.pop().start();
            }
            if (!trainLeft.isEmpty()) {
                trainLeft.pop().start();
            }
        }
    }

}
