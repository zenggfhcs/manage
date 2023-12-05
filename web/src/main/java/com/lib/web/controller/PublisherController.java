package com.lib.web.controller;

import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.PublisherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
private final PublisherService publisherService;

public PublisherController(PublisherService publisherService) {
   this.publisherService = publisherService;
}

@GetMapping
public Response getPublishers(Parameter parameter, @RequestHeader("token") String token) {
   return publisherService.getBy(parameter, token);
}

@PostMapping
public Response createPublisher(Parameter parameter, @RequestHeader("token") String token) {
   return publisherService.create(parameter, token);
}

@GetMapping("/{id}")
public Response getPublisher(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   return publisherService.getById(parameter, token);
}


@PatchMapping("/{id}")
public Response updatePublisher(@PathVariable Integer id, @RequestBody Parameter parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return publisherService.update(parameter, token);
}

@DeleteMapping("/{id}")
public Response deletePublisher(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter parameter = new Parameter();
   parameter.setId(id);
   return publisherService.update(parameter, token);
}
}
