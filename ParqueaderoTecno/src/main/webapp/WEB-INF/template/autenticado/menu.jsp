<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="menu"> 		  
      <div id="MainMenu">
        <div class="list-group panel">    
        <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUSER')">
        	<a href="#demo3" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu"><spring:message code="menu.labels.usuarios"/></a>
          	<div class="collapse" id="demo3">
            	<a href="#SubMenu1" class="list-group-item" data-toggle="collapse" data-parent="#SubMenu1"><spring:message code="menu.labels.usuarios.crear"/><i class="fa fa-caret-down"></i></a>
            	<a href="javascript:;" class="list-group-item"><spring:message code="menu.labels.usuarios.consulta"/></a>            
          	</div>
		</sec:authorize>
        <sec:authorize access="hasAnyRole('ROLE_ASISTENTE','ROLE_SUSER')">
        	<a href="#demo4" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu"><spring:message code="menu.labels.propietarios"/></a>
            <div class="collapse" id="demo4">
	            <a href="" class="list-group-item"><spring:message code="menu.labels.propietarios.crear"/></a>
	            <a href="" class="list-group-item"><spring:message code="menu.labels.propietarios.consulta"/></a>
	            <a href="" class="list-group-item"><spring:message code="menu.labels.propietarios.carne"/></a>            
         	</div>  
        	<a href="#demo5" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu"><spring:message code="menu.labels.parqueaderos"/></a>
          	<div class="collapse" id="demo5">
            	<a href="" class="list-group-item"><spring:message code="menu.labels.parqueaderos.crear"/></a>
            	<a href="" class="list-group-item"><spring:message code="menu.labels.parqueaderos.consulta"/></a>            
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
            	<a href="" class="list-group-item"><spring:message code="menu.labels.registro.ingreso"/></a>
            	<a href="" class="list-group-item"><spring:message code="menu.labels.registro.salida"/></a>            
         	</div>  	
        </sec:authorize>    	            	         	
        </div>
      </div>
</div>