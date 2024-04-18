package com.conversor.conversormoedasapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConversorMain {
    public static void main(String[] args) {
        ConverteMoeda converteMoeda = new ConverteMoeda();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Converter de USD para EUR");
                System.out.println("2. Converter de EUR para USD");
                System.out.println("3. Converter de USD para GBP");
                System.out.println("4. Converter de GBP para USD");
                System.out.println("5. Converter de EUR para GBP");
                System.out.println("6. Converter de GBP para EUR");
                System.out.println("7. Converter de USD para BRL");
                System.out.println("8. Converter de BRL para USD");
                System.out.println("0. Sair");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        converteMoeda.convert("USD", "EUR");
                        break;
                    case "2":
                        converteMoeda.convert("EUR", "USD");
                        break;
                    case "3":
                        converteMoeda.convert("USD", "GBP");
                        break;
                    case "4":
                        converteMoeda.convert("GBP", "USD");
                        break;
                    case "5":
                        converteMoeda.convert("EUR", "GBP");
                        break;
                    case "6":
                        converteMoeda.convert("GBP", "EUR");
                        break;
                    case "7":
                        converteMoeda.convert("USD", "BRL");
                        break;
                    case "8":
                        converteMoeda.convert("BRL", "USD");
                        break;
                    case "0":
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
