package TimeProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.*;

public class TimeProjImpl implements TimeProject {

    public String timeFormat = "12:00 AM";

    Pattern pattern = Pattern.compile("([0-12]|[1-9]):([0-5][0-9])\\s[A-Za-z][A-Za-z]");
    Matcher timeMatcher = pattern.matcher(timeFormat);

    private String displayTime;
    private String currentAmPm;
    private int currentHours;
    private int currentMin;
    private int current24hour;
    private int new24hour;
    private int minutesAfterAdd;
    private String newTime;
    private String strCurrentMin;

    public TimeProjImpl() {
    }

    public void validateTime(String displayTime) {
        assert !timeMatcher.matches() : "Time entered is invalid, please enter the time in the format of 'HH:MM AM|PM'";
    }

    public void parserToHourMin(String displayTime){
        currentMin = Integer.parseInt(displayTime.substring(3, 5));
        currentHours = Integer.parseInt(displayTime.substring(0, 2));
        currentAmPm = displayTime.substring(6, 8);
    }

    public void conversionTo24(int currentMin, int currentHours, String currentAmPm){
        if (currentHours == 12 && currentAmPm.equals("AM")){
            this.currentHours = 0;
        }
        else if (currentHours != 12 && currentAmPm.equals("PM")){
            this.currentHours = currentHours + 12;
        }
    }

    public void conversionToMin(int currentHours, int currentMin){
        this.new24hour = ((currentHours * 60) + currentMin);
    }

    public void newConversionTo24(int minutesAfterAdd){
        this.currentHours = minutesAfterAdd / 60;
            if(this.currentHours > 23){
                this.currentHours = this.currentHours - 24;
            }
        this.currentMin = minutesAfterAdd % 60;
    }

    public void convert24toAmPm(int hours, int min, int minutes){
        if(hours == 0){
            this.currentHours = 12;
            this.currentMin = min;
            this.currentAmPm = "AM";
        }
        else if(hours == 12){
            this.currentHours = hours;
            this.currentMin = min;
            this.currentAmPm = "PM";
        }
        else if(hours > 12){
            this.currentHours = hours - 12;
            this.currentMin = min;
            this.currentAmPm = "PM";
        }
        else if(hours < 12){
            this.currentHours = hours;
            this.currentMin = min;
            this.currentAmPm = "AM";
        }
        //need another conversion logic to change Pm to AM if hours go into the next day

    }

    public boolean validateMinUnder10(int currentMin) {
            if (currentMin < 10) {
                return true;
            } else {
                return false;
            }
    }


    public String addMinToTime(String displayTime, int minutes) {
        validateTime(displayTime);
        parserToHourMin(displayTime);
        conversionTo24(currentMin, currentHours, currentAmPm);
        conversionToMin(this.currentHours, this.currentMin);

        minutesAfterAdd = this.new24hour + minutes;

        newConversionTo24(minutesAfterAdd);
        convert24toAmPm(this.currentHours, this.currentMin, minutes);

        System.out.println("Time entered :" + displayTime);
        System.out.println("Minutes added :" + minutes);

        if(validateMinUnder10(currentMin)){
            newTime = (currentHours + ":" + String.format("%02d", currentMin) + " " + currentAmPm);
        }
        else{
            newTime = (currentHours + ":" + currentMin + " " + currentAmPm);
        }

        validateTime(newTime);
        return newTime;
    }

}

