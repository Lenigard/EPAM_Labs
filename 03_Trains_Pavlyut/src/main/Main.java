package main;

import train.Train;
import tunnel.Tunnel;
import tunnelcontroller.TunnelController;

import java.io.IOException;
import java.util.ArrayDeque;

public class Main {

    private final static double TIME_GO_THROW = 1;
    private final static int TRAINS_COUNT_LEFT = 3;
    private final static int TRAINS_COUNT_RIGHT = 3;

    private static void createTrains(ArrayDeque<Train> trains, boolean side, Tunnel tunnel) throws IOException {
        int currentLen = 0;
        String currentSide;
        String additionalLetter;
        if(side) {
            currentLen = TRAINS_COUNT_LEFT;
            currentSide = "слева";
            additionalLetter = "L";
        }
        else {
            currentLen = TRAINS_COUNT_RIGHT;
            currentSide = "справа";
            additionalLetter = "R";
        }
        for (int i = 0; i < currentLen; i++) {
            trains.add(new Train(Integer.toString(i) + additionalLetter, TIME_GO_THROW, tunnel, currentSide));
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayDeque<Train> trainsLeft = new ArrayDeque<>();
        ArrayDeque<Train> trainsRight = new ArrayDeque<>();
        Tunnel tunnel = new Tunnel();
        createTrains(trainsLeft, true, tunnel);
        createTrains(trainsRight, false, tunnel);
        TunnelController tunnelController = new TunnelController(trainsLeft, trainsRight, tunnel);
        tunnelController.create();
    }
}
