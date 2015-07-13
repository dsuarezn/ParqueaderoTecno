<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/registro/modificarAction" var="modificarUrl" htmlEscape="true"/>

	<c:set var="viewTittle">
 		<spring:message code="modificarRegistro.labels.titulo.general"/>
 	</c:set>
 	<c:set var="buttonName">
 		<spring:message code="modificarRegistro.buttons.submit.ingreso"/>
 	</c:set>

<div class="body">
    <h1><c:out value="${viewTittle}"/></h1>    
	<form class="form-horizontal" role="form" action="${modificarUrl}" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="esIngreso" value="${registro.esIngreso}" />
		
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="cedula"><spring:message code="modificarRegistro.labels.identificacion"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="cedula" name="cedula" placeholder="<spring:message code="modificarRegistro.labels.placeholder.cedula"/>">
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="cedula"><spring:message code="modificarRegistro.labels.nombres"/></label>
	    <div class="col-sm-3">
	      <c:out value="${registro.nombresyApellidos}"/>
	    </div>
	  </div>		 
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="vehiculoSeleccionado"><spring:message code="modificarRegistro.labels.vehiculos"/></label>
	    <div class="col-sm-3"> 	      	
			<select id="vehiculoSeleccionado" name="vehiculoSeleccionado" class="form-control">
				<c:forEach var="vehiculo" items="${registro.vehiculosList}">
					<option value="${vehiculo}"><c:out value="${vehiculo}"/></option>
				</c:forEach>
			</select>	      
	    </div>
	  </div>	 
	  <div class="form-group elementoFormUsuario"> 
	    <div class="col-sm-offset-2 col-sm-10">	    
	    	<button type="submit" class="btn btn-default"><c:out value="${buttonName}"/></button>
	    </div>
	  </div>	  
	</form>
</div>
<script>
	$(function() {
	    $cedula = $('#cedula');
	
	   $cedula.change (
	       function() {
	           $.ajax({
	               type: "POST",
	               url: "/registro/consultarUsuario",
	               data: {"projectKey": $projectKey.val() },
	               dataType: 'json',
	               success: function(data){
	                    alert('success');
	                    alert(data);
	                    $('#jiraVersion').append(
	                            $('<option></option>').html(data)
	                        );
	               }
	           });
	       }
	   );
	});

</script>