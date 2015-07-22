<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
    	
    	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    	<script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
    	<script src="<c:url value="/resources/js/bootstrap.min.js"  />" ></script>
</head>
<body>
<div class="container">
	
	<c:if test="${param.error != null}">
		<div class="error">${error}</div>
		<div class="alert alert-danger fade in">
	        <a href="#" class="close" data-dismiss="alert">&times;</a>
	        <strong><spring:message code="login.labels.errorAutenticacion"/></strong> <spring:message code="login.labels.error"/>
	    </div>
 	</c:if>
	
	<center><img alt="logoUD" src="<c:url value="/resources/images/logoUD.png"  />"></center>
	
	<form class="form-signin" action="<c:url value='j_spring_security_check' />" method="POST">
		<!-- h2 class="form-signin-heading"><spring:message code="login.labels.titulo"/></h2-->
        <label for="username" class="sr-only"><spring:message code="login.labels.usuario"/></label>
        <input id="j_username" name="j_username" type="text" class="form-control" placeholder="<spring:message code="login.labels.usuario"/>" required autofocus/>
        <label for="password" class="sr-only"><spring:message code="login.labels.contrasena"/></label>
        <input id="j_password" name="j_password" type="password" class="form-control" placeholder="<spring:message code="login.labels.contrasena"/>" required autofocus/>
        <input type="submit" value="<spring:message code="login.button.ingresar"/>" class="btn btn-lg btn-primary btn-block"/>  
         <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"><spring:message code="login.button.recuerdame"/>
          </label>
        </div>      
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>
</div>
</body>
</html>
