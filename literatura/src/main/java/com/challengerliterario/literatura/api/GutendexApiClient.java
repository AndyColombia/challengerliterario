package com.challengerliterario.literatura.api;

import com.challengerliterario.literatura.model.Libro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Libro> buscarLibros(String query) {
        try {
            String url = "https://gutendex.com/books?search=" + query;
            String jsonResponse = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);
            JsonNode results = root.get("results");

            List<Libro> libros = new ArrayList<>();
            for (JsonNode node : results) {
                Libro libro = new Libro();
                libro.setTitulo(node.get("title").asText());
                libro.setAutores(node.get("authors").toString());
                libro.setDescripcion(node.has("subjects") ? node.get("subjects").toString() : "Sin descripción");
                libros.add(libro);
            }
            return libros;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}