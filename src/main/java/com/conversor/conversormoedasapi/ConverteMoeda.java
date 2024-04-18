package com.conversor.conversormoedasapi;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConverteMoeda {
    private static final String API_KEY = "1a7de532dc7b4185dd14bcca";
    public static void convert(String fromCurrency, String toCurrency) {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + fromCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = inputReader.readLine()) != null) {
                response.append(line);
            }
            inputReader.close();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);
            double exchangeRate = jsonObject.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();

            System.out.println("Informe o valor em " + fromCurrency + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            double amount = Double.parseDouble(reader.readLine());

            double convertedAmount = amount * exchangeRate;
            System.out.println(amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}