<!DOCTYPE html>
<html>

<head>
	<title>Edit Customer</title>

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
		<h3>Edit Customer</h3>
		
		<form action="CustomerServlet" method="GET">
		
			<input type="hidden" name="command" value="EDIT" />

			<input type="hidden" name="customerId" value="${THE_CUSTOMER.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" 
								   value="${THE_CUSTOMER.firstName}" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" 
								   value="${THE_CUSTOMER.lastName}" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" 
								   value="${THE_CUSTOMER.email}" /></td>
					</tr>
					
					<tr>
						<td><label>Service:</label></td>
						<td><input type="text" name="service" 
								   value="${THE_CUSTOMER.service}" /></td>
					</tr>
					
					<tr>
						<td><label>Price:</label></td>
						<td><input type="text" name="price" 
								   value="${THE_CUSTOMER.price}" /></td>
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











