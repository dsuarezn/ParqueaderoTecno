<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <spring:url value="/vehiculos/jsonlist" var="json_listar"/> --%>

<div class="body">
    <h1><spring:message code="listarVehiculo.labels.titulo"/></h1>
	<div class="panel panel-default">
    <table class="table table-bordered table-hover table-condensed table-responsive" id="listVehiculo">
	    <thead>
	    <tr>
	        <th><spring:message code="listarVehiculo.tablaVehiculos.header.placa"/></th>
	        <th><spring:message code="listarVehiculo.tablaVehiculos.header.marca"/></th>
	        <th><spring:message code="listarVehiculo.tablaVehiculos.header.linea"/></th>
	        <th><spring:message code="listarVehiculo.tablaPropietarios.header.cedula"/></th>
	    </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${listVehiculo}" var="VehiculoItem">
	    		<tr>
	    			<td><c:out value="${VehiculoItem.placa}"/></td>
	    			<td><c:out value="${VehiculoItem.marca}"/></td>
	    			<td><c:out value="${VehiculoItem.linea}"/></td>
	    			<td><c:out value="${VehiculoItem.cedula}"/></td>
	    			
	    			<td>
	    				<button type="button" class="btn btn-default btn-lg">
						  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
						<button type="button" class="btn btn-default btn-lg">
						  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</button>
	    			</td>
	    		</tr>
	    	</c:forEach>	    	
	    </tbody>
	</table>
    </div>    
</div>