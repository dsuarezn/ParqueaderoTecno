<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<div class="body">
	<input type="hidden" name="page" value="${page}" />
    <h1><spring:message code="listarUsuario.labels.titulo"/></h1>
	<div class="panel panel-default">
    <table class="table table-bordered table-hover table-condensed table-responsive" id="listUser">
	    <thead>
	    <tr>
	        <th><spring:message code="listarUsuario.tablaUsuarios.header.nombre"/></th>
	        <th><spring:message code="listarUsuario.tablaUsuarios.header.activo"/></th>
	        <th><spring:message code="listarUsuario.tablaUsuarios.header.rol"/></th>
	        <th><spring:message code="listarUsuario.tablaUsuarios.header.opciones"/></th>
	    </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${listUser}" var="userItem">
	    		<tr>
	    			<td><c:out value="${userItem.username}"/></td>
	    			<td>
	    				<c:choose>
	    					<c:when test="${userItem.enable == true}">
	    						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
	    					</c:when>
	    					<c:when test="${userItem.enable == false}">
	    						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
	    					</c:when>
	    				</c:choose>	    			
	    			</td>
	    			<td><c:out value="${userItem.rolename}"/></td>
	    			<td>		    			
		    			<a class="btn btn-default btn-lg" href="<c:url value='/usuarios/editar/${userItem.username}' />" >			    				
								  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</a>						
						<a class="btn btn-default btn-lg eliminarConfirm" href="<c:url value='/usuarios/eliminar/${userItem.username}' />" >							
							  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>							
						</a>
	    			</td>
	    		</tr>
	    	</c:forEach>	    	
	    </tbody>
	</table>
    </div>
    
</div>
 
 

