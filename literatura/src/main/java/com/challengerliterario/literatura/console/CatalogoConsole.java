package com.challengerliterario.literatura.console;

import com.challengerliterario.literatura.model.Libro;
import com.challengerliterario.literatura.service.LibroService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CatalogoConsole {

    private final LibroService servicio;

    public CatalogoConsole(LibroService servicio) {
        this.servicio = servicio;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Catálogo de Libros");

        while (true) {
            System.out.println("\nElija una opción:");
            System.out.println("1. Buscar libros");
            System.out.println("2. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el término de búsqueda:");
                    String query = scanner.nextLine();
                    List<Libro> resultado = servicio.buscarLibros(query);

                    if (resultado.isEmpty()) {
                        System.out.println("No se encontraron libros para el término de búsqueda: " + query);
                    } else {
                        System.out.println("Resultados de la búsqueda:");
                        for (Libro libro : resultado) {
                            System.out.println("Título: " + libro.getTitulo());
                            System.out.println("Autores: " + libro.getAutores());
                            System.out.println("Descripción: " + libro.getDescripcion());
                            System.out.println("---------------------------------");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Gracias por usar el catálogo. ¡Hasta pronto!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
}