package cad.osb.birthdaycountdown.controllers;

import cad.osb.birthdaycountdown.dto.UserDTO;
import cad.osb.birthdaycountdown.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/useredit")
    public ModelAndView showUserForm() {
        return new ModelAndView("userform", "command", new UserDTO());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("user")UserDTO user) {
        userService.createUser(user);
        return new ModelAndView("redirect:/listusers");
    }

    @RequestMapping("/listusers")
    public ModelAndView listUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return new ModelAndView("listusers", "list", users);
    }

    @RequestMapping("/edituser/{id}")
    public ModelAndView editUser(@PathVariable int id) {
        UserDTO user = userService.getUserById(id);
        return new ModelAndView("usereditform", "command", user);
    }

    @RequestMapping(value = "/savechange", method = RequestMethod.POST)
    public ModelAndView saveEditedUser(@ModelAttribute("user") UserDTO user) {
        userService.updateUser(user);
        return new ModelAndView("redirect:/listusers");
    }

    @RequestMapping("/deleteuser/{id}")
    public ModelAndView deleteUser(@PathVariable int id) {
        UserDTO user = userService.getUserById(id);
        userService.deleteUser(user);
        return new ModelAndView("redirect:/listusers");
    }
}
