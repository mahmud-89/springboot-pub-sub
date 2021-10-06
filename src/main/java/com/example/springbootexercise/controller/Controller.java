package com.example.springbootexercise.controller;


import com.example.springbootexercise.rqueue.model.StudentRequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sonus21.rqueue.core.RqueueMessageEnqueuer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enqueue")
@RequiredArgsConstructor
public class Controller {
    private final ObjectMapper objectMapper;
    private final RqueueMessageEnqueuer rqueueMessageEnqueuer;

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping(value="student_info",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String postStudent(@RequestBody StudentRequestBody requestBody) {
        rqueueMessageEnqueuer.enqueue("promise",requestBody);
        logger.info("student data enqueued successfully with : "+requestBody);
        return "request on process. please wait...";
    }

    @GetMapping(value = "greetings")
    public String welcomeGreetings(){
        return "Welcome to pub-sub apps";
    }



}

