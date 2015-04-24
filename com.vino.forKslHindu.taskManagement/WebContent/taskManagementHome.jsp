<%@ page import="javax.xml.parsers.*,org.w3c.dom.*" %>
	
<%@page import="java.util.*" %>
 <%
 try{
 String XmlPath = "http://localhost:8080/com.vino.forKslHindu.taskManagement/rest/task";
 String idElement = "id";
 String taskElement = "task";
 String priorityElement = "priority";
 String statusValue = "status";
 %>
 <%!
 Document doc;
 String getXMLValue(String name, int index) {
 NodeList nodes= doc.getElementsByTagName(name);
 String value = nodes.item(index).getFirstChild().getNodeValue();
 return value;
 }
 %>
 <%
 DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
 DocumentBuilder db=dbf.newDocumentBuilder();
 doc=db.parse(XmlPath);
 NodeList tasks = doc.getElementsByTagName("taskManagementModel");
 
 %>
 <html>
<head>
<title>Task Management</title>
<link rel="stylesheet" type="text/css" href="theme/css/taskManagement.css">
<script src="theme/js/taskManagement.js"></script>
<h3>Task Management</h3>
</head>
<body>
  <form enctype="application/x-www-form-urlencoded" action="./rest/task" method="POST"  id="taskManagementform">
 <fieldset>
  
  <label>Task: </label> 
   <input class="taskName" name="task"  type="text">&#160;
   <label>Priorty: </label>
   <select class="taskPriority" name="priority">
  <option value="medium">Medium</option>
  <option value="low">Low</option>
  <option value="high">High</option>
 
</select>
<%!
Random randomValue=new Random();
%>
 <input  type="hidden" name="id"  value="<%=Math.abs(randomValue.nextInt()) %>">
  <input type="hidden" name="status"  value="new">
&#160;&#160; <button id="submitForm" type="submit"  class="submitForm">Add Task</button>
  
 </fieldset>
 </form>
 <div class="TaskViewOption">
          &#160;
            &#160;<input TYPE="radio" onclick="javascript:taskViewOptionChange()" NAME="taskList" VALUE="all" CHECKED>
             All Task
            &#160;
            &#160;
            <INPUT TYPE="radio" onclick="javascript:taskViewOptionChange()"  NAME="taskList" VALUE="new">
             New Tasks
            &#160;
            &#160;
            <INPUT TYPE="radio" onclick="javascript:taskViewOptionChange()"  NAME="taskList" VALUE="pending">
             Pending Tasks
            &#160;
            &#160;
             <INPUT TYPE="radio" onclick="javascript:taskViewOptionChange()"  NAME="taskList" VALUE="complete">
             Complete Tasks
   </div>          
 <br/>
 <table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->
   
	<!-- Table Header -->
	<thead>
		<tr>
			<th>ID</th>
			<th>Task</th>
			<th>Priority</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
 <%for (int i = 0; i < tasks.getLength(); i++) { %>
      
       
       <tr>
			<td><%=getXMLValue(idElement, i)%></td>
			<td><%=getXMLValue(taskElement, i)%></td>
			<td><%=getXMLValue(priorityElement, i)%></td>
			<td><select  name="status">
			     <option value="new">New</option>
				  <option value="pending">Pending</option>
				  	  
				  <option value="complete">Complete</option>
				 
				</select></td>
			
			<td><button value="">Delete</button></td>
		</tr><!-- Table Row -->
       
       
	<%} %>
	</tbody>
	<!-- Table Body -->

</table>

</body>
</html>
<%
 }catch(Exception e){
 }%>