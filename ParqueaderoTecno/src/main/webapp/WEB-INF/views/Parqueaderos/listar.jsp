<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <spring:url value="/parqueaderos/jsonlist" var="json_listar"/> --%>

<div class="body">
	<h1>
		<spring:message code="listarParqueaderos.labels.titulo" />
	</h1>
	<div class="panel panel-default">
		<table
			class="table table-bordered table-hover table-condensed table-responsive"
			id="listParqueadero">
			<thead>
				<tr>
					<th><spring:message
							code="listarParqueaderos.tablaPropietarios.header.tipoParqueadero" /></th>
					<th><spring:message
							code="listarParqueaderos.tablaPropietarios.header.espacios" /></th>
					<th><spring:message
							code="listarParqueaderos.tablaPropietarios.header.activo" /></th>
					<th><spring:message
							code="listarParqueaderos.tablaPropietarios.header.opciones" /></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listParqueadero}" var="parqueaderoItem">
					<tr>
						<td><c:out value="${parqueaderoItem.tipoParqueadero}" /></td>
						<td><c:out value="${parqueaderoItem.espacios}" /></td>
						<td><c:choose>
								<c:when test="${parqueaderoItem.estado == true}">
									<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
								</c:when>
								<c:when test="${parqueaderoItem.estado == false}">
									<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
								</c:when>
							</c:choose></td>

						<td>
						
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</button>
							<button type="button" class="btn btn-default btn-lg">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>
