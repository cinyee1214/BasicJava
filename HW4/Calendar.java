import java.util.GregorianCalendar;

public class Calendar {

    public static void main(String[] args) {
        /**
         * C9E5
         */
        //Display the current year, month, and day.
        System.out.println("This is the test for GregorianCalendar class: ");
        GregorianCalendar currentDate = new GregorianCalendar();
        System.out.println("Display the current year: " + currentDate.get(GregorianCalendar.YEAR));
        int month = currentDate.get(GregorianCalendar.MONTH) + 1;
        System.out.println("Display the current month: " + month);
        System.out.println("Display the current day: " + currentDate.get(GregorianCalendar.DAY_OF_MONTH));

        //setTimeInMillis(long): Set the value to 1234567898765L and display the year, month, and day.
        currentDate.setTimeInMillis(1234567898765L);
        System.out.println("Set the value to 1234567898765L and display the year, month, and day: ");
        System.out.println("Display the year: " + currentDate.get(GregorianCalendar.YEAR));
        month = currentDate.get(GregorianCalendar.MONTH) + 1;
        System.out.println("Display the month: " + month);
        System.out.println("Display the day: " + currentDate.get(GregorianCalendar.DAY_OF_MONTH));

    }



}
