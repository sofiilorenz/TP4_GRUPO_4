<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.Seguro"%>
<%@ page import="dominio.TipoSeguro"%>
<%
ArrayList<Seguro> listaSeguros = null;
if (request.getAttribute("listaS") != null) {
	listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaS");
}

ArrayList<TipoSeguro> listaTipos = null;
if (request.getAttribute("listaTipos") != null) {
	listaTipos = (ArrayList<TipoSeguro>) request.getAttribute("listaTipos");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP4_GRUPO_4</title>
</head>
<body>
	<a href="Inicio.jsp">Inicio</a>
	<a href="ServletSeguro?Agregar=1">Agregar Seguros</a>
	<a href="ServletSeguro?Param=1">Listar Seguros</a>
	<br>
	<h1>
		<b>"Tipo de Seguros en la base de datos"</b>
	</h1>
	<form action="ServletSeguro" method="get">
		Busqueda por tipo de seguros:
		<select name="ddlTipoFiltro">
			<%
			if (listaTipos != null)
				for (TipoSeguro t : listaTipos) {
			%>
			<option value="<%=t.getIdTipo()%>"><%=t.getDescripcion()%></option>
			<%
			}
			%>
		</select>
		<input type="submit" name="btnFiltrar" value="Filtrar">
	</form>
	<br>
	<table border="1">
		<tr>
			<th>ID Seguro</th>
			<th>Descripcion Seguro</th>
			<th>Descripcion Tipo Seguro</th>
			<th>Costo Contratacion</th>
			<th>Costo Maximo Asegurado</th>

		</tr>

		<%
		if (listaSeguros != null)
			for (Seguro seguro : listaSeguros) {
		%>
		<tr>
			<td><%=seguro.getIdSeguro()%></td>
			<td><%=seguro.getDescripcion()%></td>
			<td><%=seguro.getDescripcionTipo()%></td>
			<td><%=seguro.getCostoContratacion()%></td>
			<td><%=seguro.getCostoAsegurado()%></td>
		</tr>
		<%
		}
		%>

	</table>

</body>
</html>