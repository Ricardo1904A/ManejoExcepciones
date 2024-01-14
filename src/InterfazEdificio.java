import java.util.Scanner;

// Definición de la clase InterfazEdificio
class InterfazEdificio {
    private Edificio edificio; // Instancia de la clase Edificio
    private Scanner scanner;   // Objeto para la entrada de datos

    // Constructor de la clase InterfazEdificio
    public InterfazEdificio() {
        scanner = new Scanner(System.in); // Inicializa el scanner para la entrada de datos
    }

    // Método para iniciar la interfaz
    public void iniciar() {
        try {
            System.out.println("Ingrese el número de departamentos del edificio:");
            int numDepartamentos = scanner.nextInt();
            edificio = new Edificio(numDepartamentos); // Crea una instancia de la clase Edificio

            while (true) {
                System.out.println("\nElija una opción:");
                System.out.println("1. Reservar departamento");
                System.out.println("2. Verificar departamento");
                System.out.println("3. Salir");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        reservarDepartamento(); // Llama al método para reservar un departamento
                        break;
                    case 2:
                        verificarDepartamento(); // Llama al método para verificar el residente de un departamento
                        break;
                    case 3:
                        System.out.println("Saliendo del programa.");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Captura y muestra un mensaje de error si se lanza una IllegalArgumentException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error de índice: " + e.getMessage()); // Captura y muestra un mensaje de error si se lanza una ArrayIndexOutOfBoundsException
        } catch (IllegalStateException e) {
            System.out.println("Error de estado: " + e.getMessage()); // Captura y muestra un mensaje de error si se lanza una IllegalStateException
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage()); // Captura y muestra un mensaje de error para cualquier otra excepción no manejada
        } finally {
            if (scanner != null) {
                scanner.close(); // Cierra el objeto Scanner en cualquier caso, asegurando la liberación de recursos
            }
            System.out.println("Proceso de reservación finalizado."); // Muestra un mensaje de finalización del proceso
        }

    }


    // Método para reservar un departamento (solicitando número de departamento y nombre del residente)
    private void reservarDepartamento() {
        System.out.println("Ingrese el número de departamento que desea reservar:");
        int numeroDepartamento = scanner.nextInt();
        scanner.nextLine(); // Consume la línea en blanco después del número

        System.out.println("Ingrese el nombre del residente:");
        String residente = scanner.nextLine();

        try {
            edificio.reservarDepartamento(numeroDepartamento, residente); // Llama al método de la clase Edificio
            System.out.println("Departamento reservado con éxito.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error de índice: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error de estado: " + e.getMessage());
        }
    }

    // Método para verificar el residente de un departamento (solicitando número de departamento)
    private void verificarDepartamento() {
        System.out.println("Ingrese el número de departamento que desea verificar:");
        int numeroDepartamento = scanner.nextInt();

        try {
            String residente = edificio.verificarDepartamento(numeroDepartamento); // Llama al método de la clase Edificio
            if (residente != null) {
                System.out.println("Residente del departamento " + numeroDepartamento + ": " + residente);
            } else {
                System.out.println("El departamento " + numeroDepartamento + " no está reservado.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error de índice: " + e.getMessage());
        }
    }
}