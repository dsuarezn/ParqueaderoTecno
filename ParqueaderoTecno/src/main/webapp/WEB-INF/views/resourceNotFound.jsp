<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="resourceNotFound.view.tittle"/></title>
</head>
<body>
		<div class="container">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="error-template">
		                <h1><spring:message code="resourceNotFound.labels.oopsmsg"/></h1>
		                <h2><spring:message code="resourceNotFound.labels.mensaje"/></h2>
		                <div class="error-details">
		                    <spring:message code="resourceNotFound.labels.error.detalle"/>
		                </div>
		                <div class="error-actions">
		                    <a href="#" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span><spring:message code="resourceNotFound.boton.acasa"/></a>		                    
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
</body>
</html>