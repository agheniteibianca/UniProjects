import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DataReader {

    public static MonitoredData dataToObject(String data){
        String startTime=null;
        String endTime=null;
        String activityLabel=null;

        Pattern p = Pattern.compile( "(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2})\\s{2}(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2})\\s{2}([a-zA-Z/_]*)" );
        Matcher m = p.matcher(data);
        while (m.find()) {
            startTime=m.group(1);
            endTime=m.group(2);
            activityLabel=m.group(3);
            System.out.println(startTime + "        " +endTime+ "       "+ activityLabel);

        }
        MonitoredData newData= new MonitoredData(startTime,endTime,activityLabel);
        return newData;
    }


    public static List<MonitoredData> readData(String fileName){
        List<MonitoredData> activityList=null;
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get(fileName));
            activityList= stream.map(data->dataToObject(data))
                    .collect(toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return activityList;
    }
}
