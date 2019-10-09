package teste.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import teste.dao.AlunoDAO;
import teste.model.Aluno;

@WebServlet(name = "aluno", urlPatterns = "/aluno")
public class AlunoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request);
		String dataNasc = request.getParameter("dataNasc");
		String trabalho = request.getParameter("trabalho");
		String distancia = request.getParameter("distancia");
		String raca = request.getParameter("raca");
		String estadoCivil = request.getParameter("estadoCivil");
		String RFPC = request.getParameter("RFPC");
		String status = request.getParameter("status");
		String formaIngresso = request.getParameter("formaIngresso");
		String reservaVaga = request.getParameter("reservaVaga");

		String dataString = request.getParameter("dataNasc");
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.sql.Date dataN = new java.sql.Date(fmt.parse(dataString).getTime());

			Integer distanciaInt = Integer.parseInt(distancia);
			Aluno amodel = new Aluno(dataN, status, estadoCivil, raca, distanciaInt, formaIngresso, RFPC, trabalho,
					reservaVaga);

			System.out.println(amodel.toString());
			int saved = AlunoDAO.inserir(amodel);

			PrintWriter out = response.getWriter();
			if (saved > 0) {
				request.setAttribute("title", "Sucesso");
				request.setAttribute("mensagem", "Cadastro realizado com sucesso");
			} else {
				request.setAttribute("title", "Ocorreu um erro... :(");
				request.setAttribute("mensagem", "Se o erro persistir, contate o administrador");
			}

			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("retorno.jsp");
			rd.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
