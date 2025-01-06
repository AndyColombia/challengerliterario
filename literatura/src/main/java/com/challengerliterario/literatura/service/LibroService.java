package com.challengerliterario.literatura.service;


import com.challengerliterario.literatura.api.GutendexApiClient;
import com.challengerliterario.literatura.model.Libro;
import com.challengerliterario.literatura.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final GutendexApiClient apiClient;
    private final LibroRepository repository;

    public LibroService(GutendexApiClient apiClient, LibroRepository repository) {
        this.apiClient = apiClient;
        this.repository = repository;
    }

    public List<Libro> buscarLibros(String query) {
        return apiClient.buscarLibros(query);
    }
}