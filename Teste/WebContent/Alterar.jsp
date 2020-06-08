<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alteração</title>
</head>
<body>
	<h1>Alterar - Notícias:</h1>
	
	<form action= "Controller.do" method ="post">
	  
		<h3>ID Notícia:</h3>
      	<input type = "number"  name = "id_noticia" > <br>
      
      	<h3>Título:</h3>
      	<input type = "text" name = "titulo_noticia"> <br>
      
      	<h3>Descrição:</h3>
      	<textarea name="descricao_noticia" cols="40" rows="3"></textarea><br>
      
      	<h3>Texto:</h3>
      	<textarea name = "texto_noticia" cols="40" rows="5"></textarea><br><br>
      	
      	<input type="reset" value="Limpar" >
      	<input type="hidden" name="command" value="Alterar">
      	<input type = "submit" value="Alterar">
      	
      
 	</form>
</body>
</html>