package com.marvel.collection.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Service;

@Service
//@EnableConfigurationProperties(ServiceProperties.class)
public class ConsumeMarvelApiImpl implements ConsumeMarvelApi {

    @Override
    public void getAllCharacters() {
        // throw new UnsupportedOperationException("Unimplemented method 'getAllCharacters'");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .GET()
            .uri(URI.create(""))
            .build();
        HttpResponse<String> response;
		try {
			response = client.send(request, BodyHandlers.ofString());
            String responseBody = response.body();
            int responseStatusCode = response.statusCode();
            System.out.println("httpGetRequest status code: " + responseStatusCode);

            System.out.println("httpGetRequest: " + responseBody);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
            System.out.println("httpGetRequest status code: " + e.toString());
		}
    
        System.out.println("Se llama desde getAllCharacters");
    }

    @Override
    public void getCharacterById(int id) throws URISyntaxException, IOException, InterruptedException {
        //throw new UnsupportedOperationException("Unimplemented method 'getCharacterById'");
        System.out.println("Se llama desde getCharacterById");
    }
    
}
