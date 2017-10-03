package cad.osb.birthdaycountdown.services;

import cad.osb.birthdaycountdown.domain.DaysUntilBirthdayCalculator;
import org.apache.logging.log4j.LogManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BirthdayService {

    public String getDaysTillBirthday(String dateString, Locale locale) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateString);

        return getDayTillBirthDayFromDateObj(date, locale);
    }

    public String getDayTillBirthDayFromDateObj(Date date, Locale locale) {
        DaysUntilBirthdayCalculator calculator =
                new DaysUntilBirthdayCalculator(locale);
        double days = calculator.calculateDaysAmount(date);

        long daysWholeNumber = (long)days;
        double fraction = days - daysWholeNumber;
        LogManager.getLogger(BirthdayService.class).info("fractoion " + fraction);
        long hours = (long) (fraction * 24);
        LogManager.getLogger(BirthdayService.class).info("hours " + hours);

        return new StringBuilder(daysWholeNumber + " days " +
                hours + " hours").toString();
    }
}
