package com.myweb;

import java.util.Date;

/**
 * Created by Виталик on 26.05.2016.
 */
public class Task {
    int task_Id;
    int person_Id;
    String name;
    String description;
    Date start_date;
    Date deadline;
    int condition;
    Task(int task_Id,
            int person_Id,
            String name,
            String description,
            Date start_date,
            Date deadline ,
         int condition){
        this.task_Id=task_Id;
        this.person_Id=person_Id;
        this.name=name;
        this.description=description;
        this.start_date=start_date;
        this.deadline=deadline;
        this.condition=condition;
    }

    public int getTask_Id() {
        return task_Id;
    }

    public void setTask_Id(int task_Id) {
        this.task_Id = task_Id;
    }



    public int getPerson_Id() {
        return person_Id;
    }

    public void setPerson_Id(int person_Id) {
        this.person_Id = person_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_Id=" + task_Id +
                ", person_Id=" + person_Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", deadline=" + deadline +
                ", condition=" + condition +
                '}';
    }
}
