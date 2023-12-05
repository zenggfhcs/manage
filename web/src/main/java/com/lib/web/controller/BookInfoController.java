package com.lib.web.controller;

import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.BookInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookInfos")
public class BookInfoController {
private final BookInfoService bookInfoService;

public BookInfoController(BookInfoService bookInfoService) {
   this.bookInfoService = bookInfoService;
}

@GetMapping
public Response getBookInfos(Parameter parameter, @RequestHeader("token") String token) {
   return Response.success();
}

@PostMapping
public Response createBookInfo(@RequestBody Parameter parameter, @RequestHeader("token") String token) {
   return Response.success();
}

@GetMapping("/{id}")
public Response getBookInfo(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   return bookInfoService.getById(parameter, token);
}

@PatchMapping("/{id}")
public Response updateBookInfo(@PathVariable Integer id, @RequestBody Parameter parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return Response.success();
}

@DeleteMapping("/{id}")
public Response deleteBookInfo(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   return Response.success();
}
}
