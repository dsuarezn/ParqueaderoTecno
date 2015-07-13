<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="template.view.tittle"/></title>
    
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<link href="<c:url value="/resources/css/principal.css" />" rel="stylesheet">
    	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    	<script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
    	<script src="<c:url value="/resources/js/bootstrap.min.js"  />" ></script>
      	<script src="<c:url value="/resources/js/bootbox.min.js"  />" ></script>      	
</head>
<body>
    <div class="page">
        <tiles:insertAttribute name="header" />
        <div class="content">
            <tiles:insertAttribute name="menu" />
            <tiles:insertAttribute name="mensajes" />
            <tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    </div>
</body>
<script type="text/javascript">
$(document).ready(function(){
    $('.eliminarConfirm').on('click', function(event){
                   event.preventDefault();
                   var path = $(this).attr("href");                                      
        bootbox.confirm('<spring:message code="global.eliminar.confirmacion"/>', function(result) {
            if (result) {                 
                 //include the href duplication link here?;
                 window.location = path; 
            } 
        });
    });
    $('.errorAlert').delay(3000).fadeOut(1000);
    $('.exitoAlert').delay(3000).fadeOut(1000);
    $('.infoAlert').delay(4000).fadeOut(1000);
    
});
</script>
</html>