import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

public class DataProcessing {
    List<MonitoredData> data;

    public DataProcessing(List<MonitoredData> data) {
        this.data = data;
    }

   public long task2 (){
        long nr=data.stream()
                .map(d->d.computeDistinctDay(d.computeLocalDateTime(d.getStartTime())))
                .distinct()
                .count();
        return nr;
    }
    public Map<String, Long> task3 () {
        Map<String, Long> counts = data.stream()
                .collect(groupingBy(d -> d.getActivityLabel(), counting()));
        return counts;
    }

    public  Map<Integer, Map<String, Long>>  task4 () {
        Map<Integer, Map<String, Long>> activityStat=  data.stream().collect(
                groupingBy(d->d.computeDistinctDay(d.computeLocalDateTime(d.getStartTime())),
                        groupingBy(MonitoredData::getActivityLabel, counting())));
        return activityStat;
    }

    public  Map<String, Integer> task5(){
        Map<String,Integer> duration=data.stream()
                .collect(groupingBy(d -> d.getActivityLabel(), summingInt(d->d.computeDuration())));
        return duration;
    }

    public  List<String> task6(){
        List<String> shortActivities= new ArrayList<String>();
        List<String> activities=data.stream()
                .map(d->d.getActivityLabel())
                .distinct()
                .collect(toList());

        Map<String,  List<MonitoredData>> shortOnes=data.stream()
                .filter(d->d.isShort())
                .collect(groupingBy(d->d.getActivityLabel(),toList()));
        Map<String,  List<MonitoredData>> longOnes=data.stream()
                .filter(d->!(d.isShort()))
                .collect(groupingBy(d->d.getActivityLabel(),toList()));


        for (String a: activities) {
            if (shortOnes.containsKey(a) && !longOnes.containsKey(a)) {
                shortActivities.add(a);
            }
            if (shortOnes.containsKey(a) && longOnes.containsKey(a)) {
                if (shortOnes.get(a).size() >= (0.9 * (longOnes.get(a).size() + shortOnes.get(a).size()))) {
                    shortActivities.add(a);
                }
            }
        }
        return shortActivities;
    }
}
