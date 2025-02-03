package com.marvel.collection.services;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ConsumeMarvelApi {
    public String getAllCharacters(String apiKey) throws URISyntaxException, IOException, InterruptedException;
    public String getCharacterById(String apiKey, int id)  throws URISyntaxException, IOException, InterruptedException;
}
