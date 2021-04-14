package com.cr.view.customer;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.cr.model.Task;

public class TaskTable extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String m_colNames[] = { "Id", "Name", "Description", "Date", "Completed" };
    private List<Task> m_tasks;

    public TaskTable(List<Task> tasks) {
        m_tasks = tasks;
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column];
    }

    @Override
    public int getRowCount() {
        return m_tasks.size();
    }

    @Override
    public int getColumnCount() {

        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
        case 0 -> m_tasks.get(rowIndex).getId();
        case 1 -> m_tasks.get(rowIndex).getTaskName();
        case 2 -> m_tasks.get(rowIndex).getTaskDescription();
        case 3 -> m_tasks.get(rowIndex).getTaskDate();
        case 4 -> m_tasks.get(rowIndex).getTaskIsCompleted();
        }
        return null;
    }

    public Task getRowTask(int row) {
        return m_tasks.get(row);
    }

}
