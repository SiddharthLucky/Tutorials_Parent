package DateTime_Annotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static java.time.format.DateTimeFormatter.*;

public class DateTime
{
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public DateTime(int year, int month, int date)
    {
        setYear(year);
        setMonth(month);
        setDay(date);

        LocalDate oldDate = LocalDate.of(getYear(), getMonth(), getDay());
        LocalDate locDate = LocalDate.now();

        dateCDiffalculate(locDate, oldDate);
    }

    @Developer(name = "Sid",
            date = "2015-06-19",
            description = "Date Time methods with Annotation",
            functionality = Developer.Functionality.HR,
            rank = 1)
    public void dateCDiffalculate(LocalDate locDate, LocalDate oldDate)
    {
        System.out.println("Date Difference: "+ ChronoUnit.DAYS.between(locDate, oldDate));
    }

    @Developer(name = "Sid",
            date = "2015-06-19",
            description = "Date Time methods with Annotation",
            functionality = Developer.Functionality.HR,
            rank = 1)
    public void dateFormat(String date)
    {
        String dt_timeStamp = date;
        System.out.println("Printing Date "+ dt_timeStamp);
        DateTimeFormatter formatter = ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime user_dTime = LocalDateTime.parse(dt_timeStamp, formatter);
        LocalDateTime curr_dtime = LocalDateTime.now();

        System.out.println("Date Difference with time stamp: "+ ChronoUnit.DAYS.between(curr_dtime, user_dTime));

        DateTimeFormatter re_formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        System.out.println("New Date Time Formatted: "+ user_dTime.format(re_formatter));
    }
}
