package com.satya.springboot.jdbi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Autowired
    UserService userService;
    
    @RequestMapping(value="/user/list", method=RequestMethod.GET)	
    public List<User> list() {
        return userService.list();
    }

    @RequestMapping("/user/insert")
    public Integer insert() {
        return userService.insert();
    }
    
    @RequestMapping("/user/getId/{userId}")
    public String getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
    
    @RequestMapping("/user/getSum/{a}/{b}")
    public Integer getSum(@PathVariable int a, @PathVariable int b) {
        return userService.getSum(a, b);
    }

}
