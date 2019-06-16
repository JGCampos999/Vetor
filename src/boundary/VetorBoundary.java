package boundary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VetorBoundary extends Application {

	private Button btnPares = new Button("Pares");
	private Button btnDec = new Button("Ordem Descrescente");
	private Button btnGT = new Button("Maior Valor");
	private Button btnLS = new Button("Menor Valor");
	private Button btnSet = new Button("Sétima Posição");
	private Button btnInv = new Button("Inverter Vetor");
	private Button btnWT = new Button("Gravar Vetor em Arquivo");
	private Button btnRD = new Button("Ler Vetor do Arquivo");
	private TextField resultado = new TextField();

	private Random r = new Random();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		int vet[] = new int[15];
		for (int i = 0; i < 15; i++) {
			vet[i] = r.nextInt(100);
		}

		BorderPane painelPrincipal = new BorderPane();
		GridPane painelResult = new GridPane();
		GridPane painelBotoes = new GridPane();

//		painel2.setVgap(10);
//		a.	Lista na tela somente os números pares, retorne na função a quantidade de números pares existentes no vetor.
//		b.	Lista na tela todos os elementos armazenados, em ordem decrescente (Não vale utilizar funções prontas, é 
//		preciso criar um algoritmo).
//		c.	Retorne o maior valor armazenado e mostre na tela em qual posição ele se encontra no vetor.
//		d.	Retorne o menor valor armazenado e mostre na tela em qual posição ele se encontra no vetor.
//		e.	Retorne o valor armazenado na sétima posição do vetor e mostre na tela qual o valor que mais se aproxima dele,
//		a diferença e em qual posição se encontra no vetor.
//		f.	Retorne um vetor que será o inverso do vetor existente na classe.
//		g.	Grave no arquivo “C:/vetor.txt” o conteúdo deste vetor em formato texto, sendo que o conteúdo de cada célula
//		será gravada em uma linha diferente. 
//		h.	Leia o Arquivo “C:/vetor.txt” e popule o vetor com os valores contidos neste arquivo, coloque o conteúdo de 
//		cada linha dentro de cada célula do vetor.

		painelBotoes.add(btnPares, 0, 0);
		painelBotoes.add(btnDec, 0, 1);
		painelBotoes.add(btnGT, 0, 2);
		painelBotoes.add(btnLS, 0, 3);
		painelBotoes.add(btnSet, 0, 4);
		painelBotoes.add(btnInv, 0, 5);
		painelBotoes.add(btnWT, 0, 6);
		painelBotoes.add(btnRD, 0, 7);

		btnPares.setPrefHeight(30);
		btnPares.setPrefWidth(300);
		btnDec.setPrefHeight(30);
		btnDec.setPrefWidth(300);
		btnGT.setPrefHeight(30);
		btnGT.setPrefWidth(300);
		btnLS.setPrefHeight(30);
		btnLS.setPrefWidth(300);
		btnSet.setPrefHeight(30);
		btnSet.setPrefWidth(300);
		btnInv.setPrefHeight(30);
		btnInv.setPrefWidth(300);
		btnWT.setPrefHeight(30);
		btnWT.setPrefWidth(300);
		btnRD.setPrefHeight(30);
		btnRD.setPrefWidth(300);

		resultado.setEditable(false);
		resultado.setPrefHeight(60);
		resultado.setPrefWidth(300);

		painelResult.add(new Label(""), 0, 0);
		painelResult.add(new Label("Resultado:"), 0, 3);
		painelResult.add(resultado, 0, 4);

		btnPares.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(pares(vet));
			}

		});
		btnDec.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				decrescente(vet);
			}

		});
		btnGT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(maiorValor(vet));
			}

		});
		btnLS.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(menorValor(vet));
			}

		});

		btnSet.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setPos(vet);
			}

		});
		btnInv.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				inVet(vet);
			}

		});
		btnWT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				writeVet(vet);
			}

		});

		btnRD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				readVet(vet);
			}

		});
		painelPrincipal.setBottom(painelResult);
		painelPrincipal.setCenter(painelBotoes);
		Scene scn = new Scene(painelPrincipal);
		stage.setScene(scn);
		stage.setTitle("Vetor");
		stage.show();

	}

	public int pares(int[] vet) {
		String vetor = "";
		int quantidade = 0;
		for (int i = 0; i < 15; i++) {
			if (vet[i] % 2 == 0) {
				quantidade++;
				vetor += vet[i] + " ";
			}
		}
		resultado.setText(vetor);
		return quantidade;
	}

	public void decrescente(int[] vetor) {
		String result = "";
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < i; j++) {
				if (vetor[i] > vetor[j]) {
					int aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		for (int i = 0; i <= 14; i++) {
			result += vetor[i] + " ";
		}
		resultado.setText(result);
	}

	public int maiorValor(int[] vetor) {
		int maior = 0;
		int pos = 0;
		for (int i = 0; i < 15; i++) {
			if (vetor[i] > maior) {
				pos = i;
				maior = vetor[i];
			}
		}
		resultado.setText("O maior está na posição: " + Integer.toString(pos));
		return maior;
	}

	public int menorValor(int[] vetor) {
		int menor = 500;
		int pos = 0;
		for (int i = 0; i < 15; i++) {
			if (vetor[i] < menor) {
				pos = i;
				menor = vetor[i];
			}
		}
		resultado.setText("O menor está na posição: " + Integer.toString(pos));
		return menor;
	}

	public int setPos(int[] vet) {
		if (vet[8] - vet[7] > vet[7] - vet[6]) {
			resultado.setText(Integer.toString(vet[8]));
		} else {
			resultado.setText(Integer.toString(vet[6]));
		}
		return vet[7];
	}

	public void inVet(int[] vet) {
		int dir = 14, esq = 0;
		while (esq < dir) {
			int aux = vet[dir];
			vet[dir] = vet[esq];
			vet[esq] = aux;
			dir--;
			esq++;
		}
		for (int i = 0; i < 15; i++) {
			System.out.println(vet[i]);
		}

	}

	public void writeVet(int[] vet) {
		try {
			File file = new File("C:/vetor.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bWT = new BufferedWriter(new FileWriter(file));
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < 15; i++) {
				buffer.append(vet[i] + "\r\n");
			}
			bWT.write(buffer.toString());
			bWT.close();
			resultado.setText("Arquivo gravado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readVet(int[] vet) {
		try {
			File file = new File("C:/vetor.txt");
			if (!file.exists()) {
				JOptionPane.showMessageDialog(null, "Arquivo ainda não gerado");
			} else {
				@SuppressWarnings("resource")
				BufferedReader bRD = new BufferedReader(new FileReader(file));
				String linha;
				int i = 0;
				while ((linha = bRD.readLine()) != null) {
					vet[i] = Integer.parseInt(linha);
					i++;
				}
				resultado.setText("Arquivo carregado");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
