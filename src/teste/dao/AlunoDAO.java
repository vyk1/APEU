package teste.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import teste.model.Aluno;

public class AlunoDAO {

	private DB conexao;

	public AlunoDAO(DB conexao) {
		super();
		this.conexao = conexao;
	}

	public static int getSingleIdade(Date dataNasc) {
		int years = 0;
		Calendar present = Calendar.getInstance();
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dataMat = new Date(fmt.parse("2017-03-01").getTime());
			present.setTime(dataMat);
			Calendar past = Calendar.getInstance();
			past.setTime(dataNasc);

			while (past.before(present)) {
				past.add(Calendar.YEAR, 1);
				if (past.before(present)) {
					years++;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return years;
	}

	public static int getSingleIntervaloIdade(int idade) {
		try {
			Connection con = DB.getConn();
			PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) as total FROM `alunos`");
			ResultSet rs1 = ps2.executeQuery();

			PreparedStatement ps3 = con.prepareStatement("SELECT MIN(idade) AS xmin FROM `alunos`");
			ResultSet rs2 = ps3.executeQuery();

			PreparedStatement ps4 = con.prepareStatement("SELECT MAX(idade) AS xmax FROM `alunos`");
			ResultSet rs3 = ps4.executeQuery();
			List<Aluno> list = new ArrayList<Aluno>();

			while (rs1.next()) {
				int n = rs1.getInt("total");

				while (rs3.next()) {
					int xmax = rs3.getInt("xmax");
					System.out.println(xmax);
					while (rs2.next()) {
						int xmin = rs2.getInt("xmin");
						System.out.println(xmin);
						int k = (int) Math.ceil(Math.sqrt(n));
						System.out.println(k);
						int aa = xmax - xmin;
						System.out.println(aa);
						double h = (double) aa / k;

						for (int i = 1; i <= k; i++) {
							int intervaloFinal = xmin + (k * i);
							int intervaloInicial = intervaloFinal - k;
							System.out.println(intervaloInicial + "----" + intervaloFinal);

							if (idade < intervaloFinal && idade >= intervaloInicial) {
								System.out.println(idade + "<" + intervaloFinal);
								System.out.println("classe:" + i);
								System.out.println(i);
								return i;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
		return idade;
	}

	public static void DF() {
		try {
			Connection con = DB.getConn();
			PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) as total FROM `alunos`");
			ResultSet rs1 = ps2.executeQuery();

			PreparedStatement ps3 = con.prepareStatement("SELECT MIN(idade) AS xmin FROM `alunos`");
			ResultSet rs2 = ps3.executeQuery();

			PreparedStatement ps4 = con.prepareStatement("SELECT MAX(idade) AS xmax FROM `alunos`");
			ResultSet rs3 = ps4.executeQuery();
			List<Aluno> list = new ArrayList<Aluno>();

			while (rs1.next()) {
				int n = rs1.getInt("total");

				while (rs3.next()) {
					int xmax = rs3.getInt("xmax");
					System.out.println(xmax);
					while (rs2.next()) {
						int xmin = rs2.getInt("xmin");
						System.out.println(xmin);
						int k = (int) Math.ceil(Math.sqrt(n));
						System.out.println(k);
						int aa = xmax - xmin;
						System.out.println(aa);
						double h = (double) aa / k;

						// pega idades
						for (int i = 1; i <= k; i++) {
							int intervaloFinal = xmin + (k * i);
							int intervaloInicial = intervaloFinal - k;
							System.out.println(intervaloInicial + "----" + intervaloFinal);

							try {
								PreparedStatement ps = con
										.prepareStatement("select idade, id from alunos order by idade");
								ResultSet rs = ps.executeQuery();
								while (rs.next()) {
									Aluno bean = new Aluno();
									bean.setIdade(rs.getInt("idade"));
									bean.setId(rs.getInt("id"));
									list.add(bean);
								}
								for (Aluno aluno : list) {
									int idade = aluno.getIdade();
									if (idade < intervaloFinal && idade >= intervaloInicial) {
										System.out.println(idade + "<" + intervaloFinal);
										System.out.println("classe:" + i);
										System.out.println(i);

										try {
											String classe = Integer.toString(i);
											aluno.setIntervaloIdade(classe);
											System.out.println(aluno.getIntervaloIdade() + aluno.getId());
											PreparedStatement ps1 = con
													.prepareStatement("update alunos set intervaloIdade=? where id=?");
											ps1.setString(1, aluno.getIntervaloIdade());
											ps1.setInt(2, aluno.getId());
											ps1.executeUpdate();

										} catch (Exception e) {
											System.out.println(e);
										}

									}
								}
							} catch (Exception e) {
								System.out.println(e);
							}
						}

					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static int getIdades() {
		List<Aluno> list = new ArrayList<Aluno>();
		int status = 0;
		try {
			Connection con = DB.getConn();
			PreparedStatement ps = con.prepareStatement("select id, dataNasc from alunos");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aluno bean = new Aluno();
				bean.setDataNasc(rs.getDate("dataNasc"));
				bean.setId(rs.getInt("id"));
				list.add(bean);
			}
			for (Aluno aluno : list) {

				Calendar present = Calendar.getInstance();
				DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date dataMat = new Date(fmt.parse("2017-03-01").getTime());
					present.setTime(dataMat);
					Calendar past = Calendar.getInstance();
					past.setTime(aluno.getDataNasc());

					int years = 0;

					while (past.before(present)) {
						past.add(Calendar.YEAR, 1);
						if (past.before(present)) {
							years++;
						}
					}
					System.out.println(years);

					// joga pro bd
					try {
						aluno.setIdade(years);
						PreparedStatement ps1 = con.prepareStatement("update alunos set idade=? where id=?");
						ps1.setInt(1, aluno.getIdade());
						ps1.setInt(2, aluno.getId());
						status = ps1.executeUpdate();

					} catch (Exception e) {
						System.out.println(e);
					}

				} catch (Exception e) {
					System.out.println(e);
				}
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static int inserir(Aluno obj) {
		int status = 0;
		try {
			Connection conexao = DB.getConn();
			PreparedStatement ps = conexao.prepareStatement(
					"insert into alunos \r\n" + "(alunos.status, alunos.dataNasc, alunos.estadoCivil, \r\n"
							+ " alunos.raca, alunos.distancia, alunos.RFPC,\r\n"
							+ " alunos.trabalho, alunos.formaIngresso, alunos.reservaVaga) \r\n" + "VALUES \r\n"
							+ "(?,?,?,?,?,?,?,?,?)");
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
