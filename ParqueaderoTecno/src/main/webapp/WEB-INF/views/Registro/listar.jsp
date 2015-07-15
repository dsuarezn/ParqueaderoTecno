<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

		<spring:url value="/registro/listarFiltro" var="modificarUrl" htmlEscape="true"/>

		<c:set var="buttonName">
    		<spring:message code="listarRegistros.buttons.submit.consultar"/>
    	</c:set>
<div class="body">
    <h1><spring:message code="listarRegistros.labels.titulo"/></h1>
	<div class="panel panel-default">
		<form name="formFiltroConsulta" id="formFiltroConsulta" class="form-horizontal" role="form" action="${modificarUrl}" method="POST">	
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />					
		  <div class="form-group elementoFormUsuario">		   
		    <label class="control-label col-sm-1" for="placa"><spring:message code="listarRegistros.labels.placa"/></label>
		    <div class="col-sm-2">
		      <input type="text" class="form-control" id="placa" name="placa" value="${registros.placa}"/>
		    </div>		    
		    <label class="control-label col-sm-1" for="cedula"><spring:message code="listarRegistros.labels.cedula"/></label>
		    <div class="col-sm-2">
		      <input type="text" class="form-control" id="cedula" name="cedula" value="${registros.cedula}"/>
		    </div>
		  </div>
		 <div class="form-group elementoFormUsuario">
		    	<label class="control-label col-sm-1" for="fechaInicio"><spring:message code="listarRegistros.labels.fechaInicio"/></label>
		    <div id="datetimepicker_fechaIni" class="input-append date  col-sm-2">
		      <input type="date" data-format="dd/MM/yyyy" class="form-control" id="fechaInicio" name="fechaInicio" value="${registros.fechaInicio}"/>
		       <span class="add-on">
		      	<i data-time-icon="icon-time" data-date-icon="icon-calendar">
      			</i>
		      </span>	
		    </div>		    
		    <label class="control-label col-sm-1" for="fechaFin"><spring:message code="listarRegistros.labels.fechaFin"/></label>
		    <div id="datetimepicker_fechafin" class="input-append date col-sm-2">
		      <input type="text" data-format="dd/MM/yyyy" type="text" class="form-control" id="fechaFin" name="fechaFin" value="${registros.fechaFin}"/>
		      <span class="add-on">
		      	<i data-time-icon="icon-time" data-date-icon="icon-calendar">
      			</i>
		      </span>		      
		    </div>		    
		    <button type="submit" class="btn btn-default"><c:out value="${buttonName}"/></button>
		  </div>
		</form>
	
    <table class="table table-bordered table-hover table-condensed table-responsive" id="listUser">
	    <thead>
	    <tr>
	        <th><spring:message code="listarRegistros.tablaUsuarios.header.estado"/></th>
	        <th><spring:message code="listarRegistros.tablaUsuarios.header.fechaEntrada"/></th>
	        <th><spring:message code="listarRegistros.tablaUsuarios.header.fechaSalida"/></th>
	        <th><spring:message code="listarRegistros.tablaUsuarios.header.observacion"/></th>
	        <th><spring:message code="listarRegistros.tablaUsuarios.header.tipoParqueadero"/></th>
	        <th><spring:message code="listarRegistros.tablaUsuarios.header.placa"/></th>
	        <th><spring:message code="listarRegistros.tablaUsuarios.header.cedulapropietario"/></th>
	        <th><spring:message code="listarRegistros.tablaUsuarios.header.nombrepropietario"/></th>
	    </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${listaRegistros}" var="registro">
	    		<tr>	    			
	    			<td>
	    				<c:choose>
	    					<c:when test="${registro.estado == true}">
	    						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
	    					</c:when>
	    					<c:when test="${registro.estado == false}">
	    						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
	    					</c:when>
	    				</c:choose>	    			
	    			</td>
	    			<td>
	    				<fmt:formatDate pattern="d 'de' MMMM 'del' yyyy 'a las' h:mm a" value="${registro.fechaIngreso}" />
	    			</td>
	    			<td>
	    				<fmt:formatDate pattern="d 'de' MMMM 'del' yyyy 'a las' h:mm a" value="${registro.fechaSalida}" />
	    			</td>
	    			<td>
	    				<c:out value="${registro.observacion}"/>
	    			</td>	    			
	    			<td>
	    				<c:out value="${registro.tipoParqueo}"/>
	    			</td>
	    			<td>
	    				<c:out value="${registro.placa}"/>
	    			</td>
	    			<td>
	    				<c:out value="${registro.cedula}"/>
	    			</td>
	    			<td>
	    				<c:out value="${registro.nombresyApellidos}"/>
	    			</td>
	    		</tr>
	    	</c:forEach>	    	
	    </tbody>
	</table>
    </div>
    
</div>
 
<script type="text/javascript">
  $(function() {
    $('#datetimepicker_fechaIni').datetimepicker({
      language: 'es'
    });
    $('#datetimepicker_fechafin').datetimepicker({
        language: 'es'
      });
  });
</script>