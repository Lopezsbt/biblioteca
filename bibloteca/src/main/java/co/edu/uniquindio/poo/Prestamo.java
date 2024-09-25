package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Prestamo {
    private String codigo;
    private Estudiante estudiante;
    private List<Libro> libros;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    
    public Prestamo(String codigo, Estudiante estudiante, List<Libro> libros, LocalDate fechaPrestamo) {
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.libros = libros;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = null;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public long calcularCosto() {
        if (this.fechaEntrega != null) {
            long diasPrestamo = ChronoUnit.DAYS.between(this.fechaPrestamo, this.fechaEntrega);
            return diasPrestamo * 1000;  // Ejemplo de costo por día
        }
        return 0;
   }
    
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
}
    
      

