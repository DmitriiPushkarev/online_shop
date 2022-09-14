<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<h1>Admin panel</h1>
	<h2>Products</h2>
	<br>
	<table>
		<tr>
			<th>Name</th>
			<th>Category</th>
			<th>Description</th>
			<th>Price</th>
			<th>Operations</th>
		</tr>
		<c:forEach var="product" items="${allProducts}">
		
		<c:url var = "updateButton" value = "/updateInfo">
		<c:param name = "productId" value = "${product.id}"/>	
		</c:url>
		
		<c:url var = "deleteButton" value = "/deleteProduct">
		<c:param name = "productId" value = "${product.id}"/>	
		</c:url>
		
			<tr>
				<td>${product.name}</td>
				<td>${product.category}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td>
				
				<input type = "button" value = "Update"
				onClick = "window.location.href = '${updateButton}'"/>
								
				<input type = "button" value = "Delete"
				onClick = "window.location.href = '${deleteButton}'"/>
								
				</td>
			</tr>

		</c:forEach>


	</table>
	
	<br>
	<input type = "button" value = "Add" onclick = "window.location.href = 'addNewProduct'"/>
	
	<h2>Orders</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Phone number</th>
			<th>Email</th>
			<th>Address</th>
			<th>Products</th>
		</tr>
		<c:forEach var="order" items="${allOrders}">
				
			<tr>
				<td>${order.name}</td>
				<td>${order.surname}</td>
				<td>${order.phoneNumber}</td>
				<td>${order.email}</td>
				<td>${order.address}</td>
				<td>${order.products}</td>
			</tr>
			

		</c:forEach>

	</table>
	
</body>
</html>