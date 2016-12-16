package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.dao.TaskDao;
import com.company.model.Task;

@RestController
public class TaskController {
	@Autowired
	TaskDao taskDao;
	@RequestMapping(value="/addTask",headers="accept=Application/json",method=RequestMethod.POST)
	public void addTask(@RequestBody Task task)
	{
		taskDao.addTask(task);
	}
	@RequestMapping(value="/updateTask",headers="accept=Application/json",method=RequestMethod.PUT)
	public void updateTask(@RequestBody Task task)
	{
		taskDao.updateTask(task);
	}
	@RequestMapping(value="/deleteTask/{id}",headers="accept=Application/json",method=RequestMethod.DELETE)
	public void deleteTask(@PathVariable int id)
	{
		taskDao.deleteTask(id);
	}
	@RequestMapping(value="/viewClientTasks/{postedBy}",headers="accept=Application/json",method=RequestMethod.GET)
	public List<Task> viewClientTasks(@PathVariable("postedBy") String postedBy)
	{
		return taskDao.viewClientTasks(postedBy);
	}
	@RequestMapping(value="/viewFinishedTasks/{postedBy}",headers="Accept=Application/json",method=RequestMethod.GET)
	public List<Task>  viewFinishedTasks(@PathVariable("postedBy") String postedBy)
	{
		return taskDao.viewFinishedTasks(postedBy);
		
		
}
}