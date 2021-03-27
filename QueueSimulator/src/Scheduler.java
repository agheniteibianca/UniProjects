import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer){
        this.maxNoServers=maxNoServers;
        this.maxTasksPerServer=maxTasksPerServer;
        servers= new ArrayList<Server>();
        for(int i=0;i<maxNoServers;i++){
            Server newServer=new Server(maxTasksPerServer);
            newServer.setState(false);
            servers.add(newServer);
        }
        changeStrategy(SelectionPolicy.SHORTEST_TIME);
    }
    public void changeStrategy(SelectionPolicy policy){
        if(policy==SelectionPolicy.SHORTEST_TIME){
            strategy=new ConcreteStrategyQueue();
        }
        if(policy==SelectionPolicy.SHORTEST_TIME){
            strategy=new ConcreteStrategyTime();
        }
    }
    public void dispatchTask(Task t) throws InterruptedException {
        strategy.addTask(servers,t);
    }
    public List<Server> getServers(){
        return servers;
    }

    @Override
    public String toString(){
        String raport= "";
        int i=0;
        for(Server current: servers){
            i++;
            raport+=i;
            raport+=":";
            raport+=current;
            raport+="\n";
        }
        return raport;
    }

    public void closeAllServers(){
        for(Server s:servers){
            s.setState(false);
        }
    }
}
