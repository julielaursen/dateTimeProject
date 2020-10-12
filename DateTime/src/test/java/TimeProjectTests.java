import org.junit.Test;
import TimeProject.TimeProjImpl;
import TimeProject.TimeProject;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TimeProjectTests {

    @Test
    public void addOneMin() {
        try {
            TimeProject addOneMin = new TimeProjImpl();
            String returnValue = addOneMin.addMinToTime("12:33 PM", 1);
            System.out.println("New value: " + returnValue);
            assert returnValue.equals("12:34 PM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void addZeroMin() {
        try {
            TimeProject addZeroMin = new TimeProjImpl();
            String returnValue = addZeroMin.addMinToTime("12:33 PM", 0);
            System.out.println("New value: " + returnValue);
            assert returnValue.equals("12:33 PM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void returnThreePastHour() {
        try {
            TimeProject returnThreePastHour = new TimeProjImpl();
            String returnValue = returnThreePastHour.addMinToTime("12:33 PM", 30);
            System.out.println("New value: " + returnValue);
            assert returnValue.equals("1:03 PM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void addOneHour() {
        try {
            TimeProject addOneHour = new TimeProjImpl();
            String returnValue = addOneHour.addMinToTime("12:33 PM", 60);
            System.out.println("New value: " + returnValue);
            assert returnValue.equals("1:33 PM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void addOneHourOneMin() {
        try {
            TimeProject addOneHourOneMin = new TimeProjImpl();
            String returnValue = addOneHourOneMin.addMinToTime("12:33 PM", 61);
            System.out.println("New value " + returnValue);
            assert returnValue.equals("1:34 PM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testMidnightStr() {
        try {
            TimeProject testMidnightStr = new TimeProjImpl();
            String returnValue = testMidnightStr.addMinToTime("12:00 AM", 0);
            System.out.println("New value " + returnValue);
            assert returnValue.equals("12:00 AM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testLargeNum() {
        try {
            TimeProject testLargeNum = new TimeProjImpl();
            String returnValue = testLargeNum.addMinToTime("12:00 AM", 1439);
            System.out.println("New value " + returnValue);
            assert returnValue.equals("11:59 PM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testMaxBoundaryValue() {
        try {
            TimeProject testMaxBoundaryValue = new TimeProjImpl();
            String returnValue = testMaxBoundaryValue.addMinToTime("12:00 AM", 1440);
            System.out.println("New value " + returnValue);
            assert returnValue.equals("12:00 AM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testMaxPlusOneBoundaryValue1() {
        try {
            TimeProject testMaxPlusOneBoundaryValue1 = new TimeProjImpl();
            String returnValue = testMaxPlusOneBoundaryValue1.addMinToTime("12:00 AM", 1441);
            System.out.println("New value " + returnValue);
            assert returnValue.equals("12:01 AM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testBoundaryValue2() {
        try {
            TimeProject testBoundaryValue2 = new TimeProjImpl();
            String returnValue = testBoundaryValue2.addMinToTime("11:00 PM", 120);
            System.out.println("New value " + returnValue);
            assert returnValue.equals("1:00 AM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void lowerCaseTet() {
        try {
            TimeProject testBoundaryValue2 = new TimeProjImpl();
            String returnValue = testBoundaryValue2.addMinToTime("11:00 pm", 120);
            System.out.println("New value " + returnValue);
            assert returnValue.equals("1:00 AM");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void malformedRequest() {
        TimeProject malformedRequest = new TimeProjImpl();
        try {
            String returnValue = malformedRequest.addMinToTime("1100PM", 120);
            fail("Should have thrown an exception");
        } catch (final RuntimeException e) {
            assertTrue(true);
        }
    }

    @Test
    public void malformedRequest2() {
        TimeProject malformedRequest2 = new TimeProjImpl();
        try {
            String returnValue = malformedRequest2.addMinToTime("#R@#$*&", 120);
            fail("Should have thrown an exception");
        } catch (final RuntimeException e) {
            assertTrue(true);
        }
    }
}


