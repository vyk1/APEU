package teste.weka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.DatabaseLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.StringToNominal;

public class Weka {

	public static Instances StringToNominal(Instances dataset) throws Exception {
		StringToNominal stringtoNominal = new StringToNominal();
		String[] options = new String[2];
		options[0] = "-R";
		options[1] = "last";

		stringtoNominal.setOptions(options);
		stringtoNominal.setInputFormat(dataset);

		Instances newData = Filter.useFilter(dataset, stringtoNominal);

		return newData;
	}

	public static Instances NumericToNominal(Instances dataset) throws Exception {
		NumericToNominal numericToNominal = new NumericToNominal();
		String[] options = new String[2];
		options[0] = "-R";
		options[1] = "1,2,4,5,6,7,8,9";

		numericToNominal.setOptions(options);
		numericToNominal.setInputFormat(dataset);

		Instances newData = Filter.useFilter(dataset, numericToNominal);
		for (int i = 0; i < newData.numAttributes(); i = i + 1) {
			System.out.println("Nominal? " + newData.attribute(i).isNominal());
		}
		return newData;
	}

	public static void csv(List<List<String>> rows) throws Exception {

		File file = new File("data.csv");
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		System.out.println(rows);

		FileWriter csvWriter = new FileWriter(file);
		csvWriter.append("estadoCivil");
		csvWriter.append(",");
		csvWriter.append("raca");
		csvWriter.append(",");
		csvWriter.append("distancia");
		csvWriter.append(",");
		csvWriter.append("formaIngresso");
		csvWriter.append(",");
		csvWriter.append("RFPC");
		csvWriter.append(",");
		csvWriter.append("trabalho");
		csvWriter.append(",");
		csvWriter.append("reservaVaga");
		csvWriter.append(",");
		csvWriter.append("intervaloIdade");
		csvWriter.append(",");
		csvWriter.append("status");
		csvWriter.append("\n");

		for (List<String> rowData : rows) {
			csvWriter.append(String.join(",", rowData));
			csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();

	}

	public static ArrayList<String> arff() throws Exception {
		DatabaseLoader dbl;
		try {
			dbl = new DatabaseLoader();
			dbl.setSource("jdbc:mysql://localhost:3306/apeu", "root", "");
			dbl.setQuery(
					"select status, estadoCivil, raca, distancia, formaIngresso, RFPC, trabalho, reservaVaga, intervaloIdade from alunos where id NOT IN(1)");
			Instances treino = dbl.getDataSet();
			treino.setClassIndex(0);
			CSVLoader l = new CSVLoader();
			l.setSource(new File("data.csv"));
			Instances unlabeled = l.getDataSet();
// ate aq csv
			ArffSaver saver = new ArffSaver();
			saver.setInstances(unlabeled);
			File file = new File("data.arff");

			if (file.exists()) {
				file.delete();
			}
			saver.setFile(file);
			saver.writeBatch();

			ArffLoader a = new ArffLoader();
			a.setSource(file);

			unlabeled = a.getDataSet();

			Instances ins = StringToNominal(unlabeled);
			Instances ins2 = NumericToNominal(ins);

			ins2.setClassIndex(ins2.numAttributes() - 1);
			Instances labeled = new Instances(ins2);

			MultilayerPerceptron mlp = new MultilayerPerceptron();
			mlp.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H 4"));
			mlp.buildClassifier(treino);

//			RandomForest rf = new RandomForest();
//			rf.buildClassifier(treino);
//			double x = rf.classifyInstance(ins2.instance(0));
//			System.out.println(x);

			System.out.println("=============================");
			for (int i = 0; i < ins2.numInstances(); i++) {
				double clsLabel = mlp.classifyInstance(ins2.instance(i));
				labeled.instance(i).setClassValue(clsLabel);

				System.out.println("=============================");

				double[] probs = mlp.distributionForInstance(ins2.instance(i));

				ArrayList<String> str = new ArrayList<String>();
				for (int j = 0; j < probs.length; j = j + 1) {
					System.out.println("Probability of class " + treino.classAttribute().value(j) + " : "
							+ Double.toString(probs[j]));
				}
				double roundOff = Math.round((probs[1] * 100) * 100.0) / 100.0;
				str.add("Probabilidade de evasão : " + Double.toString(roundOff) + "%");
				System.out.println(str);

				return str;
			}
		} catch (Exception e) {
			System.out.println("epa.." + e.toString());
			e.printStackTrace();
		}
		return null;
	}

	public static void pqp(Instances treino) throws Exception {

		// aponta para onde quer predizer
		treino.setClassIndex(0);
		// System.out.println(treino);
		Instances unlabeled = new Instances(new BufferedReader(new FileReader("C:\\Users\\Acer\\Desktop\\teste.arff")));
		unlabeled.setClassIndex(unlabeled.numAttributes() - 1);

		// System.out.println(unlabeled.numAttributes());
		Instances labeled = new Instances(unlabeled);

		MultilayerPerceptron mlp = new MultilayerPerceptron();
		mlp.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H 4"));
		mlp.buildClassifier(treino);

		// ARFFSAVER
		// JSONLOADER

		for (int i = 0; i < unlabeled.numInstances(); i++) {
			// p/ evadidos classifica como 1 pq la no treino o index é 1?

			double clsLabel = mlp.classifyInstance(unlabeled.instance(i));
			labeled.instance(i).setClassValue(clsLabel);

			System.out.println(clsLabel);
			System.out.println("=============================");

			double[] probs = mlp.distributionForInstance(unlabeled.instance(i));
			System.out.println("Probabilidade de evadir:" + probs[1]);
			System.out.println("Probabilidade de não evadir:" + probs[0]);

			System.out.println("=============================sum:");
			System.out.println(probs[1] + probs[0]);
			System.out.println(labeled.toString());
		}
	}
}
