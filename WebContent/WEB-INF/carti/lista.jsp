<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Carti</title>

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
					<h1 class="mt-4">Lista Carti</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item">Dashboard</a></li>
						<li class="breadcrumb-item active">Carti</li>
					</ol>
					<div class="card mb-4">
						<div class="card-body">


							<table class="table table-bordered">
								<tr>
									<td>Id</td>
									<td>Titlu</td>
									<td>Data publicarii</td>
									<td>Numar pagini</td>
									<td></td>
								</tr>
								<c:forEach var="carti" items="${model.carti}">
									<tr>
										<td><c:out value="${carti.id}" /></td>
										<td><c:out value="${carti.titlu}" /></td>
										<td><c:out value="${carti.data_publicarii}" /></td>
										<td><c:out value="${carti.numar_pagini}" /></td>
										<td><a href="<c:url value="/carti/detalii.htm?id=${carti.id}"/>">Detalii</a>
										</td>
										<td><a href="<c:url value="/carti/edit.htm?id=${carti.id}"/>">Edit</a>
										<td
										><a href="<c:url value="/carti/delete.htm?id=${carti.id}"/>">Delete</a>
									</tr>
								</c:forEach>
							</table>
							<br /> <a href="<c:url value="/carti/add.htm"/>">Adauga User</a>
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