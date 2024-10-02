package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

@Controller
public class UserDeleteController {

    @Autowired
    private UserService userService;

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam long id) {
        boolean success = userService.deleteUser(id);
        if (success) {
            return "redirect:/users";
        } else {
            return "redirect:/error";
        }
    }

}
