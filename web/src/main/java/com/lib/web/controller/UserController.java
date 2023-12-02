package com.lib.web.controller;


import com.lib.model.Parameter;
import com.lib.model.Response;
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
public Response login(Parameter parameter, @RequestHeader("token") String token) {
   return userService.login(parameter, token);
}

@GetMapping
public Response getUsers(Parameter parameter, @RequestHeader("token") String token) {
   return userService.getBy(parameter, token);
}

@PostMapping
public Response createUser(Parameter parameter, @RequestHeader("token") String token) {
   return userService.create(parameter, token);
}

@GetMapping("/{id}")
public Response getUser(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   return userService.getById(parameter, token);
}

@PatchMapping("/{id}")
public Response updateUser(@PathVariable Integer id, Parameter parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return userService.update(parameter, token);
}


@DeleteMapping("/{id}")
public Response deleteUser(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   
   return userService.delete(parameter, token);
}
}
