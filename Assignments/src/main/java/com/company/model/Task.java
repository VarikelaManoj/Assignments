package com.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id@GeneratedValue	
	private int task_Id;
	private String task_Name;
	private String task_Description;
	private boolean status;
	private String postedBy;
	private String task_Lastdate;
public int getTask_Id() {
		return task_Id;
	}
	public void setTask_Id(int task_Id) {
		this.task_Id = task_Id;
	}
	public String getTask_Name() {
		return task_Name;
	}
	public void setTask_Name(String task_Name) {
		this.task_Name = task_Name;
	}
	public String getTask_Description() {
		return task_Description;
	}
	public void setTask_Description(String task_Description) {
		this.task_Description = task_Description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getTask_Lastdate() {
		return task_Lastdate;
	}
	public void setTask_Lastdate(String task_Lastdate) {
		this.task_Lastdate = task_Lastdate;
	}
	
	

}
