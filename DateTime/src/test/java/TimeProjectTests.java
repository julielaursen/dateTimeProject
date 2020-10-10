import org.junit.Test;
import TimeProject.TimeProjImpl;
import TimeProject.TimeProject;

public class TimeProjectTests {

    @Test
    public void testString1() {
        TimeProject test1 = new TimeProjImpl();
        test1.addMinToTime("12:33 PM", 1);
     }

    @Test
    public void testString2() {
        TimeProject test2 = new TimeProjImpl();
        test2.addMinToTime("12:33 PM", 0);
    }

    @Test
    public void testString3() {
        TimeProject test3 = new TimeProjImpl();
        test3.addMinToTime("12:33 PM", 30);
    }

    @Test
    public void testString4() {
        TimeProject test3 = new TimeProjImpl();
        test3.addMinToTime("12:33 PM", 60);
    }

    @Test
    public void testString5() {
        TimeProject test3 = new TimeProjImpl();
        test3.addMinToTime("12:33 PM", 61);
    }

    @Test
    public void testString6() {
        TimeProject test3 = new TimeProjImpl();
        test3.addMinToTime("12:33 PM", 1000000);
    }

}


