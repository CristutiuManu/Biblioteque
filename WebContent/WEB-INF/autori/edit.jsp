<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autor</title>
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
				<h1 class="mt-4">Edit Autor</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item">Dashboard</a></li>
					<li class="breadcrumb-item active">Autori</li>
				</ol>
				<div class="card mb-4">
					<div class="card-body">

						<h2>
							<c:out value="${model.mesaj}" />
						</h2>
						<form:form
							action="${pageContext.request.contextPath}/autori/save.htm"
							method="post" commandName="autoriForm">
							<div class="form-group">
								<label class="small mb-1" for="nume">ID</label>
								<form:input class="form-control py-4" path="id" readonly="true"
									type="text" id="nume" />
							</div>

							<div class="form-group">
								<label class="small mb-1" for="nume">Nume</label>
								<form:input class="form-control py-4" path="nume" type="text"
									id="nume" />
							</div>
							<div class="form-group">
								<label class="small mb-1" for="email">prenume</label>
								<form:input class="form-control py-4" path="prenume" type="text"
									id="nume" />
							</div>
							<div class="form-group">
								<label class="small mb-1" for="telefon">Data Nasterii</label>
								<form:input class="form-control py-4" path="data_nasterii"
									type="text" id="telefon" />
							</div>
							<div class="form-group">
								<label class="small mb-1" for="adresa">Data decesului</label>
								<form:input class="form-control py-4" path="data_decesului"
									type="text" id="telefon" />
							</div>
							<input class="btn btn-primary" type="submit" value="Salveaza" />
							</br/>
						</form:form>
					</div>
					<div class="card-footer text-center">
						<div class="small">
							<a href="<c:url value="/autori/lista.htm"/>">&lt; Back to
								list</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	<%@ include file="/WEB-INF/common/footer.jsp"%>
	</div>
	<%@ include file="/WEB-INF/common/footer-imports.jsp"%>
</body>
</html>