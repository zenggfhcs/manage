package com.lib.web.controller;

import com.lib.model.Book;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

private final BookService bookService;

@Autowired
public BookController(BookService bookService) {
   this.bookService = bookService;
}


@GetMapping
public Response getBooks(Parameter<Book> parameter, @RequestHeader("token") String token) {
   return bookService.getBy(parameter);
}

@PostMapping
public Response createBook(@RequestBody Parameter<Book> parameter, @RequestHeader("token") String token) {
   return bookService.create(parameter);
}

@GetMapping("/{id}")
public Response getBook(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<Book> _parameter = new Parameter<>();
   _parameter.setId(id);
   return bookService.getById(_parameter);
}

@PatchMapping("/{id}")
public Response updateBook(@PathVariable Integer id, @RequestBody Parameter<Book> parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return bookService.update(parameter);
}

@DeleteMapping("/{id}")
public Response deleteBook(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<Book> _parameter = new Parameter<>();
   _parameter.setId(id);
   return bookService.delete(_parameter);
}
}
