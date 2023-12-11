package com.lib.web.controller;


import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.User;
import com.lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

private final UserService userService;

@Autowired
public UserController(UserService userService) {
   this.userService = userService;
}

@PostMapping("/login")
public Response login(@RequestBody Parameter<User> parameter, @RequestHeader("token") String token) {
   return userService.login(parameter);
}

@GetMapping
public Response getUsers(Parameter<User> parameter, @RequestHeader("token") String token) {
   return userService.getBy(parameter);
}

@PostMapping
public Response createUser(@RequestBody Parameter<User> parameter, @RequestHeader("token") String token) {
   return userService.create(parameter);
}

@GetMapping("/{id}")
public Response getUser(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<User> _parameter = new Parameter<>();
   _parameter.setId(id);
   return userService.getById(_parameter);
}

@PatchMapping("/{id}")
public Response updateUser(@PathVariable Integer id, @RequestBody Parameter<User> parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return userService.update(parameter);
}


@DeleteMapping("/{id}")
public Response deleteUser(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<User> _parameter = new Parameter<>();
   _parameter.setId(id);
   return userService.delete(_parameter);
}
}
