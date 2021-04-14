package com.cr.model;

import java.util.Hashtable;
import java.util.Map;

public enum TaskStatus {
	Pending(0), Suspend(1), Completed(2);

	private int m_value;

	private TaskStatus(int value) {
		m_value = value;
	}

	private static Map map = new Hashtable<>();
	static {
		for (var taskStatus : TaskStatus.values()) {
			map.put(taskStatus.m_value, taskStatus);
		}
	}

	public static TaskStatus valueOf(int taskStatus) {
		return (TaskStatus) map.get(taskStatus);
	}

	public int getValue() {
		return m_value;
	}
}
