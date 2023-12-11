package com.lib.web.controller;

import com.lib.model.Debit;
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
public Response getDebits(Parameter<Debit> parameter, @RequestHeader("token") String token) {
   return debitService.getBy(parameter);
}

@PostMapping
public Response createDebit(@RequestBody Parameter<Debit> parameter, @RequestHeader("token") String token) {
   return debitService.create(parameter);
}

@GetMapping("/{id}")
public Response getDebit(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<Debit> _parameter = new Parameter<>();
   _parameter.setId(id);
   return debitService.getById(_parameter);
}

@PatchMapping("/{id}")
public Response updateDebit(@PathVariable Integer id, @RequestBody Parameter<Debit> parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return Response.success();
}

@DeleteMapping("/{id}")
public Response deleteDebit(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<Debit> _parameter = new Parameter<>();
   _parameter.setId(id);
   return debitService.delete(_parameter);
}
}
