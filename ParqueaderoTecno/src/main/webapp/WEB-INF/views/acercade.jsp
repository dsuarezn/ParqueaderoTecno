<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="body">
    <div class="page-header">
	  <h1><spring:message code="acercade.labels.titulo"/> <small><spring:message code="acercade.labels.subtitulo"/></small></h1>
	</div>
	<div class="col-sm-3">
		<img alt="logoUD" src="<c:url value="/resources/images/logoUD.png"  />">
	</div>
	<div class="col-sm-6">
		<h1><spring:message code="acercade.labels.sistema"/></h1>
		<h3><spring:message code="acercade.labels.UD"/></h3>
	  	<h3><span class="label label-default"><spring:message code="acercade.labels.version"/></span></h3>
	  	<p><spring:message code="acercade.labels.copyright"/></p>
	  	<p align="justify"><spring:message code="acercade.labels.descripcion"/></p>
 	</div>
</div>
 