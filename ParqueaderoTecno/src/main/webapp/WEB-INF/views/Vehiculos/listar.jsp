<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
	        <th><spring:message code="listarVehiculo.tablaVehiculos.header.tipovehiculo"/></th>       	        
	        <th><spring:message code="listarVehiculo.tablaVehiculos.header.opciones"/></th>     
	    </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${listVehiculo}" var="VehiculoItem">
	    		<tr>
	    			<td><c:out value="${VehiculoItem.placa}"/></td>
	    			<td><c:out value="${VehiculoItem.marca}"/></td>
	    			<td><c:out value="${VehiculoItem.linea}"/></td>
	    			<td><c:out value="${VehiculoItem.nombreCompletoPropietario}"/></td>
	    			<td><c:out value="${VehiculoItem.tipovehiculo}"/></td>
	    			
	    			<td>
	    				<a class="btn btn-default btn-lg" href="<c:url value='/vehiculos/editar/${VehiculoItem.placa}' />" title="Editar">			    				
								  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</a>						
						<a class="btn btn-default btn-lg eliminarConfirm" href="<c:url value='/vehiculos/eliminar/${VehiculoItem.placa}' />" title="Eliminar">							
							  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>							
						</a>
	    			</td>
	    		</tr>
	    	</c:forEach>	    	
	    </tbody>
	</table>
    </div>    
</div>