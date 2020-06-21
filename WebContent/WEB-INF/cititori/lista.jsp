<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cititori</title>

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
					<h1 class="mt-4">Lista Cititori</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">Dashboard</a></li>
						<li class="breadcrumb-item active">Cititori</li>
					</ol>
					<div class="card mb-4">
						<div class="card-body">


							<table class="table table-bordered">
								<tr>
									<td>Id</td>
									<td>Nume</td>
									<td>Prenume</td>
									<td>Adresa</td>
									<td>Localitate</td>
									<td>Judet</td>
									<td>Telefon</td>
									<td>Email</td>
								</tr>
								<c:forEach var="cititori" items="${model.cititori}">
									<tr>
										<td><c:out value="${cititori.id}" /></td>
										<td><c:out value="${cititori.nume}" /></td>
										<td><c:out value="${cititori.prenume}" /></td>
										<td><c:out value="${cititori.adresa}" /></td>
										<td><c:out value="${cititori.localitate}" /></td>
										<td><c:out value="${cititori.judet}" /></td>
										<td><c:out value="${cititori.telefon}" /></td>
										<td><c:out value="${cititori.email}" /></td>

										<td><a
											href="<c:url value="/cititori/detalii.htm?id=${cititori.id}"/>">Detalii</a>
										</td>
										<td><a
											href="<c:url value="/cititori/edit.htm?id=${cititori.id}"/>">Edit</a>
										<td><a
											href="<c:url value="/cititori/delete.htm?id=${cititori.id}"/>">Delete</a>
									</tr>
								</c:forEach>
							</table>
							<br /> <a href="<c:url value="/cititori/add.htm"/>">Adauga
								Cititor</a>
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