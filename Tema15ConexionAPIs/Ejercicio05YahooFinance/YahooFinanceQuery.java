package Tema15ConexionAPIs.Ejercicio05YahooFinance;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class YahooFinanceQuery {
    public static void main(String[] args) throws IOException, InterruptedException {


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete?region=ES&q=Atresmedia"))
                .header("x-rapidapi-key", "e58bfdc933mshe352fc96c09bc9ep1d6dbbjsn5c2fa2bcc70f")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
