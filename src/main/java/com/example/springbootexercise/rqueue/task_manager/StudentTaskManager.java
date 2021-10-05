package com.example.springbootexercise.rqueue.task_manager;

import com.example.springbootexercise.redis.services.RedisMessagePublisher;
import com.example.springbootexercise.rqueue.model.RQBaseObject;
import com.example.springbootexercise.rqueue.model.StudentRequestBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentTaskManager implements RQTaskManager{
    private final RedisMessagePublisher redisMessagePublisher;
    private Logger logger = LoggerFactory.getLogger(StudentTaskManager.class);

    @Override
    public void manageTask(RQBaseObject rqBaseObject) {
        logger.info("requestbody received from queue  as : "+ rqBaseObject);
        StudentRequestBody requestModel = (StudentRequestBody) rqBaseObject;
        logger.info("requestbody received from queue  as : "+ requestModel);
        publish("abc",requestModel);
        CloseableHttpClient client = HttpClients.createDefault();
    }

    private void publish(String channelName, StudentRequestBody requestModel){
        try {
            redisMessagePublisher.publish(channelName,requestModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
