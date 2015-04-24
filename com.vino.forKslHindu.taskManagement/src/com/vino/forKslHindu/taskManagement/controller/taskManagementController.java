package com.vino.forKslHindu.taskManagement.controller;
import java.util.HashMap;
import java.util.Map;
import com.vino.forKslHindu.taskManagement.model.taskManagementModel;;
public enum taskManagementController {
	instance;
	private Map<String, taskManagementModel> taskManagementModel = new HashMap<String, taskManagementModel>();
	  private taskManagementController() 
	  {
		    
		
	}
		  public Map<String, taskManagementModel> getModel(){
		    return taskManagementModel;
		  }
}