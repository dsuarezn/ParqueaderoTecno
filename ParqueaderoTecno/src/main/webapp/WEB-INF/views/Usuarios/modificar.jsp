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
	      <input type="text" class="form-control" id="username" name="username" value="${user.username}" placeholder="<spring:message code="modificarUsuario.labels.placeholder.usuario"/>" ${user.esCrear != true ? 'readonly' : ' '} required autofocus>
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="password"><spring:message code="modificarUsuario.labels.contrasena"/></label>
	    <div class="col-sm-3">
	      <input type="password" autocomplete="off" class="form-control" id="password" name="password" placeholder="<spring:message code="modificarUsuario.labels.placeholder.contrasena"/>" ${user.esCrear == true ? 'required autofocus' : ' '}>
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="rolename"><spring:message code="modificarUsuario.labels.rol"/></label>
	    <div class="col-sm-3">
			<select id="rolename" name="rolename" class="form-control" ${user.username eq pageContext.request.userPrincipal.name ? 'disabled' : ' '}>
				<c:forEach var="role" items="${roleslist}">
					<option value="${role.nombre}" ${user.rolename eq role.nombre ? 'selected' : ' '}><c:out value="${role.descripcion}"/></option>
				</c:forEach>
			</select>	      
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario">
	    <label class="control-label col-sm-2" for="enable"><spring:message code="modificarUsuario.labels.habilitado"/></label>
	    <div class="col-sm-3 text-left"> 
	      <input type="checkbox" class="form-control" ${user.enable == true ? 'checked' : ' '} id="enable" name="enable" ${user.username eq pageContext.request.userPrincipal.name ? 'disabled' : ' '}>
	    </div>
	  </div>
	  <div class="form-group elementoFormUsuario"> 
	    <div class="col-sm-offset-2 col-sm-2">
	       <button type="submit" class="btn btn-success"><c:out value="${buttonName}"/></button>
	    </div>
	    <div class="col-sm-offset-2 col-sm-2">
	    	<a class="btn btn-default" href="<c:url value="/welcome" />"><spring:message code="modificarUsuario.buttons.submit.cancelar"/></a>
	    </div>
	  </div>
	</form>
</div>

