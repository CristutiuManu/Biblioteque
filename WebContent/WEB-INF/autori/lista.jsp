<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Autori</title>

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
					<h1 class="mt-4">Lista Autori</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">Dashboard</a></li>
						<li class="breadcrumb-item active">Autori</li>
					</ol>
					<div class="card mb-4">
						<div class="card-body">


							<table class="table table-bordered">
								<tr>
									<td>Id</td>
									<td>Nume</td>
									<td>Prenume</td>
									<td>Data Nasterii</td>
									<td>Data Decesului</td>
									<td></td>
								</tr>
								<c:forEach var="autori" items="${model.autori}">
									<tr>
										<td><c:out value="${autori.id}" /></td>
										<td><c:out value="${autori.nume}" /></td>
										<td><c:out value="${autori.prenume}" /></td>
										<td><c:out value="${autori.data_nasterii}" /></td>
										<td><c:out value="${autori.data_decesului}" /></td>
										<td><a
											href="<c:url value="/autori/detalii.htm?id=${autori.id}"/>">Detalii</a>
										</td>
										<td><a
											href="<c:url value="/autori/edit.htm?id=${autori.id}"/>">Edit</a>
										<td><a
											href="<c:url value="/autori/delete.htm?id=${autori.id}"/>">Delete</a>
									</tr>
								</c:forEach>
							</table>
							<br /> <a href="<c:url value="/autori/add.htm"/>">Adauga User</a>
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