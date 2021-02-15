package web.controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import service.UserServiceImp;

import java.util.Map;

@Controller
public class HelloController {
    UserService userService = new UserServiceImp();

    @RequestMapping(value = "/")
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user to database
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        // get user from the service
        User user = userService.getUserById(id);
        // set user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {
        // call delete user method
        this.userService.removeUser(id);
        return "redirect:/";
    }

}