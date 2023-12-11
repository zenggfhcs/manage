package com.lib.web.controller;

import com.lib.model.Parameter;
import com.lib.model.Publisher;
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
public Response getPublishers(Parameter<Publisher> parameter, @RequestHeader("token") String token) {
   return publisherService.getBy(parameter);
}

@PostMapping
public Response createPublisher(@RequestBody Parameter<Publisher> parameter, @RequestHeader("token") String token) {
   return publisherService.create(parameter);
}

@GetMapping("/{id}")
public Response getPublisher(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<Publisher> _parameter = new Parameter<>();
   _parameter.setId(id);
   return publisherService.getById(_parameter);
}


@PatchMapping("/{id}")
public Response updatePublisher(@PathVariable Integer id, @RequestBody Parameter<Publisher> parameter, @RequestHeader("token") String token) {
   parameter.setId(id);
   return publisherService.update(parameter);
}

@DeleteMapping("/{id}")
public Response deletePublisher(@PathVariable Integer id, @RequestHeader("token") String token) {
   Parameter<Publisher> _parameter = new Parameter<>();
   _parameter.setId(id);
   return publisherService.delete(_parameter);
}
}
