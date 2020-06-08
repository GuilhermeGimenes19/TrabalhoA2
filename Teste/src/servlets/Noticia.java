package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Comentario;
import dao.NoticiaDAO;
import dao.ComentarioDAO;
import service.NewsService;
import service.ComentarioService;


@WebServlet("/Noticias.do")
public class Noticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		
		HttpSession sessao = request.getSession();
		
		Noticia noticiaConsultada = (Noticia) sessao.getAttribute("noticiaConsultada");
		
		saida.println("<h1>RealNews</h1>");
		saida.println("<hr>");
		saida.println("<h2>" + noticiaConsultada.getTitulo() + "</h2>");
		saida.println("<p>" + noticiaConsultada.getTexto() + "</p>");
		
		
		ComentarioService comentariaService = new ComentarioService();
		ArrayList<Comentario> listaComentarios = comentariaService.listarComentario();
		
		
		saida.println("<h2>Comentários:</h2>");
		
		listaComentarios.forEach(c -> {
					
			int id_noticia_fk = noticiaConsultada.getId();
			int id_comentario_fk = c.getFk_noticia_id(); 
			
			if(id_comentario_fk == id_noticia_fk) {
				saida.println("<h4>" + c.getNome() + "</h4>");
				saida.println("<p>" + c.getTexto() + "</p>" + "<br>");
				saida.println("<hr>");
			} 
			
		});
	
		
		
		saida.println("<form action='Inserir_Comentario.do' method='get'>");
		
		saida.println("<label>ID:</label>");
		saida.println("<br>");
		saida.println("<input type='number' name='id_comentario'>");
		saida.println("<br>");
		saida.println("<br>");
		
		saida.println("<label>Nome:</label>");
		saida.println("<br>");
		saida.println("<input type='text' name='nome_comentario'>");
		saida.println("<br>");
		saida.println("<br>");
		
		saida.println("<label>Comentario:</label>");
		saida.println("<br>");
		saida.println("<textarea name='texto_comentario' cols='40' rows='4'></textarea>");
		saida.println("<br><br>");		
		
		saida.println("<input type='submit' value='Enviar'>");
		saida.println("</form>");
		

		
	}

	private int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	private String getTexto() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getTitulo() {
		// TODO Auto-generated method stub
		return null;
	}

}
