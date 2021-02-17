package execute;

import java.sql.SQLException;
import java.util.Date;

import DB.sql.mysql.TaskMysql;
import model.Task;

public class App {

    public static void main(String[] args) throws SQLException {

        var task1 = new Task();

        task1.setTaskName("juan");
        task1.setTaskDescription("García");
        task1.setTaskDate(new Date().getTime());
        task1.setTaskIsCompleted(false);
        task1.setIdUser(3);

        var task2 = new Task();

        task2.setTaskName("juan");
        task2.setTaskDescription("García");
        task2.setTaskDate(new Date().getTime());
        task2.setTaskIsCompleted(false);
        task2.setIdUser(3);

        var imp = new TaskMysql();

        try {
            /*
             * imp.Insert(task1); imp.Insert(task2);
             */
            var us = imp.Find(2);
            System.out.println(us);
            /* for (var task : imp.GetAll()) {
                System.out.println(task);
            } */
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}