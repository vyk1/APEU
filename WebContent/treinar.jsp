<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="parts/header.html"%>
<title>APEU</title>
<form action="./aluno" method="post">
	<div class="jumbotron">
		<fieldset>
			<legend>Treinamento de modelo</legend>
			<div class="form-group">
				<label for="optionsRadios">Status do Aluno</label>
				<div class="form-check">
					<label class="form-check-label"> <input type="radio"
						class="form-check-input" name="status" id="optionsRadios1"
						value="1" checked=""> Concluído
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label"> <input type="radio"
						class="form-check-input" name="status" id="optionsRadios2"
						value="0"> Evadido
					</label>
				</div>
			</div>

			<div class="form-group">
				<label for="distancia" class="form-label">Distância
					Residencial de Panambi (em Km)</label> <input class="form-control"
					type="number" id="distancia" name="distancia" required="required">
				<p style="color: red">Digite 0 se for em Panambi</p>
			</div>

			<div class="form-group">
				<label for="dataNasc">Data de Nascimento</label> <input
					class="form-control" type="date" id="example-datetime-local-input"
					name="dataNasc" required="required">
			</div>

			<div class="form-group">
				<label for="exampleSelect1">Cor/Raça</label> <select
					class="form-control" id="raca" name="raca">
					<option value="1">Branca</option>
					<option value="2">Parda</option>
					<option value="3">Preta</option>
					<option value="4">Amarela</option>
					<option value="5">Indígena</option>
				</select>
			</div>

			<div class="form-group">
				<label for="exampleSelect1">Estado Civil</label> <select
					class="form-control" id="ec" name="estadoCivil">
					<option value="1">Solteiro</option>
					<option value="2">Casado</option>
					<option value="3">União Estável</option>
					<option value="4">Divorciado</option>
					<option value="5">Separado</option>
					<option value="6">Viúvo</option>
				</select>
			</div>

			<div class="form-group">
				<label for="exampleSelect1">Renda Familiar Per Capita (RFPC)</label>
				<select class="form-control" id="rfpc" name="RFPC">
					<option value="1">Entre 0 e 0,5</option>
					<option value="2">Entre 0,5 e 1</option>
					<option value="3">Entre 1 e 1,5</option>
					<option value="4">Entre 1,5 e 2,5</option>
					<option value="5">Entre 2,5 e 3,5</option>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleSelect1">Forma de Ingresso</label> <select
					class="form-control" id="formaIngresso" name="formaIngresso">
					<option value="1">Enem/Sisu</option>
					<option value="2">Reingresso Automático</option>
					<option value="3">Portador de Diploma</option>
					<option value="4">Transferência Voluntária</option>
					
				</select>
			</div>
			<div class="form-group">
				<label for="exampleSelect1">Reserva de Vaga</label> <select
					class="form-control" id="reservaVaga" name="reservaVaga">
					<option value="1">Ampla Concorrência</option>
					<option value="2">Escola Pública - Renda<=1.5 Salários Mínimos</option>
					<option value="3">Escola Pública - Renda>1.5 Salários Mínimos</option>
					<option value="4">Reingresso</option>
					<option value="5">Transferência Interna</option>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleSelect1">Com Relação Ao Trabalho</label> <select
					class="form-control" id="trabalho" name="trabalho">
					<option value="1">Não realiza nenhuma atividade remunerada</option>
					<option value="2">Trabalhador com carteira assinada</option>
					<option value="3">Trabalhador sem carteira assinada</option>
					<option value="4">Servidor público concursado</option>
					<option value="5">Em contrato temporário</option>
					<option value="6">Autônomo/prestador de serviços ou
						proprietário de empresa</option>
					<option value="7">Trabalhador Rural</option>
				</select>
			</div>

		</fieldset>
		<button type="submit" class="btn btn-primary">Enviar</button>
		</fieldset>
	</div>
</form>


<%@ include file="parts/footer.html"%>
