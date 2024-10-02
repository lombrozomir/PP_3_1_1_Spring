package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserInputController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String showAddUserForm(){
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email, @RequestParam Byte age){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
        userService.createUser(user);
        return "redirect:/users";
    }

}
