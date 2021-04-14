package com.cr.model;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Task extends Identity {
    private String taskName;
    private String taskDescription;
    private long taskDate;
    private TaskStatus taskIsCompleted;
    @BsonProperty("id_user")
    private int idUser;

    public Task() {

    }

    public Task(int idTask, int user, String name, String description, long date, TaskStatus completed) {
        setId(idTask);
        idUser = user;
        taskName = name;
        taskDescription = description;
        taskDate = date;
        taskIsCompleted = completed;
    }

    public void setTaskName(String name) {
        taskName = name;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskDescription(String description) {
        taskDescription = description;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDate(long date) {
        taskDate = date;
    }

    public long getTaskDate() {
        return this.taskDate;
    }

    public void setTaskIsCompleted(int isCompleted) {
        taskIsCompleted = TaskStatus.valueOf(isCompleted);
    }

    public TaskStatus getTaskIsCompleted() {
        return this.taskIsCompleted;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return this.idUser;
    }

    @Override
    public String toString() {
        return String.format("Task{_id: %d, name:%s, description : %s, date:%s, completed:%s, id_user: %d}", getId(),
                taskName, taskDescription, taskDate, taskIsCompleted, idUser);
    }

}
