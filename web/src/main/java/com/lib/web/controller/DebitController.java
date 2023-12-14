package com.lib.web.controller;

import com.lib.anno.AroundConduct;
import com.lib.model.Debit;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.DebitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debits")
@AroundConduct
public class DebitController {
private final DebitService debitService;

public DebitController(DebitService debitService) {
   this.debitService = debitService;
}

@GetMapping
public Response getDebits(@RequestBody(required = false) Parameter<Debit> parameter, @RequestHeader("token") String token) {
   return debitService.getBy(parameter);
}

@PostMapping
public Response createDebit(@RequestBody(required = false) Parameter<Debit> parameter, @RequestHeader("token") String token) {
   return debitService.create(parameter);
}

@GetMapping("/{id}")
public Response getDebit(@RequestBody(required = false) Parameter<Debit> parameter, @RequestHeader("token") String token,@PathVariable Integer id) {
   return debitService.getById(parameter);
}

@PatchMapping("/{id}")
public Response updateDebit(@RequestBody(required = false) Parameter<Debit> parameter, @RequestHeader("token") String token,@PathVariable Integer id) {
   return debitService.update(parameter);
}

@DeleteMapping("/{id}")
public Response deleteDebit(@RequestBody(required = false) Parameter<Debit> parameter, @RequestHeader("token") String token,@PathVariable Integer id) {
   return debitService.delete(parameter);
}
}
