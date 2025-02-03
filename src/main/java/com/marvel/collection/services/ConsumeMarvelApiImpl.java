package com.marvel.collection.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsumeMarvelApiImpl implements ConsumeMarvelApi {

     @Value("${api_marvel}")
    private String api_marvel;

    @Override
    public String getAllCharacters(String apiKey) throws URISyntaxException, IOException, InterruptedException  {
        String url = api_marvel + "/characters?" + apiKey;
        return generateRequest(url);
    }

    @Override
    public String getCharacterById(String apiKey, int id) throws URISyntaxException, IOException, InterruptedException {
        String url = api_marvel + "/characters/" + id + "?" + apiKey;
        return generateRequest(url);
    }

    public String generateRequest(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .GET()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> response;
		try {
			response = client.send(request, BodyHandlers.ofString());
            String responseBody = response.body();
            return responseBody;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
            System.out.println("httpGetRequest status code: " + e.toString());
		}
        return "";
    }
}
