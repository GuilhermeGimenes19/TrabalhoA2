package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NewsService;

public class Alterar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id_noticia"));
		String descricao = request.getParameter("descricao_noticia");
		String titulo = request.getParameter("titulo_noticia");
		String texto = request.getParameter("texto_noticia");
		
		Noticia noticia = new Noticia();
		noticia.setId(id);
		noticia.setDescricao(descricao);
		noticia.setTitulo(titulo);
		noticia.setTexto(texto);
		
		NewsService newsService = new NewsService();
		
		newsService.alterar(noticia);
		
		PrintWriter saida = response.getWriter();
		saida.println("Notícia com ID " + id + " alterada.");
		
	}
}