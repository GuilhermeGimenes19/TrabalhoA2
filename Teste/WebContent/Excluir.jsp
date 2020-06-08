<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Exclusão</title>
</head>
<body>
	<h1>Excluir - Notícias:</h1>
	
	<form action= "Controller.do" method ="post">
	  
		<h3>ID Notícia:</h3>
      	<input type = "number"  name = "id_noticia" > <br><br>
      	
      	<input type="reset" value="Limpar" >
      	<input type="hidden" name="command" value="Excluir">
        <input type = "submit" value="Excluir">
      	
 	</form>
</body>
</html>