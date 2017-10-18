package cad.osb.birthdaycountdown.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DaysUntilBirthdayCalculator {

    public double calculateDaysAmount(Date birthDate) {
        Calendar bDateTempCalendar = Calendar.getInstance();
        bDateTempCalendar.setTime(birthDate);
        // get current year
        Date currentDate = new Date();
        int currentYear = getCurrentYear(currentDate);
        // calculate diff betweet bDate year and current year
        int yearsDiff = currentYear - bDateTempCalendar.get(Calendar.YEAR);
        // shift bDate to current year
        bDateTempCalendar.add(Calendar.YEAR, yearsDiff);
        // get Date object for bDate
        Date currentYearBDate = bDateTempCalendar.getTime();

        double daysAmount = 0;
        if (currentYearBDate.getTime() >= currentDate.getTime()) {
            daysAmount = getAmount(currentYearBDate, currentDate);
        }
        else {
            bDateTempCalendar.add(Calendar.YEAR, 1);
            daysAmount = getAmount(bDateTempCalendar.getTime(), currentDate);
        }

        return daysAmount+=1;
    }

    private int getCurrentYear(Date currentDate) {
        Calendar currentDateCalendar = Calendar.getInstance();
        currentDateCalendar.setTime(currentDate);
        return currentDateCalendar.get(Calendar.YEAR);
    }

    private double getAmount(Date currentYearBDate, Date currentDate) {
        long birthDay = currentYearBDate.getTime();
        long current = currentDate.getTime();
        double daysAmount = (birthDay - current)/1000.0/60/60/24;
        return daysAmount;
    }

}
