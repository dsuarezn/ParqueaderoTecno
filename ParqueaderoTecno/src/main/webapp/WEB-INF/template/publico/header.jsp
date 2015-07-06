<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>




<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
           <a class="navbar-brand" href="#"><spring:message code="global.app.name"/></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">         
          <ul class="nav navbar-nav navbar-right">           
            <c:if test="${pageContext.request.userPrincipal.name != null}">
					<li> <a class="headerLoggedUserCapitalize"><spring:message code="header.labels.welcome"/> ${pageContext.request.userPrincipal.name} </a> </li>
					<li><a href="javascript:formSubmit()"> <spring:message code="global.salir"/></a></li>
			</c:if>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
   	<c:url value="/j_spring_security_logout" var="logoutUrl" />
 
	<!-- csrt for log out-->
	<form action="${logoutUrl}" method="post" id="logoutForm">
	  <input type="hidden" 
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>
	
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
 