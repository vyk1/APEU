<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="parts/header.html"%>
<title>APEU</title>

<form>
	<div class="jumbotron">
		<fieldset>
			<legend>Predição de modelo</legend>
			<div class="form-group">
				<label for="optionsRadios">Status do Aluno</label>
				<div class="form-check">
					<label class="form-check-label"> <input type="radio"
						class="form-check-input" name="optionsRadios" id="optionsRadios1"
						value="1" checked=""> Concluído
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label"> <input type="radio"
						class="form-check-input" name="optionsRadios" id="optionsRadios2"
						value="0"> Evadido
					</label>
				</div>
			</div>

			<div class="form-group">
				<label for="distancia" class="form-label">Distância
					Residencial de Panambi (em Km)</label> <input class="form-control"
					type="number" value="" id="distancia">
				<p style="color: red">Digite 0 se for em Panambi</p>
			</div>

			<div class="form-group">
				<label for="dataNasc">Data de Nascimento</label> <input
					class="form-control" type="date" id="example-datetime-local-input">
			</div>

			<div class="form-group">
				<label for="exampleSelect1">Cor/Raça</label> <select
					class="form-control" id="raca">
					<option value="1">Branca</option>
					<option value="">Preta</option>
					<option value="">Parda</option>
					<option value="">Amarela</option>
					<option value="">Indígena</option>
				</select>
			</div>

			<div class="form-group">
				<label for="exampleSelect1">Estado Civil</label> <select
					class="form-control" id="ec">
					<option value="1">Solteiro</option>
					<option value="">Casado</option>
					<option value="">União Estável</option>
					<option value="">Divorciado</option>
					<option value="">Separado</option>
					<option value="">Viúvo</option>
				</select>
			</div>

			<div class="form-group">
				<label for="exampleSelect1">Renda Familiar Per Capita (RFPC)</label>
				<select class="form-control" id="rfpc">
					<option value="1">Entre 0 e 0,5</option>
					<option value="2">Entre 0,5 e 1</option>
					<option value="3">Entre 1 e 1,5</option>
					<option value="4">Entre 1,5 e 2,5</option>
					<option value="5">Entre 2,5 e 3,5</option>
				</select>
			</div>

			<div class="form-group">
				<label for="exampleSelect1">Com Relação Ao Trabalho</label> <select
					class="form-control" id="trabalho">
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