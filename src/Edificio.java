// Definición de la clase Edificio
class Edificio {
    private String[] departamentos; // Array para almacenar los nombres de los residentes de los departamentos

    // Constructor de la clase Edificio
    public Edificio(int numeroDepartamentos) {
        if (numeroDepartamentos <= 0) {
            throw new IllegalArgumentException("El número de departamentos debe ser mayor que cero");
        }
        departamentos = new String[numeroDepartamentos]; // Inicializa el arreglo con el tamaño especificado
    }

    // Método para reservar un departamento
    public void reservarDepartamento(int numeroDepartamento, String residente) {
        if (numeroDepartamento < 0 || numeroDepartamento >= departamentos.length) {
            throw new ArrayIndexOutOfBoundsException("Número de departamento inválido");
        }
        if (departamentos[numeroDepartamento] != null) {
            throw new IllegalStateException("El departamento ya está reservado");
        }
        departamentos[numeroDepartamento] = residente; // Asigna el nombre del residente al departamento
    }

    // Método para verificar el residente de un departamento
    public String verificarDepartamento(int numeroDepartamento) {
        if (numeroDepartamento < 0 || numeroDepartamento >= departamentos.length) {
            throw new ArrayIndexOutOfBoundsException("Número de departamento inválido");
        }
        return departamentos[numeroDepartamento]; // Retorna el nombre del residente del departamento
    }
}

