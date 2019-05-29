User name is correct.............

<table border="1">
	<%
		String[] employees = (String[]) request.getAttribute("data");

		for (int i = 0; i < employees.length; i++) {
	%>
	<tr>
		<td><input type="checkbox" /></td>
		<td>
			<%
				out.println(employees[i]);
			%>

		</td>
		<td><input type="button" value="edit" /></td>
		<td><input type="button" value="update" /></td>
		<td><input type="button" value="delete" /></td>
	</tr>
	<%
		}
	%>
</table>





