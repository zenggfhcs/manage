package com.lib.web.controller;


import com.lib.anno.AroundConduct;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.model.User;
import com.lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AroundConduct
public class UserController {

private final UserService userService;

@Autowired
public UserController(UserService userService) {
   this.userService = userService;
}

@PostMapping("/login")
public Response login(@RequestBody(required = false) Parameter<User> parameter, @RequestHeader("token") String token) {
   return userService.login(parameter);
}

@GetMapping
public Response getUsers(@RequestBody(required = false) Parameter<User> parameter, @RequestHeader("token") String token) {
   return userService.getBy(parameter);
}

@PostMapping
public Response createUser(@RequestBody(required = false) Parameter<User> parameter, @RequestHeader("token") String token) {
   return userService.create(parameter);
}

@GetMapping("/{id}")
public Response getUser(@RequestBody(required = false) Parameter<User> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return userService.getById(parameter);
}

@PatchMapping("/{id}")
public Response updateUser(@RequestBody(required = false) Parameter<User> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return userService.update(parameter);
}


@DeleteMapping("/{id}")
public Response deleteUser(@RequestBody(required = false) Parameter<User> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return userService.delete(parameter);
}
}
