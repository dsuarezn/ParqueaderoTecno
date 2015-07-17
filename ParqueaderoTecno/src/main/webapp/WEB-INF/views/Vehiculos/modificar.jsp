<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/vehiculos/modificarAction" var="modificarUrl" htmlEscape="true"/>


<c:if test="${not empty vehiculo}">	
	<c:choose>
	    <c:when test="${vehiculo.esCrear == true}">
	     	<c:set var="buttonName">
	     		<spring:message code="modificarVehiculo.buttons.submit.crear"/>
	     	</c:set>
	     	<c:set var="viewTittle">
	     		<spring:message code="modificarVehiculo.labels.titulo.crear"/>
	     	</c:set>
	    </c:when>
	    <c:when test="${vehiculo.esCrear == false}">
	        <c:set var="buttonName">
	     		<spring:message code="modificarVehiculo.buttons.submit.modificar"/>
	     	</c:set>
	     	<c:set var="viewTittle">
	     		<spring:message code="modificarVehiculo.labels.titulo.modificar"/>
	     	</c:set>
	    </c:when>
	</c:choose>
</c:if>
<div class="body">
    <h1><c:out value="${viewTittle}"/></h1>    
	<form class="form-horizontal" role="form" action="${modificarUrl}" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="esCrear" value="${vehiculo.esCrear}" />
	  <div class="form-group elementoFormVehiculo">
	    <label class="control-label col-sm-2" for="placa"><spring:message code="modificarVehiculo.labels.placeholder.placa"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="placa" name="placa" placeholder="<spring:message code="modificarVehiculo.labels.placeholder.placa"/>"  value = "${vehiculo.placa}">
	    </div>
	  </div>
	  <div class="form-group elementoFormVehiculo">
	    <label class="control-label col-sm-2" for="marca"><spring:message code="modificarVehiculo.labels.placeholder.marca"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="marca" name="marca" placeholder="<spring:message code="modificarVehiculo.labels.placeholder.marca"/>" value = "${vehiculo.marca}">
	    </div>
	  </div>
	  <div class="form-group elementoFormVehiculo">
	    <label class="control-label col-sm-2" for="linea"><spring:message code="modificarVehiculo.labels.placeholder.linea"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="linea" name="linea" placeholder="<spring:message code="modificarVehiculo.labels.placeholder.linea"/>"  value = "${vehiculo.linea}">
	    </div>
	  </div>
	  <div class="form-group elementoFormVehiculo">
	    <label class="control-label col-sm-2" for="cedula"><spring:message code="modificarVehiculo.labels.placeholder.cedula"/></label>
	    <div class="col-sm-3">
	      <select id="cedula" name="cedula" class="form-control">
				<c:forEach items="${listaPropietarios}" var="propietario">					
					<option value="${propietario.cedula}" ${vehiculo.cedula eq propietario.cedula ? 'selected' : ' '}><c:out value="${propietario.cedula} ${propietario.nombre} ${propietario.apellido}"/></option>
				</c:forEach>	
			</select>
	    </div>
	  </div>
	  
	  	  <div class="form-group elementoFormVehiculo">
	    <label class="control-label col-sm-2" for="tipovehiculo"><spring:message code="modificarVehiculo.labels.tipovehiculo"/></label>
	    <div class="col-sm-3">
	      <select id="tipovehiculo" name="tipovehiculo" class="form-control" >
				<option value="<spring:message code="modificarVehiculo.labels.automovil"/>"  ${vehiculo.tipovehiculo eq 'Automovil' ? 'selected' : ' '}>
				<spring:message code="modificarVehiculo.labels.automovil"/></option>
				<option value="<spring:message code="modificarVehiculo.labels.moto"/>"   ${vehiculo.tipovehiculo eq 'Moto' ? 'selected' : ' '}>
				<spring:message code="modificarVehiculo.labels.moto"/></option>		
			</select>
	    </div>
	  </div>
	  
	  <div class="form-group elementoFormVehiculo"> 
	    <div class="col-sm-offset-2 col-sm-2">
	    
	    <button type="submit" class="btn btn-success"><c:out value="${buttonName}"/></button>
	    </div>
	    <div class="col-sm-offset-2 col-sm-2">
	    <a class="btn btn-default" href="javascript:history.back()"><spring:message code="modificarVehiculo.buttons.submit.volver"/></a>
	    </div>
	  </div>
	</form>
</div>