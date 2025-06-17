package com.taskmanager.taskbackend.websocket;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskMessage {

    private String message;
    private String taskTitle;

    public TaskMessage() {
    }

    public TaskMessage(String message, String taskTitle) {
        this.message = message;
        this.taskTitle = taskTitle;
    }

}
