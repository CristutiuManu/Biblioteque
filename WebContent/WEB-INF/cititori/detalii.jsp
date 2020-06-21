<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cititori</title>

<link href="<c:url value="/sb-admin/css/styles.css"/>"  rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>

</head>
<body>

<%@ include file="/WEB-INF/common/headers.jsp"%>
<div id ="layoutSidenav">
<%@ include file="/WEB-INF/common/sidebar.jsp" %>
 <div id="layoutSidenav_content">
	<main>
	
		<div class="container-fluid">  
			<h1 class="mt-4">Detalii Cititor</h1>
				<ol class="breadcrumb mb-4">
					  <li class="breadcrumb-item">Dashboard</a></li>
                      <li class="breadcrumb-item active">Cititori</li>
                </ol>
		<div class="card mb-4">
		<div class="card-body">

Id:<c:out value = "${model.cititori.id}"/><br/>
Nume:<c:out value = "${model.cititori.nume}"/><br/>
Prenume:<c:out value = "${model.cititori.prenume}"/><br/>
Adresa:<c:out value = "${model.cititori.adresa}"/><br/>
Localitate:<c:out value = "${model.cititori.localitate}"/><br/>
Judet:<c:out value = "${model.cititori.judet}"/><br/>
Telefon:<c:out value = "${model.cititori.telefon}"/><br/>
Email:<c:out value = "${model.cititori.email}"/><br/>

<a href="<c:url value="/cititori/lista.htm"/>">&lt; Back to list</a>
</div>
</div>                        
 </div>
</div>                 
 </main>
<%@ include file="/WEB-INF/common/footer.jsp" %>
 
     </div>
	<%@ include file="/WEB-INF/common/footer-imports.jsp" %>

</body>
</html>