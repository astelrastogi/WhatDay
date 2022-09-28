# WhatDay

This simple Android app asks the user for a date in the Gregorian calendar and returns the day of the week for that date.

# Deliverables

## A.a - Submission Details

Project - Assignment1, What Day App

Name - Aastha Rastogi

ID - 2019A7PS0175G

Email - f20190175@goa.bits-pilani.ac.in

## A.b - App Description

This app takes input from the user for a date, and displays the day for that particular date. If the input is invalid, i.e. not in DD-MM-YYYY format, it displays that the input is invalid. The display message is customised for different cases of invalid inputs. For example if user enters 31-09-2903, it will display "This month doesn't have 31 days".

### Known Bugs

The text doesn't clear itself after Check button is clicked once. For next input user has to clear the previous values to enter new ones. 

## A.c - How I completed Tasks

### Task1
The `setOnClickListener` on Check button calls `initialize()` method first. It then calls `getMessage()` which then prints the string output on the screen. 

`initialise()` -> 

uses a try - catch block to check if there's some parsing error, i.e. if the input is not an integer, it's not a valid input. 

`getMessage()` -> 

1. Validates the entered month
2. Handles the corner case for date in February (leap year/non-leap year)
3. Validates the date entered
4. Calls `getDay()`

`getDay()` -> 

Creates `GregorianCalendar` object with given date and returns the index of week. The exact day name extracted from the `mapIndToDay` array and index. 

#### Note

Used `calendar.setLenient(false)` for strict matching. If set to true (which is by default), Calendar will intelligently guess the possible day even if the input is not in correct format, whereas we don't want that.

###  Task2
Removed `android:inputType="date"` from `activity_main.xml` file for modifying the method of input. Earlier only keyboard with numbers used to appear. After removing this line, user can give string input. For example "four" instead of 4. The app will display invalid input method for string inputs.

Also, increased the height of textview inputs to `48dp` from `45dp` as per Accessibility Scanner suggestion. 

###  Task3

#### Talkback 

It repeats the entered digit twice, which makes entering the exact date confusing. For example, if we write 2 as the date of the month, talkback repeats it and it seems we've entered 22 as the date of month. Moreover, Talkback doesn't automatically read out the display text after check button has been clicked. 

#### Accessibility Scanner

After running the Accessibility Scanner on my app, 3 suggestions were shown. One each for text input i.e `id/editYear`, `id/editMonth`, `id/editDate`. The scanner  suggested to make height of textview input from `45dp` to `48dp`.

## A.d - Testing

Used Test-Driven Approach for coding up the project. Added 2 more unit test cases. They are as follows - 
```
@Test
public void Jan1_2023_Sunday() {
  DateModel.initialize("2023", "1", "1");
  assertThat(DateModel.getMessage(), is("Sunday"));
}

@Test
public void Feb29_1900_isNotAvailable() {
  DateModel.initialize("1900", "02", "29");
  assertThat(DateModel.getMessage(), is("February of 1900 does not have 29 days"));
}
```
Since the emulator took too long to start, the instrumented test cases were tested on a physical Android mobile. 

## A.e - Time Taken
It took about 6 hours to complete the whole assignment. 
## A.f - Assignment Difficulty
4, on a scale of 1-10, where the 10 is the highest difficulty level. 
