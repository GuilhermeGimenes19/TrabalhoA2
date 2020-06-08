package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;


@WebServlet("/ComentarioC.do")
public class CadastrarC extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession sessao = request.getSession();
		
		Noticia noticiaConsultada = (Noticia) sessao.getAttribute("noticiaConsultada");
		
		int id = Integer.parseInt(request.getParameter("id_comentario"));
		String nome = request.getParameter("nome_comentario");
		String texto = request.getParameter("texto_comentario");
		
		response.setContentType("text/html; charset=UTF-8");
		
		int id_noticia = noticiaConsultada.getId();
		
		Comentario comentario = new Comentario();
		comentario.setId(id);
		comentario.setNome(nome);
		comentario.setTexto(texto);
		comentario.setFk_noticia_id(id_noticia);
		
		ComentarioService comentarioServie = new ComentarioService();
		
		comentarioServie.inserir(comentario);
		
		response.sendRedirect("Noticias.do");
	
	}

}
