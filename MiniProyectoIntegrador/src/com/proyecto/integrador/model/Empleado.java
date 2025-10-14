package com.proyecto.integrador.model;

public class Empleado extends Persona {
    private double salario;

    public Empleado(String nombre, String apellido, String identificacion, String puesto, double salario) {
        super(nombre, apellido, identificacion);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Método adicional específico de Empleado
     */
    public double calcularSalarioAnual() {
        return salario * 12;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase padre
        System.out.println("Salario mensual: $" + salario);
        System.out.println("Salario anual: $" + calcularSalarioAnual());
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", salario=" + salario +
                '}';
    }
}
