package br.com.uendel.viacep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaViaCEP {
    public static void main(String[] args) throws Exception {
        String cep = "01311000";
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("Resposta retornada pela API: " + response.toString());
    }
}
