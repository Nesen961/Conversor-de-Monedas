import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class BusquedaDeCotizaciones{



    public Transaccion busqueda (String monedaBase, String otraMoneda){

        String url_str = "https://v6.exchangerate-api.com/v6/1c8257e2bb4cf73e89063693/pair/"+monedaBase+"/"+otraMoneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new Gson();
            ExChTransaccion exTran1 = gson.fromJson(json, ExChTransaccion.class);
            return new Transaccion(exTran1);

        }catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

