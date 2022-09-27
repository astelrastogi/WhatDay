package androidsamples.java.whatday;

import java.util.Calendar;
import java.util.GregorianCalendar;

import androidx.annotation.NonNull;

public class DateModel {

  private static int date;
  private static int month;
  private static int year;
  private static boolean isValidDate;
  private static boolean isValidMonth;
  private static boolean isValidYear;

  static int []numDaysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  static String []mapIndToDay = new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

  public static void initialize(String yearStr, String monthStr, String dateStr) {
    // TODO implement the method to match the description

    isValidDate = true;
    isValidYear = true;
    isValidMonth = true;

    try{
      date = Integer.parseInt(dateStr);
    }
    catch (Exception e) {
      isValidDate = false;
    }

    try{
      month = Integer.parseInt(monthStr);
    }
    catch (Exception e) {
      isValidMonth = false;
    }

    try{
      year = Integer.parseInt(yearStr);
    }
    catch (Exception e) {
      isValidYear = false;
    }

  }

  public static String getDay() {
    GregorianCalendar calendar = new GregorianCalendar(year, month  - 1, date);
    calendar.setLenient(false);
    return mapIndToDay[calendar.get(Calendar.DAY_OF_WEEK)];
  }

  static boolean checkLeap(int year) {
    if (year % 400 == 0)
      return true;
    if (year % 100 == 0)
      return false;
    if (year % 4 == 0)
      return true;
    else return false;
  }

  @NonNull
  public static String getMessage() {
    // TODO implement the method to match the description
    if(!isValidYear || !isValidMonth || !isValidYear) {
      return "Enter values in a proper numeric format";
    }

    boolean isLeap = false;
    if(checkLeap(year)) {
      isLeap = true;
    }

    // Validate Month
    if(month > 12 || month <= 0) {
      return  "Invalid month";
    }

    // February
    if(month == 2) {

      if(!isLeap && date == 29) {
        return "February of " + year + " does not have 29 days";
      }

      else if(isLeap && date == 29) {
        return getDay();
      }

      else {
        return "This month does not have " + date + " days";
      }
    }

    // Validate Date
    else if(date > numDaysInMonth[month-1]) {
      return "This month does not have " + date + " days";
    }

    return getDay();
  }
}
