package teste.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teste.dao.AlunoDAO;
import teste.model.Aluno;
import teste.weka.Weka;

@WebServlet(name = "aluno", urlPatterns = "/aluno")
public class AlunoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		AlunoDAO.getIdades();
//		AlunoDAO.DF();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("predizer") != null) {

			String trabalho = request.getParameter("trabalho");
			String distancia = request.getParameter("distancia");
			String raca = request.getParameter("raca");
			String estadoCivil = request.getParameter("estadoCivil");
			String RFPC = request.getParameter("RFPC");
//			String status = request.getParameter("status");
			String formaIngresso = request.getParameter("formaIngresso");
			String reservaVaga = request.getParameter("reservaVaga");
			String dataString = request.getParameter("dataNasc");

			try {
				DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				java.sql.Date dataN = new java.sql.Date(fmt.parse(dataString).getTime());
				int idade = AlunoDAO.getSingleIdade(dataN);
				System.out.println(idade);

				int intervalo = AlunoDAO.getSingleIntervaloIdade(idade);

				List<List<String>> rows = Arrays.asList(Arrays.asList(estadoCivil.toString(), raca.toString(),
						distancia.toString(), formaIngresso.toString(), RFPC.toString(), trabalho.toString(),
						reservaVaga.toString(), Integer.toString(intervalo), "?"));
				Weka.csv(rows);
				ArrayList<String> res = Weka.arff();
				request.setAttribute("title", "Resultados:");
				request.setAttribute("mensagem", res);

				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("retorno.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

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
				e.printStackTrace();
			}
		}

	}
}
