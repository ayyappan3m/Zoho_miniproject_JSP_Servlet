<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details Project For Zoho</title>
</head>
<body>
	<h1>Student Details Mini Project</h1>
	<input type="button" value="Export">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>DEPT</th>
		</tr>
		<tr>
			<td>
				<input type="text" name="id"><br>
				<input type="submit" value="Search">
			</td>
			<td>
				<input type="text" name="name"><br>
				<input type="submit" value="Search">
			</td>
			<td>
				<input type="text" name="dept"><br>
				<input type="submit" value="Search">
			</td>
		</tr>
		
	</table>
	<input type="submit" value="Prev">
	<input type="submit" value="Next">
</body>
</html>