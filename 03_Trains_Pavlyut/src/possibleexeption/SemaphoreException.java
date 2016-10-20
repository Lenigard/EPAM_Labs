package possibleexeption;


public class SemaphoreException extends InterruptedException {

    private String trainNumber;

    SemaphoreException(String msg){
        super(msg);
    }

    public SemaphoreException(String msg, String trainNumber){
        super(msg);
        this.trainNumber = trainNumber;
    }

}
