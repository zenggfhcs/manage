package com.lib.web.controller;

import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.impl.BookDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

private BookDefaultService bookDefaultService;

@Autowired
public BookController(BookDefaultService bookDefaultService) {
   this.bookDefaultService = bookDefaultService;
}


@GetMapping
public Response getBooks(Parameter parameter, @RequestHeader("token") String token) {
   return Response.success();
}

@PostMapping
public Response createBook(Parameter parameter, @RequestHeader("token") String token) {
   return Response.success();
}

@GetMapping("/{id}")
public Response getBook(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   return bookDefaultService.getById(parameter, token);
}

@PatchMapping("/{id}")
public Response updateBook(@PathVariable Integer id, Parameter parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return Response.success();
}

@DeleteMapping("/{id}")
public Response deleteBook(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   return Response.success();
}
}
