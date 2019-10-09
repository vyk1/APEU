package teste.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import teste.model.Aluno;

public class AlunoDAO {

	private DB conexao;

	public AlunoDAO(DB conexao) {
		super();
		this.conexao = conexao;
	}

	public static int inserir(Aluno obj) {
		int status = 0;
		try {
			Connection conexao = DB.getConn();
			PreparedStatement ps = conexao.prepareStatement("INSERT into alunos values(?,?,?,?,?,?)");
			ps.setString(1, obj.getEstadoCivil());
			ps.setString(2, obj.getFormaIngresso());
			ps.setString(3, obj.getRaca());
			ps.setString(4, obj.getReservaVaga());
			ps.setString(5, obj.getRFPC());
			ps.setString(6, obj.getStatus());
			ps.setString(7, obj.getTrabalho());
			status = ps.executeUpdate();
			conexao.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;

	}
}
