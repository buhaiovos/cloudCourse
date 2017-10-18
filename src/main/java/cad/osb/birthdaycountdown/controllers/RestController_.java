package cad.osb.birthdaycountdown.controllers;

import cad.osb.birthdaycountdown.dto.BirthdayDTO;
import cad.osb.birthdaycountdown.dto.DaysTillBirthdayDTO;
import cad.osb.birthdaycountdown.dto.UserDTO;
import cad.osb.birthdaycountdown.services.BirthdayService;
import cad.osb.birthdaycountdown.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/rest")
public class RestController_ {

    private static final Logger LOG = LogManager.getLogger(RestController_.class);

    private BirthdayService birthdayService;
    private UserService userService;

    @Autowired
    public RestController_(BirthdayService service, UserService userService) {
        this.birthdayService = service;
        this.userService = userService;
    }

    @RequestMapping(value = "/birthday", method = RequestMethod.GET)
    public @ResponseBody DaysTillBirthdayDTO helloCheck() {
        LOG.info("Here");
        DaysTillBirthdayDTO response = new DaysTillBirthdayDTO();
        response.setDaysLeft("100500");
        return response;
    }

    @RequestMapping(value = "/birthday", method = RequestMethod.POST)
    public @ResponseBody DaysTillBirthdayDTO getDaysTillBirthday(
            @RequestBody BirthdayDTO birthdayDTO) throws ParseException {
        LOG.info("Here-2");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String daysLeft =
                birthdayService.getDaysTillBirthday(df.format(birthdayDTO.getDate()));
        DaysTillBirthdayDTO response = new DaysTillBirthdayDTO();
        response.setDaysLeft(daysLeft);
        LOG.info("Here-3");
        return response;
    }

    @GetMapping(value = "/users", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value="/user/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public UserDTO userById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }
}
