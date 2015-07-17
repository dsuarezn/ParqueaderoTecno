<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:url value="/registro/modificarAction" var="modificarUrl" htmlEscape="true"/>

	<c:set var="viewTittle">
 		<spring:message code="modificarRegistro.labels.titulo.general"/>
 	</c:set>
 	<c:set var="buttonName">
 		<spring:message code="modificarRegistro.buttons.submit.ingreso"/>
 	</c:set>

<div class="body">
    <h1><c:out value="${viewTittle}"/></h1>    
	<form id="formRegistro" name="formRegistro" class="form-horizontal" role="form" action="${modificarUrl}" method="POST">
		<input type="hidden" id="csrftoken_" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" id="esIngreso" name="esIngreso" value="${registro.esIngreso}" />
		<input type="hidden" id="campoEnviado" name="campoEnviado" />
	   <div class="form-group elementoFormUsuario">	   
	    <label class="control-label col-sm-2" for="placa"><spring:message code="modificarRegistro.labels.placa"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="placa" name="placa" placeholder="<spring:message code="modificarRegistro.labels.placeholder.placa"/>">
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="cedula"><spring:message code="modificarRegistro.labels.identificacion"/></label>
     	 	<div id="cedula" class="col-sm-3">
				
			</div>
	  </div>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="cedula"><spring:message code="modificarRegistro.labels.nombres"/></label>
	    <div id="nombresYapellidos" class="col-sm-3">
	      
	    </div>
	  </div>		 
	  	<div id="fechasDiv" class="form-group elementoFormUsuario" style="display: none ;">
		    <label class="control-label col-sm-2" for="cedula"><spring:message code="modificarRegistro.labels.horaIngreso"/></label>
		    <div id="fechaIngreso" class="col-sm-3">		    	
		    		<jsp:useBean id="now" class="java.util.Date" />
		    		<fmt:formatDate pattern="d 'de' MMMM 'del' yyyy 'a las' h:mm a" value="${now}" />		      		
		    </div>
		    <div id="fechaIngresoGuardado" class="col-sm-3">		    			    				      		
		      		<fmt:formatDate pattern="d 'de' MMMM 'del' yyyy 'a las' h:mm a" value="${registro.fechaIngreso}" />
		    </div>
		</div>	 
	  <c:if test="${not empty registro.esIngreso}">
	  	<c:if test="${registro.esIngreso == 'ES_SALIDA'}">
		  <div class="form-group elementoFormUsuario">
		    <label class="control-label col-sm-2" for="cedula"><spring:message code="modificarRegistro.labels.horaSalida"/></label>
		    <div id="fechaSalida" class="col-sm-3">
		      <fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />
		    </div>
		  </div>	
		 </c:if>
	  </c:if>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="cedula"><spring:message code="modificarRegistro.labels.observaciones"/></label>
	    <div class="col-sm-3">
	      <textarea rows="4" cols="50" name="observacion" id="observacion">
	      	${registro.observacion}
	      </textarea>
	    </div>
	  </div> 
	  
	  		<div class="form-group elementoFormUsuario"> 
			    <div class="col-sm-offset-2 col-sm-10">	    
			    	<button type="submit" class="btn btn-default"><c:out value="${buttonName}"/></button>
			    </div>
	  		</div>
	  	  
	</form>
</div>
<script type="text/javascript">	

	
	$('#placa').change(function() {	   	       
	       $("#campoEnviado").val("PLACA");
	       ajaxCall();
	});

	

	function ajaxCall(){
		 var token = $("meta[name='_csrf']").attr("content");
	       var header = $("meta[name='_csrf_header']").attr("content");
         $.ajax({
             type: "POST",
             url: "/ParqueaderoTecno/registro/consultarUsuario",
             data:  $("#formRegistro").serialize() ,
             dataType: 'json',
             async: true,
             beforeSend: function (xhr) {
          	   xhr.setRequestHeader(header, token);
          	},
             headers: {          
          	     Accept : "application/json; charset=utf-8"   
          	},            	
             success: function(result) {
                 $("#nombresYapellidos").html(result.nombresyApellidos);
                 $("#observacion").html(result.observacion);
                 $("#cedula").html(result.cedula);
                 $("#fechasDiv").show();
                 if(new String(result.esIngreso).valueOf() == new String("ES_INGRESO").valueOf()){
                	 $("#fechaIngresoGuardado").hide();
                	 $("#fechaIngreso").show();                	 
                 }
                 else{
                	 $("#fechaIngreso").hide();
                	 $("#fechaIngresoGuardado").show();                	 
                 }
             },
             error: function(jqXHR, textStatus, errorThrown) {
                 alert(jqXHR.status + ' error:: ' + jqXHR.responseText);
             }
         });		
	}
	
</script>