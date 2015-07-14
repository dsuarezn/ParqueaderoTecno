<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/parqueaderos/modificarAction" var="modificarUrl" htmlEscape="true"/>

<c:if test="${not empty parqueadero}">	
	<c:choose>
	    <c:when test="${parqueadero.esCrear == true}">
	     	<c:set var="buttonName">
	     		<spring:message code="modificarParqueadero.buttons.submit.crear"/>
	     	</c:set>
	     	<c:set var="viewTittle">
	     		<spring:message code="modificarParqueadero.labels.titulo.crear"/>
	     	</c:set>
	    </c:when>
	    <c:when test="${parqueadero.esCrear == false}">
	        <c:set var="buttonName">
	     		<spring:message code="modificarParqueadero.buttons.submit.modificar"/>
	     	</c:set>
	     	<c:set var="viewTittle">
	     		<spring:message code="modificarParqueadero.labels.titulo.modificar"/>
	     	</c:set>
	    </c:when>
	</c:choose>
</c:if>
<div class="body">
    <h1><c:out value="${viewTittle}"/></h1>    
	<form class="form-horizontal" role="form" action="${modificarUrl}" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="esCrear" value="${parqueadero.esCrear}" />
	  <div class="form-group elementoFormParqueadero">
	    <label class="control-label col-sm-2" for="tipoParqueadero"><spring:message code="modificarParqueadero.labels.tipo"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="tipoParqueadero" name="tipoParqueadero" placeholder="<spring:message code="modificarParqueadero.labels.placeholder.tipo"/>">
	    </div>
	  </div>
	  <div class="form-group elementoFormParqueadero">
	    <label class="control-label col-sm-2" for="espacios"><spring:message code="modificarParqueadero.labels.espacios"/></label>
	    <div class="col-sm-3"> 
	      <input type="text" class="form-control" id="espacios" name="espacios" placeholder="<spring:message code="modificarParqueadero.labels.placeholder.espacios"/>">
	    </div>
	  </div>
	  <div class="form-group elementoFormParqueadero">
	    <label class="control-label col-sm-2" for="estado"><spring:message code="modificarParqueadero.labels.habilitado"/></label>
	    <div class="col-sm-3 text-left"> 
	      <input type="checkbox" class="form-control" id="estado" name="estado">
	    </div>
	  </div>
	  <div class="form-group elementoFormParqueadero"> 
	    <div class="col-sm-offset-2 col-sm-10">
	    
	    <button type="submit" class="btn btn-default"><c:out value="${buttonName}"/></button>
	    </div>
	  </div>
	</form>
</div>