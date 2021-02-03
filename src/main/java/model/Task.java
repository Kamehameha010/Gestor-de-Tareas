package model;

public class Task extends Identity {

    private String taskName;
    private String taskDescription;
    private long taskDate;
    private boolean taskCompleted;

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

    public void setTaskCompleted(Boolean isCompleted) {
        taskCompleted = isCompleted;
    }

    public boolean getTaskCompleted() {
        return this.taskCompleted;
    }

    @Override
    public String toString() {
        return String.format("Task{_id: %d, name:%s, description : %s, date:%s, completed:%s }", getId(), taskName,
                taskDescription, taskDate, taskCompleted);
    }

}
