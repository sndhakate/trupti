<font color="red">
<%
/* int a=90;
int b=9000;
out.println(a+b); */
if(request.getAttribute("msg")!=null)
	out.println(request.getAttribute("msg"));
%>
</font>
<form action="LoginServlet">
	User Name : <input type="text" name="username" /> 
	Password: <input type="text" name="password" /> 
	<input type="submit" value="click me..">
</form>