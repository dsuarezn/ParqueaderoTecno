<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="mensajes">
	<c:if test="${not empty error}">
		<div class="alert alert-danger fade in errorAlert">
		    <a href="#" class="close" data-dismiss="alert">&times;</a>
		    <strong><spring:message code="global.mensajes.error"/></strong> <c:out value="${error}"/>
		</div>
	</c:if>
	<c:if test="${not empty exito}">
		<div class="alert alert-success fade in exitoAlert">
		    <a href="#" class="close" data-dismiss="alert">&times;</a>
		    <strong><spring:message code="global.mensajes.exito"/></strong> <c:out value="${exito}"/>
		</div>	
	</c:if>
    <c:if test="${not empty info}">
    	<div class="alert alert-info fade in infoAlert">
		    <a href="#" class="close" data-dismiss="alert">&times;</a>
		    <strong><spring:message code="global.mensajes.info"/></strong> <c:out value="${info}"/>
		</div>
    </c:if>    
		
</div>