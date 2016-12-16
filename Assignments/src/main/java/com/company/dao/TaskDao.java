package com.company.dao;

import java.util.List;

import com.company.model.Task;

public interface TaskDao {
	List<Task> viewFinishedTasks(String postedBy);
	void addTask(Task task);
	void updateTask(Task task);
	void deleteTask(int id);
	List<Task> viewClientTasks(String postedBy);
	
}
