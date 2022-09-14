<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<h2>Basket</h2>
	<br>
	<table>
		<tr>
			<th>Name</th>
			<th>Category</th>
			<th>Price</th>
			<th>Operations</th>
		</tr>
		<c:forEach var="product" items="${basket}">

			<c:url var="deleteProductButton" value="/deleteProductFromBasket">
				<c:param name="productId" value="${basket.indexOf(product)}" />
			</c:url>

			<tr>
				<td>${product.name}</td>
				<td>${product.category}</td>
				<td>${product.price}</td>
				<td><input type="button" value="Delete"
					onClick="window.location.href = '${deleteProductButton}'" /></td>
			</tr>

		</c:forEach>
	</table>

	<input type="button" value="Order"
		onclick="window.location.href = 'addNewOrder'">

</body>
</html>