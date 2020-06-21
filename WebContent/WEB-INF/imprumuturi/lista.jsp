<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Imprumuturi</title>

<link href="<c:url value="/sb-admin/css/styles.css"/>" rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>

</head>
<body>

	<%@ include file="/WEB-INF/common/headers.jsp"%>
	<div id="layoutSidenav">
		<%@ include file="/WEB-INF/common/sidebar.jsp"%>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h1 class="mt-4">Lista Imprumuturi</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">Dashboard</li>
						<li class="breadcrumb-item active">Imprumuturi</li>
					</ol>
					<div class="card mb-4">
						<div class="card-body">


							<table class="table table-bordered">
								<tr>
									<td>Id</td>
									<td>Id Cititor</td>
									<td>Id Carte</td>
									<td>Date imprumut</td>
									<td>Data returnare</td>
									<td></td>
								</tr>
								<c:forEach var="imprumuturi" items="${model.imprumuturi}">
									<tr>
										<td><c:out value="${imprumuturi.id}" /></td>
										<td><c:out value="${imprumuturi.id_cititor}" /></td>
										<td><c:out value="${imprumuturi.id_carte}" /></td>
										<td><c:out value="${imprumuturi.data_imprumut}" /></td>
										<td><c:out value="${imprumuturi.data_returnare}" /></td>
										<td><a
											href="<c:url value="/imprumuturi/detalii.htm?id=${imprumuturi.id}"/>">Detalii</a>
										</td>
										<td><a
											href="<c:url value="/imprumuturi/edit.htm?id=${imprumuturi.id}"/>">Edit</a>
										<td><a
											href="<c:url value="/imprumuturi/delete.htm?id=${imprumuturi.id}"/>">Delete</a>
									</tr>
								</c:forEach>
							</table>
							<br /> <a href="<c:url value="/imprumuturi/add.htm"/>">Adauga User</a>
						</div>
					</div>
				</div>
			</main>

			<%@ include file="/WEB-INF/common/footer.jsp"%>

		</div>
	</div>
	<%@ include file="/WEB-INF/common/footer-imports.jsp"%>
</body>
</html>