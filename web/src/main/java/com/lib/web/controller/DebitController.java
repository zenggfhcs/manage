package com.lib.web.controller;

import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.DebitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debits")
public class DebitController {
private final DebitService debitService;

public DebitController(DebitService debitService) {
   this.debitService = debitService;
}

@GetMapping
public Response getDebits(Parameter parameter, @RequestHeader("token") String token) {
   return Response.success();
}

@PostMapping
public Response createDebit(@RequestBody Parameter parameter, @RequestHeader("token") String token) {
   return Response.success();
}

@GetMapping("/{id}")
public Response getDebit(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   return Response.success();
}

@PatchMapping("/{id}")
public Response updateDebit(@PathVariable Integer id, @RequestBody Parameter parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return Response.success();
}

@DeleteMapping("/{id}")
public Response deleteDebit(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   return Response.success();
}
}
