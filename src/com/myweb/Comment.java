package com.myweb;

/**
 * Created by Виталик on 26.05.2016.
 */
public class Comment {
    int id;
    String description;
    int task_Task_Id;
    Comment(int id,
            String description,
            int task_Task_Id){
        this.id=id;
        this.description=description;
        this.task_Task_Id=task_Task_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTask_Task_Id() {
        return task_Task_Id;
    }

    public void setTask_Task_Id(int task_Task_Id) {
        this.task_Task_Id = task_Task_Id;
    }
}
