import java.io.*;
import java.util.*;

public class PrintCalendar {
	static int getStartDay() {

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Prompt the user to enter year
		System.out.print("Enter full year (e.g., 2012): ");
		int year = input.nextInt();
		// Prompt the user to enter month
		System.out.print("Enter month as a number between 1 and 12: ");
		int month = input.nextInt();

		printMonth(year, month);

	}

	private static void printMonth(int year, int month) {
		printMonthTitle(year, month);
		printMonthBody(year, month);
	}

	private static void printMonthBody(int year, int month) {
		int startDay = getStartDay(year, month);
		int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

		// Pad space before the first day of the month
		int i = 0;
		for (i = 0; i < startDay; i++)
			System.out.print("    ");

		for (i = 1; i <= numberOfDaysInMonth; i++) {
			System.out.printf("%4d", i);

			if ((i + startDay) % 7 == 0)
				System.out.println();
		}

		System.out.println();
	}

	private static int getStartDay(int year, int month) {
		final int START_DAY_FOR_JAN_1_1800 = 3;
		// Get total number of days from 1/1/1800 to month/1/year
		int totalNumberOfDays = getTotalNumberOfDays(year, month);

		// Return the start day for month/1/year
		return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
	}

	private static int getTotalNumberOfDays(int year, int month) {
		int total = 0;
		// Get the total days from 1800 to 1/1/year
		total += (year - 1800) * 365;
		for (int i = 1800; i < year; i++)
			if (isLeapYear(i))
				total++;

		// Add days from Jan to the month prior to the calendar month
		for (int i = 1; i < month; i++)
			total = total + getNumberOfDaysInMonth(year, i);

		return total;
	}

	private static int getNumberOfDaysInMonth(int year, int month) {
		if (month == 2)
			if (isLeapYear(year))
				return 29;
			else
				return 28;
		if (month <= 7 && month % 2 == 1 || month >= 8 && month % 2 == 0)
			return 31;
		else
			return 30;
	}

	private static void printMonthTitle(int year, int month) {
		System.out.println("         " + getMonthName(month) + " " + year);
		System.out.println("—————————————————————————————");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	private static String getMonthName(int month) {
		return new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September",
						"October", "November", "December"}[month - 1];
	}

	static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}