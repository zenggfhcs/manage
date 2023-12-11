package com.lib.web.controller;

import com.lib.model.GetLog;
import com.lib.model.Parameter;
import com.lib.model.Response;
import com.lib.service.GetLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class GetLogController {
private final GetLogService logService;

public GetLogController(GetLogService logService) {
   this.logService = logService;
}

@GetMapping
public Response getLogs(Parameter<GetLog> parameter, @RequestHeader("token") String token) {
   return logService.getBy(parameter);
}
}
