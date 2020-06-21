<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Carti</title>
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
	                <h1 class="mt-4">Adauga Carte</h1>
	                

					<div class="row">
                        <div class="col-lg-5">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header"><h3 class="text-center font-weight-light my-4">Add user</h3></div>
                                <div class="card-body">
									<form:form action="${pageContext.request.contextPath}/carti/add-save.htm" method="post" commandName="cartiForm">
                                        <div class="form-group">
                                        	<label class="small mb-1" for="nume">Titlu</label>
                                        	<form:input class="form-control py-4" path="titlu" type="text" id="nume"/>
                                        </div>
                                        <div class="form-group">
                                        	<label class="small mb-1" for="nume">Data publicarii</label>
                                        	<form:input class="form-control py-4" path="data_publicarii" type="nume" id="telefon"/>
                                        </div>
                                        <div class="form-group">
                                        	<label class="small mb-1" for="telefon">Numar pagini</label>
                                        	<form:input class="form-control py-4" path="numar_pagini" type="text" id="telefon"/>
                                        </div>
                                        <input class="btn btn-primary" type="submit" value="Salveaza"/></br/>
                                    </form:form>
                                </div>
                                <div class="card-footer text-center">
                                    <div class="small"><a href="<c:url value="/carti/lista.htm"/>">&lt; Back to list</a></div>
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