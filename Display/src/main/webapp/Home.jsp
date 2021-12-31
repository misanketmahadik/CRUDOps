<%@page import="model.FormBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dao.FormDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
</head>

<body
	background="https://www.enjpg.com/img/2020/light-blue-background-4.jpg">
	<div>
		<h1 align="Center">Home</h1>
	</div>
	<div>
		<a href="ContactForm.jsp">Add User...</a>
	</div>
	<div>
		<table border="6">
			<thead>
				<tr>
					<th>Username</th>
					<th>Email</th>
					<th>Message</th>
					<th>Action</th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>

				<% 
                    FormDao d= new FormDao();
                    List<FormBean> ls= d.getUser();
                    if(ls.isEmpty())
                    {%>
				<tr>
					<td colspan="5">NO DATA</td>
				</tr>
				<%}
                    else
                    {%>
				<% 
                    	Iterator<FormBean> itr=ls.iterator();
                    	while(itr.hasNext())
                    	{
                    		FormBean b=itr.next();
                    	%>
				<tr>
					<td><%= b.getUname()%></td>
					<td><%= b.getEmail()%></td>
					<td><%= b.getMsg()%></td>
					<td><a href="DeleteServlet?id=<%=b.getId()%>">Delete</a></td>
					<td><a href="updateServlet?id=<%=b.getId()%>">Update</a>
				</tr>

				<%}
                    	
                    	 %>
				<% }
                    
                    
                    
                    %>
				<%String success=(String)request.getAttribute("success");
					String failed=(String)request.getAttribute("failed");
					if(success!=null)
					{	%>
						<%=success %>
					<% }%>
					<%if(failed!=null)
					{	%>
							<%=failed %>
					<% }%>

			</tbody>
		</table>
	</div>
</body>
</html>
