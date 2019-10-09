package teste.controller;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			System.out.println(dataN);

			Integer distanciaInt = Integer.parseInt(distancia);
			System.out.println(distanciaInt);
			Aluno amodel = new Aluno(dataN, status, estadoCivil, raca, distanciaInt, formaIngresso, RFPC, trabalho,
					reservaVaga);
			System.out.println(amodel.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.getWriter().append("O que veio").append(request.getParameter("dataNasc"));

	}

}
