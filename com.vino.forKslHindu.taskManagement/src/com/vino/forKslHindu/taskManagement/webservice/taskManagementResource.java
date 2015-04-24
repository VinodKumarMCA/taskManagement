package com.vino.forKslHindu.taskManagement.webservice;
//importing core packages
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
//importing task models and collection controller

import com.vino.forKslHindu.taskManagement.model.taskManagementModel;
import com.vino.forKslHindu.taskManagement.controller.taskManagementController;

// Will map the resource to the URL tasks
@Path("/task")
public class taskManagementResource {

 // Allows to insert contextual objects into the class,
 // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;
  @Context
  Request request;

  // Return the list of task
  @GET
  @Produces(MediaType.TEXT_XML)
  public List<taskManagementModel> getTasks() {
    List<taskManagementModel> taskManagementInstance = new ArrayList<taskManagementModel>();
    taskManagementInstance.addAll(taskManagementController.instance.getModel().values());
    return taskManagementInstance;
  }
  
 //Crate new task
  @POST
  @Produces(MediaType.TEXT_HTML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public void newTask(@FormParam("id") String id,
      @FormParam("priority") String priority,
      @FormParam("task") String task,
      @FormParam("status") String status,
      @Context HttpServletResponse servletResponse) throws IOException {
	  taskManagementModel taskManagementInstance = new taskManagementModel(id, status);
    if (task != null) {
    	taskManagementInstance.setTask(task);
    	taskManagementInstance.setPriority(priority);
    	
    }
//refresh the task list after creation
    taskManagementController.instance.getModel().put(id, taskManagementInstance);

    servletResponse.sendRedirect("..");
  }

//Delete the task
  @DELETE
  @Produces(MediaType.TEXT_HTML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public void deleteTask(@FormParam("id") String id,
      @Context HttpServletResponse servletResponse) throws IOException {
	 
//Refresh the task list  after the deletion.  
     servletResponse.sendRedirect("..");
  }

//update the task
  @PUT
  @Produces(MediaType.TEXT_HTML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public void updateTask(@FormParam("id") String id,
      @FormParam("priority") String priority,
      @FormParam("task") String task,
      @FormParam("status") String status,
      @Context HttpServletResponse servletResponse) throws IOException {
	  taskManagementModel taskManagementInstance = new taskManagementModel(id, status);
    if (task != null) {
    	taskManagementInstance.setTask(task);
    	taskManagementInstance.setPriority(priority);
    	
    }
//refresh the task list after creation
    taskManagementController.instance.getModel().put(id, taskManagementInstance);

    servletResponse.sendRedirect("..");
  }

} 