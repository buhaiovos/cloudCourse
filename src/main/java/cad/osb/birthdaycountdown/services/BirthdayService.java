package cad.osb.birthdaycountdown.services;

import cad.osb.birthdaycountdown.domain.DaysUntilBirthdayCalculator;
import org.apache.logging.log4j.LogManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BirthdayService {

    public String getDaysTillBirthday(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateString);

        return getDayTillBirthDayFromDateObj(date);
    }

    public String getDayTillBirthDayFromDateObj(Date date) {
        DaysUntilBirthdayCalculator calculator =
                new DaysUntilBirthdayCalculator();
        double days = calculator.calculateDaysAmount(date);

        long daysWholeNumber = (long)days;

        return new StringBuilder(daysWholeNumber + " days").toString();
    }
}
