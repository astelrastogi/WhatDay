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

  /**
   * Initializes the {@link DateModel} with the given year, month, and date.
   * If the date is not valid, it sets the appropriate error message.
   * If it is valid, it sets the appropriate day of the week message.
   *
   * @param yearStr  a {@code String} representing the year, e.g., "1947"
   * @param monthStr a {@code String} representing the month, e.g., "8"
   * @param dateStr  a {@code String} representing the date, e.g., "15"
   */

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

  /**
   * Retrieves the message from the {@link DateModel}.
   * It can be an error message like "February of 2019 does not have 29 days"
   * or a success message like "Friday".
   *
   * @return the message from the model
   */
  @NonNull
  public static String getMessage() {
    // TODO implement the method to match the description
    if(!isValidYear || !isValidMonth || !isValidDate) {
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

      if(date > 29) {
        return "This month does not have " + date + " days";
      }

      else if(!isLeap && date == 29) {
        return "February of " + year + " does not have 29 days";
      }

      else {
        return getDay();
      }

    }

    // Validate Date
    else if(date > numDaysInMonth[month-1]) {
      return "This month does not have " + date + " days";
    }

    return getDay();
  }
}
