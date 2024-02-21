import java.util.Scanner;

public class CalendarProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for month
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        // Get input for year
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        // Print the calendar
        printCalendar(month, year);

        scanner.close();
    }

    public static void printCalendar(int month, int year) {
        System.out.println("Calendar for " + month + "/" + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        // Get the day of the week for the first day of the month
        int startDay = getStartDay(month, 1, year);

        // Get the number of days in the month
        int numDaysInMonth = getNumDaysInMonth(month, year);

        // Print leading spaces
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print the days of the month
        for (int i = 1; i <= numDaysInMonth; i++) {
            if (i < 10)
                System.out.print("   " + i);
            else
                System.out.print("  " + i);

            // Break line if it's Saturday, i.e., the 7th day
            if ((i + startDay) % 7 == 0)
                System.out.println();
        }
    }

    public static int getStartDay(int month, int day, int year) {
        // Zeller's Congruence algorithm for finding the day of the week
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (day + 26 * (month + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
        return (h + 5) % 7; // 0 - Saturday, 1 - Sunday, 2 - Monday, ..., 6 - Friday
    }

    public static int getNumDaysInMonth(int month, int year) {
        // Number of days in each month
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Check for leap year
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return daysInMonth[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
