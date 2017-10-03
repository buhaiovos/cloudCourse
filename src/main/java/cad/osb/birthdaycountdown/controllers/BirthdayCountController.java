package cad.osb.birthdaycountdown.controllers;

import cad.osb.birthdaycountdown.services.BirthdayService;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

@Controller
public class BirthdayCountController {

    private BirthdayService birthdayService;

    public BirthdayCountController(BirthdayService birthdayService) {
        this.birthdayService = birthdayService;
    }

    @RequestMapping(value = "/countdown", method = RequestMethod.POST)
    public String getBirthDayCountdown(
            @RequestParam("d") String bDate, Model model, HttpServletRequest request) {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        //resolver.setDefaultLocale(Locale.forLanguageTag("uk-UA"));
        Locale locale = resolver.resolveLocale(request);

        LogManager.getLogger(BirthdayCountController.class)
                .info("Initiating calculation for " + bDate);
        LogManager.getLogger(BirthdayCountController.class)
                .info("For locale " + locale);

        String days;
        try {
            days = birthdayService.getDaysTillBirthday(bDate, locale);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("days", days);

        return "countdown";
    }

    @RequestMapping(value = "/birthday")
    public String birthdayPage() {
        return "birthday";
    }
}
