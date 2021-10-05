package com.example.springbootexercise.rqueue.task_manager;

import com.example.springbootexercise.rqueue.model.RQBaseObject;
import com.example.springbootexercise.rqueue.model.StudentRequestBody;

public interface RQTaskManager {
    void manageTask(RQBaseObject rqBaseObject);
}
