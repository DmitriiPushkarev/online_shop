<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>

<body>

	<h2>All Products</h2>
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

			<c:url var="addButton" value="/addProductToBasket">
				<c:param name="productId" value="${product.id}" />
			</c:url>

			<tr>
				<td>${product.name}</td>
				<td>${product.category}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td><input type="button" value="Add To Basket"
					onClick="window.location.href = '${addButton}'" /></td>
			</tr>

		</c:forEach>

	</table>

	<br>

	<input type="button" value="Basket"
		onclick="window.location.href = 'basket'">

	<security:authorize access="hasRole('ANONYMOUS')">
		<input type="button" value="Registration"
			onclick="window.location.href = 'registration'">
	</security:authorize>

	<security:authorize access="hasRole('ANONYMOUS')">
		<input type="button" value="Login"
			onclick="window.location.href = 'login'">
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<input type="button" value="Admin panel"
			onclick="window.location.href = 'showAdminPanel'">
	</security:authorize>
	
	<security:authorize access="hasAnyRole('ADMIN', 'USER')">
		<input type="button" value="Logout"
			onclick="window.location.href = 'logout'">
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<input type="button" value="Add"
			onclick="window.location.href = 'addNewProduct'">
	</security:authorize>

</body>
</html>