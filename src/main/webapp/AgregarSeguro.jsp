<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.TipoSeguro"%>

<%
ArrayList<TipoSeguro> listaTipos = (ArrayList<TipoSeguro>) request.getAttribute("listaTipos");

Integer proximoId = (Integer) request.getAttribute("proximoId");
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


	<form action="ServletSeguro" method="get">


		<h1>
			<b>Agregar Seguros</b>
		</h1>


		<br> Id Seguros:

		<%
		if (proximoId != null) {
		%>

		<%=proximoId%>

		<%
		}
		%>

		<br> Descripcion: <input type="text" name="txtDescripcion">

		<br> Tipo de Seguro: <select name="idTipo">

			<%
			if (listaTipos != null) {

				for (TipoSeguro t : listaTipos) {
			%>

			<option value="<%=t.getIdTipo()%>">
				<%=t.getDescripcion()%>
			</option>

			<%
			}
			}
			%>

		</select> <br> Costo contratacion: <input type="text"
			name="txtCostoContratacion"> <br> Costo Maximo
		Asegurado: <input type="text" name="txtCostoAsegurado"> <br>


		<input type="submit" name="btnAceptar" value="Aceptar">


	</form>

	<%
	if (request.getAttribute("cantFilas") != null) {
		int filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		if (filas == 1) {
	%>
	Seguro agregado con exito
	<%
	} else {
	%>
	No se pudo agregar el seguro
	<%
	}
	}
	%>


</body>

</html>