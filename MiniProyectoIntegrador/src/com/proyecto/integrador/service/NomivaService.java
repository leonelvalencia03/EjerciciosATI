package com.proyecto.integrador.service;

import com.proyecto.integrador.model.Empleado;
import java.util.ArrayList;
import java.util.List;
import com.proyecto.integrador.util.ScannerUtil;

public class NomivaService implements Gestionable {
    private List<Empleado> empleados;

    public NomivaService() {
        this.empleados = new ArrayList<>();
    }

    @Override
    public void agregar() {
        agregarEmpleado();
    }

    public void agregarEmpleado() {
        String nombre = ScannerUtil.leerString("Ingrese el nombre del empleado: ");
        String apellido = ScannerUtil.leerString("Ingrese el apellido del empleado: ");
        String identificacion = ScannerUtil.leerString("Ingrese la identificación del empleado: ");
        double salario = ScannerUtil.leerDouble("Ingrese el salario del empleado: ");
        Empleado empleado = new Empleado(nombre, apellido, identificacion, "", salario);
        empleados.add(empleado);
        System.out.println("Empleado agregado exitosamente.");
    }

    @Override
    public void buscar() {
        buscarEmpleado();
    }

    public void buscarEmpleado() {
        String identificacion = ScannerUtil.leerString("Ingrese la identificación del empleado a buscar: ");
        for (Empleado emp : empleados) {
            if (emp.getIdentificacion().equals(identificacion)) {
                System.out.println("Empleado encontrado: " + emp.getNombre() + " " + emp.getApellido() + ", Salario: " + emp.getSalario());
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    @Override
    public void eliminar() {
        eliminarEmpleado();
    }

    public void eliminarEmpleado() {
        String identificacion = ScannerUtil.leerString("Ingrese la identificación del empleado a eliminar: ");
        for (Empleado emp : empleados) {
            if (emp.getIdentificacion().equals(identificacion)) {
                empleados.remove(emp);
                System.out.println("Empleado eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    @Override
    public void listar() {
        listarEmpleados();
    }

    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("Lista de empleados:");
        for (Empleado emp : empleados) {
            System.out.println(emp.getNombre() + " " + emp.getApellido() + ", Identificación: " + emp.getIdentificacion() + ", Salario: " + emp.getSalario());
        }
    }
}
