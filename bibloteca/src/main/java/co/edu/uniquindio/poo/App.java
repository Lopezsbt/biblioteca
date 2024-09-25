package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.Libro;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    // Listas para almacenar bibliotecarios, estudiantes, libros y préstamos
    private static List<Bibliotecario> bibliotecarios = new ArrayList<>();
    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static List<Libro> libros = new ArrayList<>();
    private static List<Prestamo> prestamos = new ArrayList<>();
    
    public static void main(String[] args) {
        // Crear un bibliotecario
        crearBibliotecario("Juan Perez", "123456789", "555-1234", "juan@gmail.com", 3000);
        // Crear un estudiante
        crearEstudiante("Ana Gomez", "987654321", "555-5678", "ana@gmail.com");
        // Crear un libro
        crearLibro("001", "978-3-16-148410-0", "Autor 1", "memorias de un hijueputa", "Editorial 1", "2023-01-01", 5);
        
        // Consultar un libro por su código
        Libro libro = consultarLibroPorCodigo("023");
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro.getTitulo());
        }
        
        // Crear un nuevo libro y reemplazar el existente
        Libro nuevoLibro = new Libro("023", "978-3-16-148410-0", "Autor 2", "Paraiso ver", "Editorial 2", "2024-01-01", 10);
        reemplazarLibro("001", nuevoLibro);
        
        // Crear una lista de libros para el préstamo
        List<Libro> librosPrestamo = new ArrayList<>();
        librosPrestamo.add(libro);
        // Crear un préstam
        crearPrestamo("P001", estudiantes.get(0), librosPrestamo, LocalDate.now());
        // Entregar el préstamo y calcular el costo
        long costo = entregarPrestamo("P001", LocalDate.now());
        System.out.println("Costo del préstamo: " + costo);
    }
    
    // Método para crear y añadir un bibliotecario a la lista
    public static void crearBibliotecario(String nombre, String cedula, String telefono, String correo, double salario) {
        Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, telefono, correo, salario);
        bibliotecarios.add(bibliotecario);
    }
    
    // Método para crear y añadir un estudiante a la lista
    public static void crearEstudiante(String nombre, String cedula, String telefono, String correo) {
        Estudiante estudiante = new Estudiante(nombre, cedula, telefono, correo);
        estudiantes.add(estudiante);
    }
    // Método para crear y añadir un libro a la lista
    public static void crearLibro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, int unidadesDisponibles) {
        Libro libro = new Libro(codigo, isbn, autor, titulo, editorial, fecha, unidadesDisponibles);
        libros.add(libro);
    }
    // Método para consultar un libro por su código
    public static Libro consultarLibroPorCodigo(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null;
    }
    // Método para reemplazar un libro existente por uno nuevo
    public static boolean reemplazarLibro(String codigo, Libro nuevoLibro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getCodigo().equals(codigo)) {
                libros.set(i, nuevoLibro);
                return true;
            }
        }
        return false;
    }
    // Método para crear un préstamo y actualizar las unidades de los libros prestados
    public static void crearPrestamo(String codigo, Estudiante estudiante, List<Libro> libros, LocalDate fechaPrestamo) {
        Prestamo prestamo = new Prestamo(codigo, estudiante, libros, fechaPrestamo);
        prestamos.add(prestamo);
        for (Libro libro : libros) {
            libro.actualizarUnidades(2);
            libro.registrarPrestamo();
        }
    }
    // Método para entregar un préstamo, actualizar las cantidADES DE LOS LIBROS Y CALCULAR EL COSTO
    public static long entregarPrestamo(String codigo, LocalDate fechaEntrega) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamo.setFechaEntrega(fechaEntrega);
                long costo = prestamo.calcularCosto();
                for (Libro libro : prestamo.getLibros()) {
                    libro.actualizarUnidades(1);
                }
                return costo;
            }
        }
        return 0;
    }
}
