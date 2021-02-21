<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit role</title>
</head>
<body>
	<div class="container page__container">
		<!-- Page Content -->
		<div class="card card-form">
			<div class="col-lg-12 card-form__body card-body">
				<form method="post" action="${pageContext.request.contextPath}/role/edit">
					<div class="form-group">
						<label for="role_id">Role ID:</label> 
						<input type="text" class="form-control" id="role_id"
								value="${ role.id }" readonly
								name="id">
					</div>
					<div class="form-group">
						<label for="role_name">Role name:</label> 
						<input type="text" class="form-control" id="role_name"
								value="${ role.name }" 
								name="name">
					</div>
					<div class="form-group">
						<label for="role_description">Description:</label> 
						<input type="text" class="form-control" id="role_description"
								value="${ role.description })" 
								name="description">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>