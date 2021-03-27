import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private boolean on;

    public void setState(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public Server(int maxTasksPerServers) {
        waitingPeriod=new AtomicInteger(0);
        tasks= new LinkedBlockingDeque<>(maxTasksPerServers);
    }
    public void addTask(Task newTask) throws InterruptedException {
        tasks.put(newTask);
        waitingPeriod.addAndGet(newTask.getProcessingTime());
    }
    public void run(){
        while(on){
            //actualizez time spent in queue pt fiecare tesk
            for(Task t:tasks){
                t.setTimeSpentInQueue(t.getTimeSpentInQueue()+1);
            }
            //actualizez timpii de procesare
            try {
                Task current = tasks.element();
                waitingPeriod.addAndGet(-1);
                current.setProcessingTime(current.getProcessingTime() - 1);
                if (current.getProcessingTime() == 0) {
                    tasks.remove(current);
                    checkIfClosed();
                }
            }
            catch(NoSuchElementException e){
            }



            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Someone intrerrupted me!");
            }



        }

    }
    public void checkIfClosed(){
        if(tasks.isEmpty()){
            on=false;
        }
    }
    @Override
    public String toString(){
        String raport="";
        if(on==false){
            raport+="closed";
        }
        for(Task current:tasks){
            raport+=current;
            raport+=" ";
        }
        raport+= (" cu waiting time:"+ waitingPeriod);
        return raport;
    }

}
