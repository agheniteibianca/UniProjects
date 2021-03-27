import java.util.List;

public interface Strategy {
    public void addTask(List<Server> servers, Task t) throws InterruptedException;
}
