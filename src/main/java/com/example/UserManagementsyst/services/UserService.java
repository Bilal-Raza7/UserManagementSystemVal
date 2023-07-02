package com.example.UserManagementsyst.services;

import com.example.UserManagementsyst.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
public class UserService {
    private List<User> UserList;
@GetMapping("/users")
    public List<User> getUserList() {
        return UserList;
    }
    @GetMapping("/user")
    public String getUser(@RequestParam Integer id){
        for(User myUser:UserList){
            if(myUser.getUserId().equals(id)){
                return "User found "+myUser;
            }
        }
        return "User not found";
    }
    @PostMapping("/newUser")
    public String newUser(@RequestBody User user){
        UserList.add(user);
        return "User added";
    }
    @DeleteMapping("/removeUser")
    public String delUser(@RequestParam Integer id){
        for(User myU:UserList){
            if(myU.getUserId().equals(id)){
             UserList.remove(myU);
             return "User removed ";
            }
        }
        return "User not found";
    }
    @PutMapping("/updateUser")
    public String UpUser(@RequestParam Integer id, @RequestParam LocalDate date,@RequestParam String email , @RequestParam Long Phone,@RequestParam LocalDate dob){
        for(User myU:UserList){
            if(myU.getUserId().equals(id)){
                myU.setDate(date);
                myU.setUserEmail(email);
                myU.setPhoneNumber(Phone);
                myU.setDoB(dob);
                return "User info updated";
            }
        }
        return "User not found";
    }
}
