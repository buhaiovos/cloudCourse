package cad.osb.birthdaycountdown.controllers;

import cad.osb.birthdaycountdown.dto.BirthdayDTO;
import cad.osb.birthdaycountdown.dto.DaysTillBirthdayDTO;
import cad.osb.birthdaycountdown.services.BirthdayService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/rest")
public class BirthdayCountRestController {

    private BirthdayService service;

    public BirthdayCountRestController(BirthdayService service) {
        this.service = service;
    }

    @RequestMapping(value = "/birthday", method = RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public DaysTillBirthdayDTO getDaysTillBirthday(
            @RequestBody BirthdayDTO birthdayDTO) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String daysLeft =
                service.getDaysTillBirthday(df.format(birthdayDTO.getDate()));
        DaysTillBirthdayDTO response = new DaysTillBirthdayDTO();
        response.setDaysLeft(daysLeft);
        return response;
    }

}
