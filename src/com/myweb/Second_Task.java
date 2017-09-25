package com.myweb;

import java.util.Date;

/**
 * Created by Виталик on 26.05.2016.
 */
public class Second_Task {
    int id;
    int task_Task_ID;
    String description;
    Date deadline;
    Second_Task(int id,
            int task_Task_ID,
            String description,
            Date deadline){
        this.id=id;
        this.task_Task_ID=task_Task_ID;
        this.description=description;
        this.deadline=deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTask_Task_ID() {
        return task_Task_ID;
    }

    public void setTask_Task_ID(int task_Task_ID) {
        this.task_Task_ID = task_Task_ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
