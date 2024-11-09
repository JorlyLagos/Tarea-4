//Hecho por: Jorly Lagos
//cuenta: 202320110265

import java.util.ArrayList;
import java.util.Scanner;

class Empleado {
    private String nombre;
    private int edad;
    private double salario;


    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

   
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salario: $" + salario);
        System.out.println("--------------------------");
    }
}


class GestorEmpleados {
   
    private final ArrayList<Empleado> listaEmpleados;

    
    public GestorEmpleados() {
        listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
        System.out.println("Empleado agregado con exito.");
    }

    
    public void mostrarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : listaEmpleados) {
                empleado.mostrarInformacion();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        GestorEmpleados gestor = new GestorEmpleados();
        
        try (Scanner scanner = new Scanner(System.in)) {
           
            
            System.out.println("Sistema de Gestion de Empleados");
            boolean continuar = true;
            
            while (continuar) {
                System.out.println("\n1. Agregar empleado");
                System.out.println("2. Mostrar empleados");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opcion: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcion) {
                    case 1 -> {
                        
                        System.out.print("Ingrese el nombre del empleado: ");
                        String nombre = scanner.nextLine();
                        
                        System.out.print("Ingrese la edad del empleado: ");
                        int edad = scanner.nextInt();
                        
                        System.out.print("Ingrese el salario del empleado: ");
                        double salario = scanner.nextDouble();
                        scanner.nextLine(); 
                        
                        Empleado nuevoEmpleado = new Empleado(nombre, edad, salario);
                        gestor.agregarEmpleado(nuevoEmpleado);
                    }
                        
                    case 2 -> {
                        
                        System.out.println("\nLista de Empleados:");
                        gestor.mostrarEmpleados();
                    }
                        
                    case 3 -> {
                        
                        continuar = false;
                        System.out.println("Saliendo del sistema...");
                    }
                        
                    default -> System.out.println("Opcion no valida. Intente nuevamente.");
                }
            }
        }
    }
}