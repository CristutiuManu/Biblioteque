<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Autori</title>
		<link href="<c:url value="/sb-admin/css/styles.css"/>" rel="stylesheet">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
	</head>
	<body>
	<%@ include file="/WEB-INF/common/headers.jsp"%>
	<div id="layoutSidenav">
    	<%@ include file="/WEB-INF/common/sidebar.jsp"%>
    	
    	<div id="layoutSidenav_content">
	        <main>
	            <div class="container-fluid">
	                <h1 class="mt-4">Add Autor</h1>
	              
	                

					<div class="row">
                        <div class="col-lg-5">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header"><h3 class="text-center font-weight-light my-4">Add Autor</h3></div>
                                <div class="card-body">
									<form:form action="${pageContext.request.contextPath}/autori/add-save.htm" method="post" commandName="autoriForm">
                                        <div class="form-group">
                                        	<label class="small mb-1" for="nume">Nume</label>
                                        	<form:input class="form-control py-4" path="nume" type="text" id="nume"/>
                                        </div>
                                        <div class="form-group">
                                        	<label class="small mb-1" for="nume">Prenume</label>
                                        	<form:input class="form-control py-4" path="prenume" type="nume" id="nume"/>
                                        </div>
                                        <div class="form-group">
                                        	<label class="small mb-1" for="telefon">Data Nasterii</label>
                                        	<form:input class="form-control py-4" path="data_nasterii" type="text" id="telefon"/>
                                        </div>
                                        <div class="form-group">
                                        	<label class="small mb-1" for="adresa">Data decesului</label>
                                        	<form:input class="form-control py-4" path="data_decesului" type="text" id="adresa"/>
                                        </div>
                                        <input class="btn btn-primary" type="submit" value="Salveaza"/></br/>
                                    </form:form>
                                </div>
                                <div class="card-footer text-center">
                                    <div class="small"><a href="<c:url value="/autori/lista.htm"/>">&lt; Back to list</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
	                <br><br>
	                
	            </div>
	        </main>
	        <%@ include file="/WEB-INF/common/footer.jsp"%>
	    </div>
	</div>
	<%@ include file="/WEB-INF/common/footer-imports.jsp"%>
	</body>
</html>