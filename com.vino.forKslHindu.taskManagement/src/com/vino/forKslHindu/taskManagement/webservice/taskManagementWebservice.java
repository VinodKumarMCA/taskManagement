package com.vino.forKslHindu.taskManagement.webservice;
//import core packages
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

//importing task models and collection controller
import com.vino.forKslHindu.taskManagement.model.taskManagementModel;
import com.vino.forKslHindu.taskManagement.controller.taskManagementController;

public class taskManagementWebservice {
  @Context
  UriInfo uriInfo;
  @Context
  Request request;
  String id;
  public taskManagementWebservice(UriInfo uriInfo, Request request, String id) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.id = id;
  }
  
 // RESTful web service for get task list.
  @GET
  @Produces(MediaType.TEXT_XML)
  public taskManagementModel getTasks() {
	  taskManagementModel taskManagementInstance = taskManagementController.instance.getModel().get(id);
    if(taskManagementInstance==null)
      throw new RuntimeException("Get: Task with " + id +  " not found");
    return taskManagementInstance;
  }
  // RESTful web service for update task.
  @PUT
  @Consumes(MediaType.APPLICATION_XML)
  public Response updateTask(JAXBElement<taskManagementModel> taskManagementInstance) {
	  taskManagementModel c = taskManagementInstance.getValue();
    return putAndGetResponse(c);
  }
// RESTful web service for delete task.
  
  @DELETE
  public void deleteTask() {
	  taskManagementModel c = taskManagementController.instance.getModel().remove(id);
    if(c==null)
      throw new RuntimeException("Delete: Task with " + id +  " not found");
  }
//Response handler  
  
  private Response putAndGetResponse(taskManagementModel taskManagementInstance) {
    Response res;
    if(taskManagementController.instance.getModel().containsKey(taskManagementInstance.getId())) {
      res = Response.noContent().build();
    } else {
      res = Response.created(uriInfo.getAbsolutePath()).build();
    }
    taskManagementController.instance.getModel().put(taskManagementInstance.getId(), taskManagementInstance);
    return res;
  }
}
