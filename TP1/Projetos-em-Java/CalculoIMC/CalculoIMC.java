/*
The MIT License (MIT)

Copyright (c) 2016 Wolfgang Almeida <wolfgang.almeida@yahoo.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculoIMC {

	public static String classificarIMC(double imc) {
		if (imc < 18.5) {
			return "Baixo Peso";
		}
		else if (imc >= 18.5 && imc < 24.9) {
			return "Peso Normal";
		}
		else if (imc >= 25.0 && imc < 29.9) {
			return "Sobrepeso";
		}
		else if (imc >= 30.0 && imc < 34.9) {
			return "Obesidade Grau I";
		}
		else if (imc >= 35.0 && imc < 39.9) {
			return "Obesidade Grau II";
		}
		else {
			return "Obesidade Grau III";
		}
	}

	public static double calcularIMC(double peso, double altura) {
		return peso / (altura * altura);
	}

	public static void programaIMC(String versao) {
		Scanner scanner = new Scanner(System.in);
		double peso = 0, altura = 0;

		System.out.println("===========================");
		System.out.printf("Cálculo do IMC - Versão %s\n", versao);
		System.out.println("===========================");

		//Captura e faz a validação do peso
		while(true){
			try{
				System.out.print("Insira o seu peso em quilogramas (O peso deve ser maior que 0kg e menor que 500kg): ");
				peso = scanner.nextDouble();

				if(peso <= 0 || peso > 500){
					System.out.println("Erro: O peso deve estar entre 0kg e 500kg");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida! Por favor, insira um número válido.");
				scanner.next();
			}
		}

		//Captura e faz a validação da altura
		while (true) {
			try {
				System.out.print("Insira a sua altura em metros (A altura deve ser de no mínimo 0,5m e no máximo 3,5m): ");
				altura = scanner.nextDouble();

				if (altura < 0.5 || altura > 3.5) {
					System.out.println("Erro: A altura deve estar entre 0.5 e 3.5 metros.");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida! Por favor, insira um número válido.");
				scanner.next();
			}
		}

		//Calculo do IMC
		double imc = calcularIMC(peso, altura);
		String classificacao = classificarIMC(imc);

		//Exibição do resultado
		System.out.printf("\nSeu índice de massa corporal é: %.2f kg/m²\n", imc);
		System.out.printf("Classificação: %s.\n", classificacao);

		scanner.close();

	}

	public static void main(String[] args) {
		String versao = "2.0";
		programaIMC(versao);
	}
}
