import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MonitoredData {
    private String startTime;
    private String endTime;
    private String activityLabel;

    public MonitoredData(String startTime, String endTime, String activityLabel) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityLabel = activityLabel;
    }
    public LocalDateTime computeLocalDateTime(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return dateTime;
    }
    public int computeDistinctDay(LocalDateTime data){
        int luna=data.getMonthValue();
        int zi=data.getDayOfMonth();
        return luna*31+zi;
    }
    public Integer computeDuration(){
        LocalDateTime from = computeLocalDateTime(startTime) ;
        LocalDateTime to = computeLocalDateTime(endTime);
        Duration duration = Duration.between(from, to);
        return (int)duration.toSeconds();
    }
    public boolean isShort(){
        if (computeDuration() <300)
                return true;
        return false;
    }



    public String getActivityLabel() {
        return activityLabel;
    }
    public String getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return "MonitoredData{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", activityLabel='" + activityLabel + '\'' +
                '}';
    }
}
