package teste.weka;

import weka.core.Instances;
import weka.core.converters.DatabaseLoader;

public class Weka {

	public void get() {
		DatabaseLoader l;
		try {
			l = new DatabaseLoader();
			l.setSource("jdbc:mysql://localhost:3306/apeu", "root", "");
			l.setQuery(
					"select dataNasc, status, estadoCivil, raca, distancia, formaIngresso, RFPC, trabalho, reservaVaga from alunos LIMIT 27");
			Instances data = new Instances(l.getDataSet());
			data.setClassIndex(data.numAttributes()-1);
			System.out.println(data.getClass());
			System.out.println(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("epa.." + e.toString());
			e.printStackTrace();
		}
	}
}
