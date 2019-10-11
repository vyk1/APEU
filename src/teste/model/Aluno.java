package teste.model;

import java.sql.Date;

public class Aluno {

	public Aluno() {
	}

	public Aluno(Date dataNasc, String status, String estadoCivil, String raca, int distancia, String formaIngresso,
			String RFPC, String trabalho, String reservaVaga) {
		super();
		this.dataNasc = dataNasc;
		this.status = status;
		this.estadoCivil = estadoCivil;
		this.raca = raca;
		this.distancia = distancia;
		this.formaIngresso = formaIngresso;
		this.RFPC = RFPC;
		this.trabalho = trabalho;
		this.reservaVaga = reservaVaga;
	}

	public int id;
	public Date dataNasc;
	public String status;
	public String estadoCivil;
	public String raca;
	public int distancia;
	public String formaIngresso;
	public String RFPC;
	public String trabalho;
	public String reservaVaga;
	public int idade;
	public int intervaloIdade;
	
	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getFormaIngresso() {
		return formaIngresso;
	}

	public void setFormaIngresso(String formaIngresso) {
		this.formaIngresso = formaIngresso;
	}

	public String getRFPC() {
		return RFPC;
	}

	public void setRFPC(String rFPC) {
		RFPC = rFPC;
	}

	public String getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(String trabalho) {
		this.trabalho = trabalho;
	}

	public String getReservaVaga() {
		return reservaVaga;
	}

	public void setReservaVaga(String reservaVaga) {
		this.reservaVaga = reservaVaga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getIdade() {
		return idade;
	}
	
	public int getIntervaloIdade() {
		return intervaloIdade;
	}

	public void setIntervaloIdade(int intervaloIdade) {
		this.intervaloIdade = intervaloIdade;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", dataNasc=" + dataNasc + ", status=" + status + ", estadoCivil=" + estadoCivil
				+ ", raca=" + raca + ", distancia=" + distancia + ", formaIngresso=" + formaIngresso + ", RFPC=" + RFPC
				+ ", trabalho=" + trabalho + ", reservaVaga=" + reservaVaga + "]";
	}


}
