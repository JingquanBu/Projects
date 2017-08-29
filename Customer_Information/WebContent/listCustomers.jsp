<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Customer Information Application</title>
	
	<link type="text/css" rel="stylesheet" href="css/listCustomer.css">
</head>

<body>

	<div id="appName">
		<div id="header">
			<h2>Wogers Communications</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="paragraph">
		
			<!-- create new button: Add Customer -->
			
			<input type="button" value="Add Customer" 
				   onclick="window.location.href='addCustomer.jsp'; return false;"
				   class="add-customer-button"
			/>
			
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Service</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempCustomer" items="${CUSTOMER_LIST}">
					
					<!-- set up a link for each customer -->
					<c:url var="tempLink" value="CustomerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!--  set up a link to remove a customer -->
					<c:url var="removeLink" value="CustomerServlet">
						<c:param name="command" value="REMOVE" />
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> ${tempCustomer.service} </td>
						<td> ${tempCustomer.price} </td>
						<td> 
							<a href="${tempLink}">Edit</a> 
							 | 
							<a href="${removeLink}"
							onclick="if (!(confirm('Are you sure you want to remove this customer?'))) return false">
							Remove</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








