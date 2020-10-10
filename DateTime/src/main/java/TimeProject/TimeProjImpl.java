package TimeProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeProjImpl implements TimeProject {

    public String timeFormat = "12:00 AM";

    Pattern pattern = Pattern.compile("\\d{2}:\\d{2} [a-zA-Z][a-zA-Z]");
    Matcher timeMatcher = pattern.matcher(timeFormat);

    private String displayTime;
    private String newTime;
    private int numMin;

    public TimeProjImpl() {
    }

    public void validateTime(String displayTime) {
        assert timeMatcher.matches() : "Time entered is invalid, please enter the time in the format of 'HH:MM AM|PM'";
    }

    //@Override not working
    public String addMinToTime(String time, int minutes) {
        validateTime(time);

        //here int changes 00 to 0, need to use float or something else
        int minEntered = Integer.parseInt(time.substring(3, 5));
        int hourEntered = Integer.parseInt(time.substring(0, 2));
        int newMinInTime = 0;
        int newHourInTime = 0;
        String amOrPm = time.substring(5, 6);
        String newTime = "";
        int minCheck = minEntered + minutes;
        //System.out.println("Minutes left in the hour + minutes added is " + minCheck);

        if (minutes > 60 || minCheck > 60) {
            int addedHours = minutes / 60;
            int remainingMin = minutes % 60;

            //newMinInTime = remainingMin;
            //newHourInTime = hourEntered + addedHours;
            String strMinInTime = String.valueOf(newMinInTime);
            String strHourInTime = String.valueOf(newHourInTime);
            newTime = strHourInTime + ":" + strMinInTime + " " + amOrPm;
        } else {
            newMinInTime = minEntered + minutes;
            String strMinInTime = String.valueOf(newMinInTime);
            String strHourInTime = String.valueOf(hourEntered);
            //System.out.println(hourInTime);
            newTime = strHourInTime + ":" + strMinInTime + " " + amOrPm;
        }
        validateTime(newTime);
        System.out.println("Time entered :" + time);
        System.out.println("Minutes added :" + minutes);
        System.out.println("The new time is " + newTime);

        return newTime;
    }

}

