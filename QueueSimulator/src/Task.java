import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private int Id;

    public int getTimeSpentInQueue() {
        return timeSpentInQueue;
    }

    private int timeSpentInQueue;

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    private int arrivalTime;

    public void setTimeSpentInQueue(int timeSpentInQueue) {
        this.timeSpentInQueue = timeSpentInQueue;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    private int processingTime;

    public Task(int id, int timeSpentInQueue, int arrivalTime, int processingTime) {
        Id = id;
        this.timeSpentInQueue = timeSpentInQueue;
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
    }

    @Override
    public String toString(){
        return "("+Id+" "+arrivalTime+" "+processingTime+")";
    }


}
