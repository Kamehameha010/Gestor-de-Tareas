package model;

public class Task extends Identity {
    private String taskName;
    private String taskDescription;
    private long taskDate;
    private boolean taskIsCompleted;
    private int idUser;

    public Task() {

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

    public void setTaskIsCompleted(Boolean isCompleted) {
        taskIsCompleted = isCompleted;
    }

    public boolean getTaskIsCompleted() {
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
        return String.format("Task{_id: %d, name:%s, description : %s, date:%s, completed:%s, id_user: %d}", getId(), taskName,
                taskDescription, taskDate, taskIsCompleted, idUser);
    }

}
