<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <spring:url value="/propietarios/jsonlist" var="json_listar"/> --%>

<div class="body">
    <h1><spring:message code="listarPropietario.labels.titulo"/></h1>
	<div class="panel panel-default">
    <table class="table table-bordered table-hover table-condensed table-responsive" id="listPropietario">
	    <thead>
	    <tr>
	        <th><spring:message code="listarPropietario.tablaPropietarios.header.foto"/></th>
	        <th><spring:message code="listarPropietario.tablaPropietarios.header.activo"/></th>
	        <th><spring:message code="listarPropietario.tablaPropietarios.header.tipoPropietario"/></th>
	        <th><spring:message code="listarPropietario.tablaPropietarios.header.cedula"/></th>
	        <th><spring:message code="listarPropietario.tablaPropietarios.header.nombre"/></th>
	        <th><spring:message code="listarPropietario.tablaPropietarios.header.apellido"/></th>
	        	        <th><spring:message code="listarPropietario.tablaPropietarios.header.opciones"/></th>
	    </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${listPropietario}" var="PropietarioItem">
	    		<tr>
	    			<td><c:out value="${PropietarioItem.foto}"/></td>
	    			<td>
	    				<c:choose>
	    					<c:when test="${PropietarioItem.estado == true}">
	    						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
	    					</c:when>
	    					<c:when test="${PropietarioItem.estado == false}">
	    						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
	    					</c:when>
	    				</c:choose>	    			
	    			</td>
	    			<td><c:out value="${PropietarioItem.tipoPropietario}"/></td>
	    			<td><c:out value="${PropietarioItem.cedula}"/></td>
	    			<td><c:out value="${PropietarioItem.nombre}"/></td>
	    			<td><c:out value="${PropietarioItem.apellido}"/></td>
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