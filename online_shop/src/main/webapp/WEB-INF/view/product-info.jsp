<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

	<h2>Product Info</h2>
	<br>

	<form:form action="saveProduct" modelAttribute="product">
	
	<form:hidden path = "id"/>

Name <form:input path="name" />
		<br>
		<br>
Category <form:input path="category" />
		<br>
		<br>				
Description <form:input path="description" />
		<br>
		<br>
Price <form:input path="price" />
		<br>
		<br>
		<input type="submit" value="OK">

	</form:form>
		
</body>

</html>