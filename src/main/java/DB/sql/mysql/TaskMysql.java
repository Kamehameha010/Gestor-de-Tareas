package DB.sql.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.IConnection;
import model.Task;
import services.ICrudServices;

public class TaskMysql implements ICrudServices<Task, Task> {

    private final String INSERT = "INSERT INTO TASKS VALUES(null,?,?,?,?,?)";
    private final String UPDATE = "UPDATE TASKS SET taskname=?, description=?, date=?,isCompleted=? WHERE id_task=?";
    private final String DELETE = "DELETE FROM TASKS WHERE id_task=?";
    private final String FIND_BY_ID = "SELECT * FROM TASKS WHERE id_task=?";
    private final String GET_ALL = "SELECT * FROM TASKS WHERE id_user=?";

    private IConnection<Connection> mysql;

    public TaskMysql() {
        mysql = new ConnectionMysql();
    }

    @Override
    public void Insert(Task obj) throws SQLException {

        var conn = mysql.connect();
        var stmp = conn.prepareStatement(INSERT);
        stmp.setString(1, obj.getTaskName());
        stmp.setString(2, obj.getTaskDescription());
        stmp.setLong(3, obj.getTaskDate());
        stmp.setInt(4, obj.getTaskIsCompleted().getValue());
        stmp.setInt(5, obj.getIdUser());
        try {
            stmp.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    @Override
    public void Edit(Task obj) throws SQLException {
        System.out.println("Mysql-->" + obj);
        var conn = mysql.connect();
        var stmp = conn.prepareStatement(UPDATE);
        stmp.setString(1, obj.getTaskName());
        stmp.setString(2, obj.getTaskDescription());
        stmp.setLong(3, obj.getTaskDate());
        stmp.setInt(4, obj.getTaskIsCompleted().getValue());
        stmp.setInt(5, obj.getId());
        try {
            stmp.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    @Override
    public void Delete(int id) throws SQLException {
        var conn = mysql.connect();
        var stmp = conn.prepareStatement(DELETE);
        stmp.setInt(1, id);
        try {
            stmp.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    @Override
    public Task Find(int id) throws SQLException {
        var conn = mysql.connect();
        var stmp = conn.prepareStatement(FIND_BY_ID);
        stmp.setInt(1, id);
        Task task = new Task();
        try {
            var rs = stmp.executeQuery();

            while (rs.next()) {
                task.setId(rs.getInt(1));
                task.setTaskName(rs.getString(2));
                task.setTaskDescription(rs.getString(3));
                task.setTaskDate(rs.getLong(4));
                task.setTaskIsCompleted(rs.getInt(5));
                task.setIdUser(rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return task;
    }

    @Override
    public List<Task> GetAll(int id) throws SQLException {

        ArrayList<Task> tasks = new ArrayList<>();

        var conn = mysql.connect();
        var stmp = conn.prepareStatement(GET_ALL);
        stmp.setInt(1, id);
        try {
            var rs = stmp.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt(1));
                task.setTaskName(rs.getString(2));
                task.setTaskDescription(rs.getString(3));
                task.setTaskDate(rs.getLong(4));
                task.setTaskIsCompleted(rs.getInt(5));
                task.setIdUser(rs.getInt(6));
                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return tasks;
    }

}
