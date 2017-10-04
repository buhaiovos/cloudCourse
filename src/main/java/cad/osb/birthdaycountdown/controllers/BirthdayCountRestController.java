package cad.osb.birthdaycountdown.controllers;

import cad.osb.birthdaycountdown.dto.BirthdayDTO;
import cad.osb.birthdaycountdown.dto.DaysTillBirthdayDTO;
import cad.osb.birthdaycountdown.services.BirthdayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class BirthdayCountRestController {

    private static final Logger LOG = LogManager.getLogger(BirthdayCountRestController.class);

    private BirthdayService service;

    public BirthdayCountRestController(BirthdayService service) {
        this.service = service;
    }

    @RequestMapping(value = "/rest/birthday", method = RequestMethod.GET)
    public @ResponseBody DaysTillBirthdayDTO helloCheck() {
        LOG.info("Here");
        DaysTillBirthdayDTO response = new DaysTillBirthdayDTO();
        response.setDaysLeft("100500");
        return response;
    }

    @RequestMapping(value = "/rest/birthday", method = RequestMethod.POST)
    public @ResponseBody DaysTillBirthdayDTO getDaysTillBirthday(
            @RequestBody BirthdayDTO birthdayDTO) throws ParseException {
        LOG.info("Here-2");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String daysLeft =
                service.getDaysTillBirthday(df.format(birthdayDTO.getDate()));
        DaysTillBirthdayDTO response = new DaysTillBirthdayDTO();
        response.setDaysLeft(daysLeft);
        LOG.info("Here-3");
        return response;
    }

}
