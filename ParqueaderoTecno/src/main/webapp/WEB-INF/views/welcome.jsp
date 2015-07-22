<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="body">
	<div class="page-header">
	  <h1><spring:message code="header.labels.bienvenido"/>
	  	<small><spring:message code="acercade.labels.subtitulo"/></small>
	  </h1>
	</div>
	
	<div class="col-sm-10">
		<p><spring:message code="header.labels.bienvenidoText"/></p>
    </div>
       
    <p><br></p>
    <div id="carousel-example-generic" class="carousel slide carouselUD" data-ride="carousel" data-interval="3000">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="5"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="6"></li>
	  </ol>
 
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner">
	    <div class="item active">
	      <img src="<c:url value="/resources/images/BannerInicial.png"  />" alt="image1">
	      <div class="carousel-caption">
	          <h3>Universidad Distrital Francisco José de Caldas</h3>
	          <p>Sede Tecnológica</p>
	      </div>
	    </div>
	    <div class="item">
	      <img src="<c:url value="/resources/images/Banner2.png"  />" alt="image2">
	    </div>
	    <div class="item">
	      <img src="<c:url value="/resources/images/Banner3.png"  />" alt="image3">
	    </div>
	    <div class="item">
	      <img src="<c:url value="/resources/images/Banner4.png"  />" alt="image4">
	    </div>
	    <div class="item">
	      <img src="<c:url value="/resources/images/Banner5.png"  />" alt="image5">
	    </div>
	    <div class="item">
	      <img src="<c:url value="/resources/images/Banner6.png"  />" alt="image6">
	    </div>
	    <div class="item">
	      <img src="<c:url value="/resources/images/Banner7.png"  />" alt="image7">
	    </div>
	  </div>
	 
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left"></span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right"></span>
	  </a>
	</div> <!-- Carousel -->
    
</div>
 
