package com.marvel.collection.services;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ConsumeMarvelApi {
    public void getAllCharacters();
    public void getCharacterById(int id)  throws URISyntaxException, IOException, InterruptedException ;
}
