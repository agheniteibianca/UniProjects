import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

public class SimulationManager implements Runnable{
    public int timeLimit=15; //maximum processing time
    public int maxProcessingTime=10;
    public int minProcessingTime=2;

    public int maxArrivalTime=13;
    public int minArrivalTime=2;

    public int numberOfServices=3;
    public int numberOfClients=20;
    public int maxTasksPerServer=100;
    public SelectionPolicy selectionPolicy=SelectionPolicy.SHORTEST_TIME;
    private Scheduler scheduler;
    private List<Task> waitingTasks;
    private List<Task> generatedTasks;
    //for i/o
    private FileWriter myWriter;
    private File writeFile;
    private Scanner myReader;
    private File readFile;


    public SimulationManager(String a, String b){


        //set files
        readFile = new File(a);
        try {
            myReader = new Scanner(readFile);
        } catch (FileNotFoundException e) {
            System.out.println("nu am putut crea readerul");
        }

        writeFile= new File(b);
        try {
            myWriter = new FileWriter(writeFile);
        } catch (IOException e) {
            System.out.println("nu am putut crea writerul");;
        }
        //read data from file
        readInputData();
        //create scheduler
        scheduler= new Scheduler(numberOfServices,maxTasksPerServer);
        generateNRandomTasks();

    }

    private void generateNRandomTasks(){
        generatedTasks=new ArrayList<Task>();
        waitingTasks=new ArrayList<Task>();
        Random rand=new Random();
        for(int i=0;i<numberOfClients;i++){
            int newProcessingTime=rand.nextInt(maxProcessingTime-minProcessingTime+1)+minProcessingTime;
            int newArrivalTime=rand.nextInt(maxArrivalTime-minArrivalTime+1)+minArrivalTime;
            Task newTask=new Task(i+1,0, newArrivalTime,newProcessingTime);
            generatedTasks.add(newTask);
            waitingTasks.add(newTask);
        }
        Collections.sort(waitingTasks, new SortByArrivalTime());
    }

    private void readInputData(){

            numberOfClients= myReader.nextInt();
            System.out.println(numberOfClients);
            numberOfServices= myReader.nextInt();
            System.out.println(numberOfServices);
            timeLimit= myReader.nextInt();
            System.out.println(timeLimit);
            myReader.nextLine();
            String line;
            String[] lineVector;
            line = myReader.nextLine();
            lineVector = line.split(",");
            minArrivalTime=Integer.parseInt(lineVector[0]);
            maxArrivalTime=Integer.parseInt(lineVector[1]);
            System.out.println(minArrivalTime);
            System.out.println(maxArrivalTime);
            myReader.nextLine();
            lineVector = line.split(",");
            minProcessingTime=Integer.parseInt(lineVector[0]);
            maxProcessingTime=Integer.parseInt(lineVector[1]);
            System.out.println(minProcessingTime);
            System.out.println(maxProcessingTime);
            myReader.close();
    }
    private void writeOutputData(int currentTime ){
        try {
            myWriter.write("Time " +currentTime+ "\n");
            myWriter.write("Waiting clients: ");
            myWriter.write(waitingTasks.toString()+"\n");
            myWriter.write(scheduler.toString()+"\n");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Time " +currentTime);
        System.out.println("Waiting clients: ");
        System.out.println(waitingTasks);
        System.out.println(scheduler);
    }

    @Override
    public void run(){
        int currentTime=0;
        List<Task> deSters=new ArrayList<Task>();
        while(currentTime<=timeLimit){
            //adaug taskuri
            for(Task current:generatedTasks){
                if(current.getArrivalTime()==currentTime){
                    try {
                        scheduler.dispatchTask(current);
                        current.setTimeSpentInQueue(current.getTimeSpentInQueue()-1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    deSters.add(current);
                }
            }
            //sterg taskurile deja adaugate
            for(Task current: deSters){
                waitingTasks.remove(current);
            }
            //afisez timpul, clientii in asteptare si starea cozilor
            writeOutputData(currentTime);
            //actualizez timpul curent
            currentTime++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Someone intrerrupted me!");
            }
        }
        //inchid toate cozile
        scheduler.closeAllServers();
        //scriu media
        calculeazaMedia();
        //inchid fisierul
        try {
            myWriter.close();
        } catch (IOException e) {
            System.out.println("nu am putut inchide writerul");;
        }

    }

    public void calculeazaMedia(){
        int suma=0;
        for (Task t: generatedTasks){
            suma+= t.getTimeSpentInQueue();
            System.out.println(t.getTimeSpentInQueue());
        }
        float media=suma/(float)numberOfClients;
        try {
            myWriter.write("\nAverange time: "+ media);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Media:" + media);
    }



    public static void main(String[] args){
        SimulationManager gen= new SimulationManager(args[0],args[1]);
        Thread t=new Thread(gen);
        t.start();
    }
}
