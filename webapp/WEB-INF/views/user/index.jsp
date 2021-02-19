<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User list</title>
</head>
<body>
	<div class="card card-form">
		<div class="row no-gutters">
			<div class="col-lg-12 card-form__body border-left">


				<div class="table-responsive border-bottom" data-toggle="lists"
					data-lists-values='["js-lists-values-employee-name"]'>

					<table class="table mb-0 thead-border-top-0">
						<thead>
							<tr>
								<th style="width: 24px;">ID</th>
								<th>Name</th>
								<th style="width: 37px;">Role</th>
								<th style="width: 120px;">Email</th>
								<th style="width: 51px;">Phone</th>
								<th style="width: 51px;"></th>
							</tr>
						</thead>
						<tbody class="list" id="staff">
							<tr class="selected">
								<td><small class="text-muted">1</small></td>
								<td>
									<div class="media align-items-center">
										<div class="avatar avatar-xs mr-2">
											<img src="assets/images/256_luke-porter-261779-unsplash.jpg"
												alt="Avatar" class="avatar-img rounded-circle">
										</div>
										<div class="media-body">
											<span class="js-lists-values-employee-name">Michael
												Smith</span>
										</div>
									</div>
								</td>
								<td><span class="badge badge-warning">ADMIN</span></td>
								<td>lamtrinhthong@gmail.com</td>
								<td>(+84)775311127</td>
								<td>
									<div class = "btn-group btn-group-sm">
										<button type="button" class="btn btn-danger btn-sm">
											<i class="material-icons">close</i>
										</button>
										<button type="button" class="btn btn-success btn-sm">
	                                        <i class="material-icons">thumb_up</i>
	                                    </button>
									</div>
									
								</td>
							</tr>
							<tr>

								<td>
									<div class="custom-control custom-checkbox">
										<input type="checkbox"
											class="custom-control-input js-check-selected-row"
											id="customCheck2_1"> <label
											class="custom-control-label" for="customCheck2_1"><span
											class="text-hide">Check</span></label>
									</div>
								</td>

								<td>

									<div class="media align-items-center">
										<img src="assets/images/avatar/green.svg" class="mr-2"
											alt="avatar" />
										<div class="media-body">

											<span class="js-lists-values-employee-name">Connie
												Smith</span>

										</div>
									</div>

								</td>


								<td><span class="badge badge-success">USER</span></td>
								<td><small class="text-muted">1 week ago</small></td>
								<td>&dollar;1,943</td>
								<td><a href="" class="text-muted"><i
										class="material-icons">more_vert</i></a></td>
							</tr>
							<tr>

								<td>
									<div class="custom-control custom-checkbox">
										<input type="checkbox"
											class="custom-control-input js-check-selected-row"
											id="customCheck3_1"> <label
											class="custom-control-label" for="customCheck3_1"><span
											class="text-hide">Check</span></label>
									</div>
								</td>

								<td>

									<div class="media align-items-center">

										<div class="avatar avatar-xs mr-2">
											<img
												src="assets/images/256_daniel-gaffey-1060698-unsplash.jpg"
												alt="Avatar" class="avatar-img rounded-circle">
										</div>
										<div class="media-body">

											<span class="js-lists-values-employee-name">John
												Connor</span>

										</div>
									</div>

								</td>


								<td><span class="badge badge-primary">MANAGER</span></td>
								<td><small class="text-muted">1 week ago</small></td>
								<td>&dollar;1,943</td>
								<td><a href="" class="text-muted"><i
										class="material-icons">more_vert</i></a></td>
							</tr>

							<tr class="selected">

								<td>
									<div class="custom-control custom-checkbox">
										<input type="checkbox"
											class="custom-control-input js-check-selected-row" checked=""
											id="customCheck1_2"> <label
											class="custom-control-label" for="customCheck1_2"><span
											class="text-hide">Check</span></label>
									</div>
								</td>

								<td>

									<div class="media align-items-center">
										<div class="avatar avatar-xs mr-2">
											<img src="assets/images/256_luke-porter-261779-unsplash.jpg"
												alt="Avatar" class="avatar-img rounded-circle">
										</div>
										<div class="media-body">

											<span class="js-lists-values-employee-name">Michael
												Smith</span>

										</div>
									</div>

								</td>


								<td><span class="badge badge-warning">ADMIN</span></td>
								<td><small class="text-muted">3 days ago</small></td>
								<td>&dollar;12,402</td>
								<td><a href="" class="text-muted"><i
										class="material-icons">more_vert</i></a></td>
							</tr>
							<tr>

								<td>
									<div class="custom-control custom-checkbox">
										<input type="checkbox"
											class="custom-control-input js-check-selected-row"
											id="customCheck2_2"> <label
											class="custom-control-label" for="customCheck2_2"><span
											class="text-hide">Check</span></label>
									</div>
								</td>

								<td>

									<div class="media align-items-center">
										<img src="assets/images/avatar/green.svg" class="mr-2"
											alt="avatar" />
										<div class="media-body">

											<span class="js-lists-values-employee-name">Connie
												Smith</span>

										</div>
									</div>

								</td>


								<td><span class="badge badge-success">USER</span></td>
								<td><small class="text-muted">1 week ago</small></td>
								<td>&dollar;1,943</td>
								<td><a href="" class="text-muted"><i
										class="material-icons">more_vert</i></a></td>
							</tr>
							<tr>

								<td>
									<div class="custom-control custom-checkbox">
										<input type="checkbox"
											class="custom-control-input js-check-selected-row"
											id="customCheck3_2"> <label
											class="custom-control-label" for="customCheck3_2"><span
											class="text-hide">Check</span></label>
									</div>
								</td>

								<td>

									<div class="media align-items-center">

										<div class="avatar avatar-xs mr-2">
											<img
												src="assets/images/256_daniel-gaffey-1060698-unsplash.jpg"
												alt="Avatar" class="avatar-img rounded-circle">
										</div>
										<div class="media-body">

											<span class="js-lists-values-employee-name">John
												Connor</span>

										</div>
									</div>

								</td>


								<td><span class="badge badge-primary">MANAGER</span></td>
								<td><small class="text-muted">1 week ago</small></td>
								<td>&dollar;1,943</td>
								<td><a href="" class="text-muted"><i
										class="material-icons">more_vert</i></a></td>
							</tr>

						</tbody>
					</table>
				</div>


			</div>
		</div>
	</div>
</body>
</html>