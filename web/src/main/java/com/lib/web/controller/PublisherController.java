package com.lib.web.controller;

import com.lib.anno.AroundConduct;
import com.lib.model.Parameter;
import com.lib.model.Publisher;
import com.lib.model.Response;
import com.lib.service.PublisherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishers")
@AroundConduct
public class PublisherController {
private final PublisherService publisherService;

public PublisherController(PublisherService publisherService) {
   this.publisherService = publisherService;
}

@GetMapping
public Response getPublishers(@RequestBody(required = false) Parameter<Publisher> parameter, @RequestHeader("token") String token) {
   return publisherService.getBy(parameter);
}

@PostMapping
public Response createPublisher(@RequestBody(required = false) Parameter<Publisher> parameter, @RequestHeader("token") String token) {
   return publisherService.create(parameter);
}

@GetMapping("/{id}")
public Response getPublisher(@RequestBody(required = false) Parameter<Publisher> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return publisherService.getById(parameter);
}


@PatchMapping("/{id}")
public Response updatePublisher(@RequestBody(required = false) Parameter<Publisher> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return publisherService.update(parameter);
}

@DeleteMapping("/{id}")
public Response deletePublisher(@RequestBody(required = false) Parameter<Publisher> parameter, @RequestHeader("token") String token, @PathVariable Integer id) {
   return publisherService.delete(parameter);
}
}
