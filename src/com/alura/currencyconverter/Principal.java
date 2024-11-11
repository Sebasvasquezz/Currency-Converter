package com.alura.currencyconverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

/**
 * Main class for the Currency Converter application, allowing users to convert currency
 * values based on real-time exchange rates obtained from an external API.
 */
public class Principal {
    /**
     * Main method for running the Currency Converter application.
     * It prompts the user to select a currency pair, enter the amount to be converted,
     * and then displays the converted value.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        var API_KEY = "41dad1394ee8f5c5392d528e";
        while (true){
            System.out.println("***************************************************************");
            System.out.println("Bienvenido al Conversor de moneda.");
            System.out.println("1. Dólar =>> Peso argentino.");
            System.out.println("2. Peso argentino =>> Dólar.");
            System.out.println("3. Dólar =>> Real brasileño.");
            System.out.println("4. Real brasileño =>> Dólar.");
            System.out.println("5. Dólar =>> Peso colombiano.");
            System.out.println("6. Peso colombiano =>> Dólar.");
            System.out.println("7. Ingresar las siglas de las monedas.");
            System.out.println("8. Salir");
            System.out.println("Eliga una las siguientes opciones (1-8):");

            int opcion = lectura.nextInt();
            lectura.nextLine();
            if (opcion == 8) {
                System.out.println("Saliendo del Conversor de moneda. ¡Hasta luego!");
                break;
            }
            String initialCurrency = switch (opcion) {
                case 2 -> "ARS";
                case 4 -> "BRL";
                case 6 -> "COP";
                default -> "USD";
            };
            String finalCurrency = switch (opcion) {
                case 1 -> "ARS";
                case 3 -> "BRL";
                case 5 -> "COP";
                default -> "USD";
            };

            if (opcion == 7) {
                System.out.println("Sigla de la moneda inicial:");
                initialCurrency = lectura.nextLine();
                System.out.println("Sigla de la moneda final:");
                finalCurrency = lectura.nextLine();
            }
            System.out.println("Ingrese el valor a convertir:");
            double value = lectura.nextDouble();

            String url = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, initialCurrency);

            try {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                double finalValue = calculateRate(json,gson,finalCurrency) * value;
                System.out.printf("El valor de %.2f [%s] corresponde al valor final de %.2f [%s].%n", value, initialCurrency, finalValue, finalCurrency);
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la direccion: ");
                System.out.println(e.getMessage());
            } catch (IOException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * Helper method to calculate the conversion rate for the target currency.
     *
     * @param json the JSON response string from the exchange rate API
     * @param gson Gson instance for JSON parsing
     * @param finalCurrency the ISO code of the target currency
     * @return the conversion rate from the base currency to the target currency
     */
    private static double calculateRate(String json, Gson gson, String finalCurrency){
        ExchangeRateResponse exchangeRateResponse = gson.fromJson(json, ExchangeRateResponse.class);
        return exchangeRateResponse.conversion_rates().get(finalCurrency);
    }
}
