package com.marvel.multiservice.collection;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.marvel.collection.services.ConsumeMarvelApiImpl;

public class CollectionApplicationTests {

	ConsumeMarvelApiImpl marvelApi;
	String params = "ts=1738323598&apikey=ed007838a03ee42ca50f05c3c8788e5c&hash=9a7a9f9a7da148022988a42d7497aa88";

	@BeforeEach
    void setup() {
        marvelApi = new ConsumeMarvelApiImpl();
		marvelApi.api_marvel = "https://gateway.marvel.com/v1/public";
    }

	@Test
	void testFindAllCharacters() throws URISyntaxException, IOException, InterruptedException {
		String json = marvelApi.getAllCharacters(params);
		DocumentContext documentContext = JsonPath.parse(json);
		assertEquals(documentContext.read("$.code").toString(), "200");
	}

	@Test
	void testFindCharacterById() throws URISyntaxException, IOException, InterruptedException {
		String json = marvelApi.getCharacterById(params, 1011334);
		DocumentContext documentContext = JsonPath.parse(json);
		assertEquals(documentContext.read("$.code").toString(), "200");
	}
}