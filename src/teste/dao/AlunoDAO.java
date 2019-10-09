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
			PreparedStatement ps = conexao.prepareStatement("insert into alunos \r\n" + 
					"(alunos.status, alunos.dataNasc, alunos.estadoCivil, \r\n" + 
					" alunos.raca, alunos.distancia, alunos.RFPC,\r\n" + 
					" alunos.trabalho, alunos.formaIngresso, alunos.reservaVaga) \r\n" + 
					"VALUES \r\n" + 
					"(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, obj.getStatus());
			ps.setDate(2, obj.getDataNasc());
			ps.setString(3, obj.getEstadoCivil());
			ps.setString(4, obj.getRaca());
			ps.setInt(5, obj.getDistancia());
			ps.setString(6, obj.getRFPC());
			ps.setString(7, obj.getTrabalho());
			ps.setString(8, obj.getFormaIngresso());			
			ps.setString(9, obj.getReservaVaga());
			status = ps.executeUpdate();
			conexao.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;

	}
}
