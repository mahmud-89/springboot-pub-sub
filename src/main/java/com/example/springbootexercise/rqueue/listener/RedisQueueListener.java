package com.example.springbootexercise.rqueue.listener;


import com.example.springbootexercise.rqueue.model.RQBaseObject;
import com.example.springbootexercise.rqueue.task_manager.RQTaskManager;
import com.github.sonus21.rqueue.annotation.RqueueListener;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisQueueListener {
    private final RQTaskManager taskManager;
    private Logger logger = LoggerFactory.getLogger(RedisQueueListener.class);

    @RqueueListener(value = "promise", numRetries = "2")
    public void getTaskFromRQ(RQBaseObject requestBody) {
        logger.info("request body details: " + requestBody);
        taskManager.manageTask(requestBody);
    }

    @MessageExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        logger.info("Message consumer error: " + e);
    }

}
