package cad.osb.birthdaycountdown.controllers;

import cad.osb.birthdaycountdown.services.BirthdayService;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;

@Controller
public class BirthdayCountController {

    private BirthdayService birthdayService;

    public BirthdayCountController(BirthdayService birthdayService) {
        this.birthdayService = birthdayService;
    }

    @RequestMapping(value = "/countdown", method = RequestMethod.POST)
    public String getBirthDayCountdown(@RequestParam("d") String bDate, Model model) {
        LogManager.getLogger(BirthdayCountController.class).info(bDate);
        String days;
        try {
            days = birthdayService.getDaysTillBirthday(bDate);
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
