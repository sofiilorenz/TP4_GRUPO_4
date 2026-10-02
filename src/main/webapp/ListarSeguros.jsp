<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a>
<a href="ServletSeguro?Param=agregar">Agregar Seguros</a>
<a href="ListarSeguros.jsp">Listar Seguros</a>
<br>
<h1><b>"Tipo de Seguros en la base de datos"</b></h1>
<br>
Busqueda por tipo de seguros:<select></select> <input type="submit" name="btnFiltrar" value="Filtrar">
<br>
<table border="1" >
<tr>
<th>ID Seguro</th>
<th>Descripcion Seguro</th>
<th>Descripcion Tipo Seguro</th>
<th>Costo Contratacion</th>
<th>Costo Maximo Asegurado</th>

</tr>
</table>
</body>
</html>