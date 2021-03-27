import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        String fileName = "Activities.txt";
        List<MonitoredData> activityList = DataReader.readData(fileName);
        DataProcessing a = new DataProcessing(activityList);

        FileWriterClass.writeUsingFileWriter(activityList.toString(), "Task_1.txt" );
        FileWriterClass.writeUsingFileWriter(String.valueOf(a.task2()), "Task_2.txt" );
        FileWriterClass.writeUsingFileWriter(a.task3().toString(), "Task_3.txt" );
        FileWriterClass.writeUsingFileWriter(a.task4().toString(), "Task_4.txt" );
        FileWriterClass.writeUsingFileWriter(a.task5().toString(), "Task_5.txt" );
        FileWriterClass.writeUsingFileWriter(a.task6().toString(), "Task_6.txt" );
    }


}
