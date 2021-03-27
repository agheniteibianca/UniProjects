import java.util.List;

public class ConcreteStrategyTime implements Strategy {
    @Override
    public void addTask(List<Server> servers, Task t) throws InterruptedException {
        //caut serverul cu cel mai mic waiting time
        int minValue=servers.get(0).getWaitingPeriod().get();
        Server minServer=servers.get(0);
        for(Server currentServer:servers){
            int currentValue=currentServer.getWaitingPeriod().get();
            if(currentValue<minValue){
                minValue=currentValue;
                minServer=currentServer;
            }
        }

        //daca serverul era inchis, il deschid
        if(minServer.isOn()==false){
            minServer.setState(true);
            t.setProcessingTime(t.getProcessingTime()+1);
            //t.setTimeSpentInQueue(t.getTimeSpentInQueue()-1);
            Thread newThead=new Thread(minServer);
            newThead.start();

        }
        //adaug taskul la el

        minServer.addTask(t);

    }
}
