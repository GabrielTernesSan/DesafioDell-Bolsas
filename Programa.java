import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) throws IOException {
		int br = 0;
		Scanner sc = new Scanner(System.in);

		List<Universitario> consulta = ReadFile();
		while (br == 0) {
			System.out.println("===============MENU===============");
			System.out.println("1 - Consultar bolsa zero");
			System.out.println("2 - Codificar nomes");
			System.out.println("3 - Consultar média anual");
			System.out.println("4 - Ranking valores de bolsa");
			System.out.println("5 - Encerrar Programa");
			System.out.println();
			System.out.println("Opção:");
			int option = sc.nextInt();

			if (option == 1) {
				System.out.println("Ano de consulta: ");
				int ano = sc.nextInt();
				List<Universitario> consultado = new ArrayList<>();

				for (int i = 0; i < consulta.size(); i++) {
					if (consulta.get(i).getAno() == ano) {
						consultado.add(consulta.get(i));
					} else {
						System.out.println("Não encontrado!");
					}
				}
				System.out.println(consultado.get(0));

			} else if (option == 2) {
				String array[] = new String[10];
				String array2[] = new String[10];
				int ascii[] = new int[15];
				
				String codificado = "";
				String codificadoT = "";
				sc.nextLine();
				int index = 0;
				String meio = "";
				
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				
				for(int i = 0; i < consulta.size(); i++) {
					if(consulta.get(i).getNome().contains(nome.toUpperCase())) {
						index = consulta.indexOf(consulta.get(i));
						}
					}
			
				array = consulta.get(index).getNome().split(" ");
				for(int j = 0; j < array.length; j++) {
					if(array[j].length() >= 4) {
						meio = new StringBuilder(array[j].substring(1, (array[j].length()-1))).reverse().toString();
						codificado += array[j].substring(0,1) + meio + array[j].substring(array[j].length() -1) + " ";
					}else {
						codificado += new StringBuilder(array[j]).reverse().toString() + " ";
					}
				}
				
				array2 = codificado.split(" ");
				for(int k = 0; k < array2.length; k++) {
					for(int l = 0; l < array2[k].length(); l++) {
						ascii[l] = (int) array2[k].charAt(l);
						if(ascii[l] != 90) {
							ascii[l] += 1;
						} else {
							ascii[l] = 65;
						}
						codificadoT += Character.toString((char) ascii[l]);
					}
					codificadoT += " ";
				}
				System.out.printf("[ %s, %d, %s, %.2f ] %n", codificadoT, consulta.get(index).getAno(), consulta.get(index).getEntidadeEnsino(), consulta.get(index).getValorBolsa());

			} else if (option == 3) {

				System.out.println("Ano de consulta: ");
				int ano = sc.nextInt();
				double soma = 0.0;
				double media = 0.0;
				
				List<Universitario> consultado = new ArrayList<>();

				for (int i = 0; i < consulta.size(); i++) {
					if (consulta.get(i).getAno() == ano) {
						consultado.add(consulta.get(i));
					}
				}
				
				for (int i = 0; i < consultado.size(); i++) {
					soma += consultado.get(i).getValorBolsa();
				}
				
				media = soma / consultado.size();
				System.out.printf("Media: %.2f %n", media);

			} else if (option == 4) {
				Universitario max1 = consulta.get(0);
				Universitario max2 = consulta.get(0);
				Universitario max3 = consulta.get(0);
				Universitario min1 = consulta.get(0);
				Universitario min2 = consulta.get(0);
				Universitario min3 = consulta.get(0);

				for (int i = 0; i < consulta.size(); i++) {
					if (max1.getValorBolsa() < consulta.get(i).getValorBolsa()) {
						max1 = consulta.get(i);
					}
					if (max2.getValorBolsa() < consulta.get(i).getValorBolsa()
							&& max1.getValorBolsa() != consulta.get(i).getValorBolsa()) {
						max2 = consulta.get(i);
					}
					if ((max3.getValorBolsa() < consulta.get(i).getValorBolsa()
							&& max2.getValorBolsa() > consulta.get(i).getValorBolsa())) {
						max3 = consulta.get(i);
					}
				}

				for (int i = 0; i < consulta.size(); i++) {
					if ((min1.getValorBolsa() < consulta.get(i).getValorBolsa())
							&& (consulta.get(i).getValorBolsa() < max3.getValorBolsa())) {
						min1 = consulta.get(i);
					}
					if (consulta.get(i).getValorBolsa() < min1.getValorBolsa()) {
						min2 = consulta.get(i);
					}
					if ((min3.getValorBolsa() > consulta.get(i).getValorBolsa())
							&& (consulta.get(i).getValorBolsa() != min2.getValorBolsa())) {
						min3 = consulta.get(i);
					}
				}

				System.out.println("1º " + max1);
				System.out.println("2º " + max2);
				System.out.println("3º " + max3);
				System.out.println();
				System.out.println("1º " + min3);
				System.out.println("2º " + min2);
				System.out.println("3º " + min1);

			} else if (option == 5){
				br = 1;
			} else {
				System.out.println("Valor inválido! Por favor verifique novamente!");
			}
		}
		sc.close();

	}

	public static List<Universitario> ReadFile() throws IOException {
		List<Universitario> bolsistas = new ArrayList<>();

		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		try {

			br = new BufferedReader(new FileReader("C:\\Users\\Gabri\\Desktop\\Desafios DELL\\Bolsas\\bolsistas.csv"));
			br.readLine();
			while ((linha = br.readLine()) != null) {

				String[] data = linha.split(csvDivisor);

				Universitario bolsista = new Universitario(data[0], data[1], data[2], Double.parseDouble(data[10]),
						Integer.parseInt(data[4]));

				bolsistas.add(bolsista);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bolsistas;
	}
}
