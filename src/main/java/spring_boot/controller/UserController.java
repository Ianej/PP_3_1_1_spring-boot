package spring_boot.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring_boot.service.UserService;

@Controller
public class UserController {
    @Autowired
    //@Qualifier("userServiceImpl")/**/
    private UserService userService;

    @GetMapping(value = "/")
    public String printUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.listUsers());
        return "index";
    }

    @GetMapping(value = "/newUser")
    public String newUser(User user, ModelMap modelMap) {//
        modelMap.addAttribute("user", user);
        return "newUser";
    }

    @PostMapping(value = "/newUser")
    public String newUser(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String editUser (@RequestParam() long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUser(id) );
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editUser (@RequestParam() long id, User user) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
