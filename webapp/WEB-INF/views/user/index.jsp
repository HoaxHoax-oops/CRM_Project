<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User list</title>
</head>
<body>
	<span class="d-inline-block" tabindex="0" data-bs-toggle="tooltip"
		title="Disabled tooltip"> <a class="btn btn-primary"
		href="${pageContext.request.contextPath}/user/add" role="button">
			<i class="material-icons mr-1">add</i>ADD
	</a>
	</span>
	<div class="card card-form">
		<div class="col-lg-12 card-form__body border-left">
			<div class="table-responsive border-bottom" data-toggle="lists"
				data-lists-values='["js-lists-values-employee-name"]'>
				<table class="table mb-0 thead-border-top-0">
					<thead>
						<tr>
							<th style="width: 24px;">ID</th>
							<th>Full name</th>
							<th style="width: 37px;">Role</th>
							<th style="width: 120px;">Email</th>
							<th style="width: 51px;">Phone</th>
							<th style="width: 51px;"></th>
						</tr>
					</thead>
					<tbody class="list" id="staff">
						<c:forEach items="${ users }" var="item">
							<tr>
								<td><small class="text-muted">${ item.id }</small></td>
								<td>
									<div class="media align-items-center">
										<div class="media-body">
											<span class="js-lists-values-employee-name">${ item.fullname }</span>
										</div>
									</div>
								</td>
								<td><span class="badge badge-success">${ item.roleName }</span>
								</td>
								<td>${ item.email }</td>
								<td>${ item.phone }</td>
								<td class="text-right">
									<div class="btn-group btn-group-sm">
										<a role="button" class="btn btn-danger btn-sm" 
											href="${pageContext.request.contextPath}/user/delete?id=${ item.id }">
											<i class="material-icons">delete</i>
										</a>
										<a role="button" class="btn btn-success btn-sm"
											href="${pageContext.request.contextPath}/user/edit?id=${ item.id }">
											<i class="material-icons">create</i>
										</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>