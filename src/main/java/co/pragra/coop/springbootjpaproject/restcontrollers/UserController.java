package co.pragra.coop.springbootjpaproject.restcontrollers;

import co.pragra.coop.springbootjpaproject.entities.User;
import co.pragra.coop.springbootjpaproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

//This controller communicate the services class
    //Inject  Services class

    @Autowired
    private UserService userService;

    //API Post Method
    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }

    //API Get Method
    @GetMapping("/user/{login}")
    public User findUserByLogin(@Valid @PathVariable String login){
        return  userService.getUserByLogin(login);
    }
    //API Get All Entities
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //API Put method
    @PutMapping("/updateUser")
    public User updateUser(@Valid @RequestBody User user){
        return userService.updateUser(user);
    }

    //API Delete Method
    @DeleteMapping("/delete/{login}")
    public String deleteUser(@Valid @PathVariable String login){
        return userService.deleteUser(login);
    }
}
