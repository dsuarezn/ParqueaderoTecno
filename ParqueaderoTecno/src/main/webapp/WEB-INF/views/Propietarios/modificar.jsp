<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/propietarios/modificarAction" var="modificarUrl" htmlEscape="true"/>


<c:if test="${not empty propietario}">	
	<c:choose>
	    <c:when test="${propietario.esCrear == true}">
	     	<c:set var="buttonName">
	     		<spring:message code="modificarPropietario.buttons.submit.crear"/>
	     	</c:set>
	     	<c:set var="viewTittle">
	     		<spring:message code="modificarPropietario.labels.titulo.crear"/>
	     	</c:set>
	    </c:when>
	    <c:when test="${propietario.esCrear == false}">
	        <c:set var="buttonName">
	     		<spring:message code="modificarPropietario.buttons.submit.modificar"/>
	     	</c:set>
	     	<c:set var="viewTittle">
	     		<spring:message code="modificarPropietario.labels.titulo.modificar"/>
	     	</c:set>
	    </c:when>
	</c:choose>
</c:if>
<div class="body">
    <h1><c:out value="${viewTittle}"/></h1>    
	<form class="form-horizontal" role="form" action="${modificarUrl}?${_csrf.parameterName}=${_csrf.token}" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="esCrear" value="${propietario.esCrear}" />
	  <div class="form-group elementoFormPropietario">
	    <label class="control-label col-sm-2" for="tipoPropietario"><spring:message code="modificarPropietario.labels.tipoPropietario"/></label>
	    <div class="col-sm-3"> 	      	
			<select id="tipoPropietario" name="tipoPropietario" class="form-control">
				<option value="<spring:message code="modificarPropietario.labels.directivo"/>" ${propietario.tipoPropietario eq 'Directivo' ? 'selected' : ' '}>
					<spring:message code="modificarPropietario.labels.directivo"/></option>
				<option value="<spring:message code="modificarPropietario.labels.docente"/>" ${propietario.tipoPropietario eq 'Docente' ? 'selected' : ' '}>
					<spring:message code="modificarPropietario.labels.docente"/></option>
				<option value="<spring:message code="modificarPropietario.labels.estudiante"/>" ${propietario.tipoPropietario eq 'Estudiante' ? 'selected' : ' '}>
					<spring:message code="modificarPropietario.labels.estudiante"/></option>				
			</select>	      
	    </div>
	  </div>
		   
	  <div class="form-group elementoFormPropietario">
	    <label class="control-label col-sm-2" for="foto"><spring:message code="modificarPropietario.labels.foto"/></label>
	    <div class="col-sm-3">
			<div class="fileinput fileinput-new" data-provides="fileinput">
			  <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
					<img src="${pageContext.request.contextPath}/resources/photos/${propietario.foto != null ? propietario.foto : 'img190x140.png'}" alt="" />
			  </div>
			  <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
			  <div>
			    <span class="btn btn-default btn-file">
			    <span class="fileinput-new"><spring:message code="modificarPropietario.buttons.submit.seleccionarImg"/></span>
			    <span class="fileinput-exists"><spring:message code="modificarPropietario.buttons.submit.cambiarImg"/></span>
			    	<input type="file" name="file" value="${propietario.foto}"></span>
			  </div>
			</div>
	    </div>
	  </div>
	  
	  <div class="form-group elementoFormPropietario">
	    <label class="control-label col-sm-2" for="cedula"><spring:message code="modificarPropietario.labels.cedula"/></label>
	    <div class="col-sm-3">
	      <input type="text" pattern="[0-9]*" class="form-control" id="cedula" name="cedula" value="${propietario.cedula !=0 ? propietario.cedula : '' }" placeholder="<spring:message code="modificarPropietario.labels.placeholder.cedula"/>" ${propietario.esCrear != true ? 'readonly' : ' '} required>
	    </div>
	  </div>
	  <div class="form-group elementoFormPropietario">
	    <label class="control-label col-sm-2" for="nombre"><spring:message code="modificarPropietario.labels.nombre"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="nombre" name="nombre" value="${propietario.nombre}" placeholder="<spring:message code="modificarPropietario.labels.placeholder.nombre"/>" required>
	    </div>
	  </div>
	  <div class="form-group elementoFormPropietario">
	    <label class="control-label col-sm-2" for="apellido"><spring:message code="modificarPropietario.labels.apellido"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="apellido" name="apellido" value="${propietario.apellido}" placeholder="<spring:message code="modificarPropietario.labels.placeholder.apellido"/>" required>
	    </div>
	  </div>
	  <div class="form-group elementoFormPropietario">
	    <label class="control-label col-sm-2" for="telFijo"><spring:message code="modificarPropietario.labels.telFijo"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="telFijo" name="telFijo" value="${propietario.telFijo}" placeholder="<spring:message code="modificarPropietario.labels.placeholder.telFijo"/>">
	    </div>
	  </div>
	  <div class="form-group elementoFormPropietario">
	    <label class="control-label col-sm-2" for="telMovil"><spring:message code="modificarPropietario.labels.telMovil"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="telMovil" name="telMovil" value="${propietario.telMovil}" placeholder="<spring:message code="modificarPropietario.labels.placeholder.telMovil"/>">
	    </div>
	  </div>
	  
	  <div class="form-group elementoFormPropietario">
	    <label class="control-label col-sm-2" for="estado"><spring:message code="modificarUsuario.labels.habilitado"/></label>
	    <div class="col-sm-3 text-left"> 
	      <input type="checkbox" class="form-control" ${propietario.estado == true ? 'checked' : ' '} id="estado" name="estado">
	    </div>
	  </div>
	  
	  <div class="form-group elementoFormPropietario"> 
	    <div class="col-sm-offset-2 col-sm-2">	    
	    <button type="submit" class="btn btn-success"><c:out value="${buttonName}"/></button>
	    </div>
	    <div class="col-sm-offset-2 col-sm-2">
	    <a class="btn btn-default" href="<c:url value="/welcome" />"><spring:message code="modificarPropietario.buttons.submit.cancelar"/></a>
	    </div>
	  </div>
	</form>
</div>