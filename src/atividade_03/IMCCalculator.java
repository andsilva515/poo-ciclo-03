package atividade_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame {
	private JTextField pesoField;
	private JTextField alturaField;
	private JTextArea resultadoArea;

	public IMCCalculator() {
		setTitle("Calculadora de IMC");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Panel principal 
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,2));
		
		// Componentes da interface
		JLabel pesoLabel = new JLabel("Peso (Kg):");
		pesoField = new JTextField();
		
		JLabel alturaLabel = new JLabel("Altura (Cm):");
		alturaField = new JTextField();
		
		JButton calcularButton = new JButton("Calcular IMC");
		calcularButton.addActionListener(new CalcularIMCActionListener());
		
		resultadoArea = new JTextArea();
		resultadoArea.setEditable(false);
		
		// Adicionando componentes ao painel
		panel.add(pesoLabel);
		panel.add(pesoField);
		panel.add(alturaLabel);
		panel.add(alturaField);
		panel.add(new JLabel("")); // Espaço  em branco
		panel.add(calcularButton);
		panel.add(new JLabel("")); // Espaço em branco
		panel.add(resultadoArea);
		
		// Adicionando o painel à janela
		add(panel);
	}
		
		private class CalcularIMCActionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double peso = Double.parseDouble(pesoField.getText());
					double alturaCm = Double.parseDouble(alturaField.getText());
					double alturaM = alturaCm / 100; // Converter cm para metros
					double imc = peso / (alturaM * alturaM);
					
					String classificacao;
					if (imc < 18.5) {
						classificacao = "Abaixo do peso";						
					} else if (imc < 24.9) {
						classificacao = "Peso normal";
					} else if (imc < 29.9) {
						classificacao = "Sobrepeso";
					} else {
						classificacao = "Obesidade";
					}
					
					resultadoArea.setText(String.format("IMC: %.2f\nClassificação: %s", imc, classificacao));
				} catch (NumberFormatException ex) {
					resultadoArea.setText("Por favor, insira valores válidos para peso e altura.");
				}
			}
		}
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(() -> {
				IMCCalculator frame = new IMCCalculator();
				frame.setVisible(true);
			});
		}
	}

