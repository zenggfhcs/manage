package com.lib.web.controller;

import com.lib.model.BookInfo;
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
public Response getBookInfos(Parameter<BookInfo> parameter, @RequestHeader("token") String token) {
   return bookInfoService.getBy(parameter);
}

@PostMapping
public Response createBookInfo(@RequestBody Parameter<BookInfo> parameter, @RequestHeader("token") String token) {
   return bookInfoService.create(parameter);
}

@GetMapping("/{id}")
public Response getBookInfo(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<BookInfo> _parameter = new Parameter<>();
   _parameter.setId(id);
   
   return bookInfoService.getById(_parameter);
}

@PatchMapping("/{id}")
public Response updateBookInfo(@PathVariable Integer id, @RequestBody Parameter<BookInfo> parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return bookInfoService.update(parameter);
}

@DeleteMapping("/{id}")
public Response deleteBookInfo(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<BookInfo> _parameter = new Parameter<>();
   _parameter.setId(id);
   return bookInfoService.delete(_parameter);
}
}
