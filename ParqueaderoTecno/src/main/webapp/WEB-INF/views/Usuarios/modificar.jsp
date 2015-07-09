<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/usuarios/modificarAction" var="modificarUrl" htmlEscape="true"/>


<c:if test="${not empty user}">	
	<c:choose>
	    <c:when test="${user.esCrear == true}">
	     	<c:set var="buttonName">
	     		<spring:message code="modificarUsuario.buttons.submit.crear"/>
	     	</c:set>
	     	<c:set var="viewTittle">
	     		<spring:message code="modificarUsuario.labels.titulo.crear"/>
	     	</c:set>
	    </c:when>
	    <c:when test="${user.esCrear == false}">
	        <c:set var="buttonName">
	     		<spring:message code="modificarUsuario.buttons.submit.modificar"/>
	     	</c:set>
	     	<c:set var="viewTittle">
	     		<spring:message code="modificarUsuario.labels.titulo.modificar"/>
	     	</c:set>
	    </c:when>
	</c:choose>
</c:if>
<div class="body">
    <h1><c:out value="${viewTittle}"/></h1>    
	<form class="form-horizontal" role="form" action="${modificarUrl}" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="esCrear" value="${user.esCrear}" />
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="username"><spring:message code="modificarUsuario.labels.usuario"/></label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="username" name="username" placeholder="<spring:message code="modificarUsuario.labels.placeholder.usuario"/>">
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="password"><spring:message code="modificarUsuario.labels.contrasena"/></label>
	    <div class="col-sm-3"> 
	      <input type="password" class="form-control" id="password" name="password" placeholder="<spring:message code="modificarUsuario.labels.placeholder.contrasena"/>">
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="rolename"><spring:message code="modificarUsuario.labels.rol"/></label>
	    <div class="col-sm-3"> 	      	
			<select id="rolename" name="rolename" class="form-control">
				<c:forEach var="role" items="${roleslist}">
					<option value="${role.nombre}"><c:out value="${role.descripcion}"/></option>
				</c:forEach>
			</select>
	      
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="enable"><spring:message code="modificarUsuario.labels.habilitado"/></label>
	    <div class="col-sm-3 text-left"> 
	      <input type="checkbox" class="form-control" id="enable" name="enable">
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario"> 
	    <div class="col-sm-offset-2 col-sm-10">
	    
	    <button type="submit" class="btn btn-default"><c:out value="${buttonName}"/></button>
	    </div>
	  </div>
	</form>
</div>
