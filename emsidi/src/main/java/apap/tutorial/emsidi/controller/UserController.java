package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.repository.UserDb;
import apap.tutorial.emsidi.service.RoleService;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDb userDb;

    @Autowired
    private RoleService roleService;

    @RolesAllowed("Admin")
    @GetMapping(value="/add")
    private String addUserForm(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value="/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @RolesAllowed("Admin")
    @GetMapping(value = "/viewall")
    private String listUser(Model model) {
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @RolesAllowed("Admin")
    @GetMapping(value = "/delete/{id}")
    private String deleteForm(
            @PathVariable String id,
            Model model
    ){
        UserModel user = userService.getUserById(id);
        model.addAttribute("user", user);
        userService.deleteUser(user);
        return "delete-user";
    }

    @GetMapping(value = "/updatePass/{username}")
    private String updatePass(
            @PathVariable String username,
            Model model
    ){
        UserModel user = userDb.findByUsername(username);
        model.addAttribute("user", user);

        return "form-update-password";
    }

    @PostMapping(value = "/updatepass")
    private String updatePassSubmit(
            @PathVariable String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "oldpassword", required = false) String oldPassword
    ) {
        UserModel user = userDb.findByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(userService.encrypt(password));
            userDb.save(user);
        }
        return "update-password";
    }

}
