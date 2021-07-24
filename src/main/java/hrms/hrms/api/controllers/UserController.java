package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping(name = "getUserByEmail")
    @ResponseBody
    public DataResult<User> getUserByEmail(@RequestParam String email){
        return userService.getByEmail(email);
    }
}
