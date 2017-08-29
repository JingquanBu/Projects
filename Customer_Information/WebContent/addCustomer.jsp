<!DOCTYPE html>
<html>

<head>
	<title>Add Customer</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/addCustomer.css">	
</head>

<body>
	<div id="appName">
		<div id="header">
			<h2>Wogers Communications</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Customer</h3>
		
		<form action="CustomerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>
					
					<tr>
						<td><label>Service:</label></td>
						<td><input type="text" name="service" /></td>
					</tr>
					
					<tr>
						<td><label>Price:</label></td>
						<td><input type="text" name="price" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="CustomerServlet">Go Back to List</a>
		</p>
	</div>
</body>

</html>











