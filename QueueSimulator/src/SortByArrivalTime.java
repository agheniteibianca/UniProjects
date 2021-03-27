import java.util.Comparator;

public class SortByArrivalTime implements Comparator<Task> {
    public int compare(Task a, Task b){
        return a.getArrivalTime()-b.getArrivalTime();
    }
}
