<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<body>

	<h2>Registration</h2>
	<br>

	<form:form action="saveUser" modelAttribute="user">
	
Login <form:input path="username" autocomplete="off"/>
		<br>
		<br>
<form:errors path="username"></form:errors>
        ${usernameError}
        <br>
		<br>
Password <form:input path="password" autocomplete="off"/>
		<br>
		<br>
		<input type="submit" value="OK">

	</form:form>

</body>

</html>