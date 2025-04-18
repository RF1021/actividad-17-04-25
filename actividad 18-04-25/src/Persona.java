import java.util.*;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;
    private List<Perro> perrosAdoptados = new ArrayList<>();

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public String getDocumento() { return documento; }

    public boolean adoptarPerro(Perro perro) {
        if (perrosAdoptados.size() < 3) {
            perrosAdoptados.add(perro);
            return true;
        }
        return false;
    }

    public Perro perroMasGrande() {
        Perro mayor = null;
        for (Perro p : perrosAdoptados) {
            if (mayor == null || p.getEdad() > mayor.getEdad()) {
                mayor = p;
            }
        }
        return mayor;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellido + ", Edad: " + edad + ", Documento: " + documento);
        System.out.println("Perros adoptados:");
        if (perrosAdoptados.size() == 0) {
            System.out.println("  Ninguno");
        } else {
            for (Perro p : perrosAdoptados) {
                p.mostrarInformacion();
            }
        }
    }
}