package br.com.uendel.viacep;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCepServiceTest {

    private String consultarCep(String cep) throws Exception {
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder resposta = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            resposta.append(inputLine);
        }
        in.close();
        return resposta.toString();
    }

    @Test
    public void deveRetornarDadosParaCepValido() throws Exception {
        String resposta = consultarCep("01311000");
        assertTrue(resposta.contains("Avenida Paulista"));
        assertTrue(resposta.contains("São Paulo"));
    }

    @Test
    public void deveRetornarErroParaCepInexistente() throws Exception {
        String resposta = consultarCep("00000000");
        assertTrue(resposta.contains("\"erro\""));
    }

    @Test
    public void deveRetornarErroParaCepComLetras() {
        assertThrows(Exception.class, () -> consultarCep("abcd1234"));
    }
}
