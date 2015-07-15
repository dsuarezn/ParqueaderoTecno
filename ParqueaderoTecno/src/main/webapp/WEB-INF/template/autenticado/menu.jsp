<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:url value="/usuarios/crear" var="usuarios_crear" />
<spring:url value="/usuarios/listar" var="usuarios_listar"/>

<spring:url value="/propietarios/crear"  var="propietarios_crear"/>
<spring:url value="/propietarios/listar"  var="propietarios_listar"/>

<spring:url value="/registro/crear"  var="registro_crear"/>
<spring:url value="/registro/listar"  var="registro_listar"/>

<spring:url value="/parqueaderos/crear"  var="parqueaderos_crear"/>
<spring:url value="/parqueaderos/listar"  var="parqueaderos_listar"/>


<div class="menu"> 		  
      <div id="MainMenu">
        <div class="list-group panel">    
        <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUSER')">
        	<a href="#demo3" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu"><spring:message code="menu.labels.usuarios"/></a>
          	<div class="collapse" id="demo3">            	
            	<a href="${usuarios_crear}" class="list-group-item"><spring:message code="menu.labels.usuarios.crear"/></a>
            	<a href="${usuarios_listar}" class="list-group-item"><spring:message code="menu.labels.usuarios.consulta"/></a>            
          	</div>
		</sec:authorize>
        <sec:authorize access="hasAnyRole('ROLE_ASISTENTE','ROLE_SUSER')">
        	<a href="#demo4" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu"><spring:message code="menu.labels.propietarios"/></a>
            <div class="collapse" id="demo4">
	            <a href="${propietarios_crear}" class="list-group-item"><spring:message code="menu.labels.propietarios.crear"/></a>
	            <a href="${propietarios_listar}" class="list-group-item"><spring:message code="menu.labels.propietarios.consulta"/></a>      
         	</div>  
        	<a href="#demo5" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu"><spring:message code="menu.labels.parqueaderos"/></a>
          	<div class="collapse" id="demo5">
            	<a href="${parqueaderos_crear}"  class="list-group-item"><spring:message code="menu.labels.parqueaderos.crear"/></a>
            	<a href="${parqueaderos_listar}" class="list-group-item"><spring:message code="menu.labels.parqueaderos.consulta"/></a>            
          	</div>
          	<a href="#demo6" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu"><spring:message code="menu.labels.vehiculos"/></a>
            <div class="collapse" id="demo6">
            	<a href="" class="list-group-item"><spring:message code="menu.labels.vehiculos.crear"/></a>
            	<a href="" class="list-group-item"><spring:message code="menu.labels.vehiculos.consulta"/></a>            
         	</div>
        </sec:authorize>    	
        <sec:authorize access="hasAnyRole('ROLE_GUARDIA','ROLE_SUSER')">
        	<a href="#demo7" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu"><spring:message code="menu.labels.registro"/></a>
            <div class="collapse" id="demo7">
            	<a href="${registro_crear}" class="list-group-item"><spring:message code="menu.labels.registro.ingreso"/></a>
            	<a href="${registro_listar}" class="list-group-item"><spring:message code="menu.labels.registro.listar"/></a>            
         	</div>  	
        </sec:authorize>    	            	         	
        </div>
      </div>
</div>