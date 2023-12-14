package com.lib.web.controller;

import com.lib.anno.AroundConduct;
import com.lib.model.BookInfo;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.BookInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookInfos")
@AroundConduct
public class BookInfoController {
private final BookInfoService bookInfoService;

public BookInfoController(BookInfoService bookInfoService) {
   this.bookInfoService = bookInfoService;
}

@GetMapping
public Response getBookInfos(@RequestBody(required = false) Parameter<BookInfo> parameter, @RequestHeader("token") String token) {
   return bookInfoService.getBy(parameter);
}

@PostMapping
public Response createBookInfo(@RequestBody(required = false) Parameter<BookInfo> parameter, @RequestHeader("token") String token) {
   return bookInfoService.create(parameter);
}

@GetMapping("/{id}")
public Response getBookInfo(@RequestBody(required = false) Parameter<BookInfo> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookInfoService.getById(parameter);
}

@PatchMapping("/{id}")
public Response updateBookInfo(@RequestBody(required = false) Parameter<BookInfo> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookInfoService.update(parameter);
}

@DeleteMapping("/{id}")
public Response deleteBookInfo(@RequestBody(required = false) Parameter<BookInfo> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookInfoService.delete(parameter);
}
}
