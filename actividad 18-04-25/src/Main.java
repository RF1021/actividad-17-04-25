import java.util.*;
public class Main {
    static List<Persona> personas = new ArrayList<>();
    static List<Perro> perrosDisponibles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("""
                            --- MENÚ DE ADOPCIÓN DE PERROS ---
                            1. Registrar persona
                            2. Registrar perro
                            3. Ver personas registradas
                            4. Ver perros disponibles
                            5. Adoptar perro
                            6. Consultar perro más viejo adoptado
                            7. Salir
                            Seleccione una opción
                            """);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarPersona();
                case 2 -> registrarPerro();
                case 3 -> mostrarPersonas();
                case 4 -> mostrarPerros();
                case 5 -> adoptarPerro();
                case 6 -> consultarPerroMasViejo();
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    static void registrarPersona() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Documento: ");
        String doc = sc.nextLine();
        personas.add(new Persona(nombre, apellido, edad, doc));
        System.out.println("Persona registrada.");
    }

    static void registrarPerro() {
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Raza: ");
        String raza = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Tamaño: ");
        String tamano = sc.nextLine();
        perrosDisponibles.add(new Perro(placa, nombre, raza, edad, tamano));
        System.out.println("Perro registrado.");
    }

    static Persona buscarPersonaPorDocumento(String doc) {
        for (Persona p : personas) {
            if (p.getDocumento().equals(doc)) {
                return p;
            }
        }
        return null;
    }

    static Perro buscarPerroPorPlaca(String placa) {
        for (Perro p : perrosDisponibles) {
            if (p.getPlaca().equals(placa)) {
                return p;
            }
        }
        return null;
    }

    static void adoptarPerro() {
        System.out.print("Documento de la persona: ");
        String doc = sc.nextLine();
        Persona persona = buscarPersonaPorDocumento(doc);
        if (persona == null) {
            System.out.println("Persona no encontrada.");
            return;
        }
        System.out.print("Placa del perro a adoptar: ");
        String placa = sc.nextLine();
        Perro perro = buscarPerroPorPlaca(placa);
        if (perro == null) {
            System.out.println("Perro no disponible.");
            return;
        }
        if (persona.adoptarPerro(perro)) {
            perrosDisponibles.remove(perro);
            System.out.println("Adopción realizada.");
        } else {
            System.out.println("La persona ya tiene 3 perros.");
        }
    }

    static void consultarPerroMasViejo() {
        System.out.print("Documento de la persona: ");
        String doc = sc.nextLine();
        Persona persona = buscarPersonaPorDocumento(doc);
        if (persona == null) {
            System.out.println("Persona no encontrada.");
            return;
        }
        Perro viejo = persona.perroMasGrande();
        if (viejo != null) {
            System.out.println("El perro más viejo adoptado:");
            viejo.mostrarInformacion();
        } else {
            System.out.println("La persona no ha adoptado perros.");
        }
    }

    static void mostrarPersonas() {
        for (Persona p : personas) {
            p.mostrarInformacion();
        }
    }

    static void mostrarPerros() {
        for (Perro p : perrosDisponibles) {
            p.mostrarInformacion();
        }
    }
}