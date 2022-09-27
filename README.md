# WhatDay

This simple Android app asks the user for a date in the Gregorian calendar and returns the day of the week for that date.

# Deliverables

## A.a - Submission Details

Project - Assignment1, What Day App

Name - Aastha Rastogi

ID - 2019A7PS0175G

Email - f20190175@goa.bits-pilani.ac.in

## A.b - App Description

This app takes input from the user for a date, and displays the day for that particular date. If the input is invalid, i.e. not in DD-MM-YYYY format, it displays that the input is valid. 

### Known Bugs

## A.c - How I completed Tasks

### Task1


###  Task2

###  Task3

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
The instrumented test cases were tested on a physical Android mobile, since the emulator took too long to start. 
## A.e - Time Taken
It took about 6 hours to complete the whole assignment. 
## A.f - Assignment Difficulty
4, on a scale of 1-10, where the 10 is the highest difficulty level. 
