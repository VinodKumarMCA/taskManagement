package com.vino.forKslHindu.taskManagement.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class taskManagementModel {
	private String id;
	private String task;
	private String priority;
	private String status;
   // Default Constructor with no parameter , it is used for when delete and get task.
	public taskManagementModel()
	{
		
	}
	// Constructor with parameter, it is used for when create and update task.
	public taskManagementModel(String id,String status){
		this.id =id;
		this.status = status;
	}
	public String getId()
	{
		return id;
	}
	public String getTask()
	{
		return task;
	}
	public String getPriority()
	{
		return priority;
	}
	public String getStatus()
	{
		return status;
	}

	public void setId(String id)
	{
		this.id = id;
		
	}	
	public void setTask(String task)
	{
		this.task = task;
		
	}	
	public void setPriority(String priority)
	{
		this.priority = priority;
		
	}	
	public void setStatus(String status)
	{
		this.status = status;
		
	}	
}
