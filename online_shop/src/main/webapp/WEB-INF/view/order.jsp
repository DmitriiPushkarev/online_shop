<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<h2>Order</h2>
	<br>
	<form:form action="saveOrder" modelAttribute="order">

		<form:hidden path="id" />
						
Name <form:input path="name" autocomplete="off"/>
		<br>
		<br>
Surname <form:input path="surname" autocomplete="off"/>
		<br>
		<br>
Phone number <form:input path="phoneNumber" autocomplete="off"/>
		<br>
		<br>
Email <form:input path="email" autocomplete="off"/>
		<br>
		<br>
Address <form:input path="address" autocomplete="off"/>
		<br>
		<br>

		<input type="submit" value="OK">
	</form:form>

	<br>
	<br>
	 
	Products
	<table>
		<tr>
			<th>Name</th>
			<th>Category</th>
			<th>Price</th>
		</tr>
		<c:forEach var="product" items="${order.products}">

			<tr>
				<td>${product.name}</td>
				<td>${product.category}</td>
				<td>${product.price}</td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>