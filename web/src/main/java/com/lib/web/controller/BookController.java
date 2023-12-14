package com.lib.web.controller;

import com.lib.anno.AroundConduct;
import com.lib.model.Book;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@AroundConduct
public class BookController {

private final BookService bookService;

@Autowired
public BookController(BookService bookService) {
   this.bookService = bookService;
}


@GetMapping
public Response getBooks(@RequestBody(required = false) Parameter<Book> parameter, @RequestHeader("token") String token) {
   return bookService.getBy(parameter);
}

@PostMapping
public Response createBook(@RequestBody(required = false) Parameter<Book> parameter, @RequestHeader("token") String token) {
   return bookService.create(parameter);
}

@GetMapping("/{id}")
public Response getBook(@RequestBody(required = false) Parameter<Book> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookService.getById(parameter);
}

@PatchMapping("/{id}")
public Response updateBook(@RequestBody(required = false) Parameter<Book> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookService.update(parameter);
}

@DeleteMapping("/{id}")
public Response deleteBook(@RequestBody(required = false) Parameter<Book> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookService.delete(parameter);
}
}
