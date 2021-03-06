/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamabanquero;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Sagasjan
 */
public class Logica {
        public static int need[][];
        public static int allocated_resources[][];
        public static int max[][];
        public static int available_resources[][];
        public static int num_processes;
        public static int num_resources;
        public static int order[];
        public static String sucursales[];
        
        public static void obtenerDatos() {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Por favor ingrese el número de sucursales => ");
	
	num_processes = scanner.nextInt(); // no. of process
	System.out.print("Por favor ingrese el número de categorías => ");

	num_resources = scanner.nextInt(); // no. of resources

	// Inicialización de arreglos
	need = new int[num_processes][num_resources];
	max = new int[num_processes][num_resources];
	allocated_resources = new int[num_processes][num_resources];
	available_resources = new int[1][num_resources];

	// Creación de matriz de empleados requeridos
	System.out.println("Por favor introduce la matriz de empleados requeridos en cada sucursal en cada una de sus categorías =>");
	for (int i = 0; i < num_processes; i++) {
		System.out.println("Row " + (i + 1) + " (P" + i + "): ");
		for (int j = 0; j < num_resources; j++) {
			max[i][j] = scanner.nextInt(); // max matrix
		}
	}

        // Creación de matriz de empleados iniciales
	System.out.println("Por favor introduce la matriz de empleados inicales en cada categoría al abrir la sucursal =>");
	for (int i = 0; i < num_processes; i++) {
		System.out.println("Row " + (i + 1) + " (P" + i + "): ");
		for (int j = 0; j < num_resources; j++) {
			allocated_resources[i][j] = scanner.nextInt(); // allocation matrix
		}
	}

	// Get available matrix input
	System.out.println("Por favor la cantidad requerida de empleados en cada categoría =>");
	for (int j = 0; j < num_resources; j++)
		available_resources[0][j] = scanner.nextInt(); // available matrix
		
	scanner.close();

	// Display matrices
        System.out.println("\nMatriz de empleados requeridos en cada categoría =>");
	printArray(max);
        System.out.println("\nMatriz de empleados asignados en cada sucursal actualmente =>");
	printArray(allocated_resources);
	System.out.println("\nMatriz resultante =>");
	//printArray(calc_need());
        }
	
        public static void printArray(int[][] array) {
	for (int i = 0; i < array.length; i++) {
		System.out.println("");
		for (int j = 0; j < array[0].length; j++) {
			System.out.print(array[i][j] + " ");
		}
	}
	System.out.println("");
        }

	//
	public static int[][] calc_need(int procesos, int recursos) {
		for (int i = 0; i < procesos; i++)
			for (int j = 0; j < recursos; j++)
				// calculating need matrix
				need[i][j] = max[i][j] - allocated_resources[i][j];
		return need;
	}

	public static boolean check_allocatable(int i) {
		// checking if all resources for ith process can be allocated
		for (int j = 0; j < num_resources; j++)
			if (available_resources[0][j] < need[i][j])
			return false;
		return true;
	}

	public void revisarInterbloqueo(int procesos, int recursos) {
		//obtenerDatos();
		//calc_need();
		boolean done[] = new boolean[procesos];
                order = new int[procesos];
		int j = 0;

		while (j < procesos) { // until all process allocated
		boolean allocated = false;
                    for (int i = 0; i < procesos; i++)
                            if (!done[i] && check_allocatable(i)) { // trying to allocate

                                    for (int k = 0; k < recursos; k++)
                                            available_resources[0][k] = available_resources[0][k] - need[i][k] + max[i][k];
                                    System.out.println("Sucursal procesada: " + i);
                                    order[i] = i;
                                    allocated = done[i] = true;
                                    j++;
                            }
                            if (!allocated) // no allocation
                                break;
		}
		if (j == procesos) // all processes are allocated
			JOptionPane.showMessageDialog(null,"¡EXISTE ESTADO SEGURO!","Aviso!", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"DEADLOCK","Aviso!", JOptionPane.ERROR_MESSAGE);
	}
        public void imprimirEnInterfaz(JTextArea area, int [][] matriz) {
            String text = "\n" + "\n" + "\n";
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    text += "\t" + matriz[i][j];
                }
                text += "\t" + "\n";
            }
            area.setText(text);
        }
        
        public void imprimirArray(JTextArea area,int[]vector ,String[]vector2) {
            String text = "\n" + "\n" + "\n";
            for (int i = 0; i < vector.length; i++) {
                text += "\t" + vector[i];
            }
            text += "\n" + "\n" + "Leyenda: ";
            for (int i = 0; i < vector2.length; i++) {
                text +=   "\n" + i + vector2[i];
            }
            area.setText(text);
        }
        
        public void imprimirSucursales(int sucursales, String[] imprimir) {
            if (sucursales == 6) {
                imprimir[0] = "Excelsior Gama Macaracuay";
                imprimir[1] = "Excelsior Gama Vizcaya";
                imprimir[2] = "Excelsior Gama Las Mercedes";
                imprimir[3] = "Excelsior Gama Santa Paula";
                imprimir[4] = "Excelsior Gama Chuao";
                imprimir[5] = "Excelsior Gama Caurimare";
            }
            else if (sucursales >= 6) {
                imprimir[0] = "Excelsior Gama Macaracuay";
                imprimir[1] = "Excelsior Gama Vizcaya";
                imprimir[2] = "Excelsior Gama Las Mercedes";
                imprimir[3] = "Excelsior Gama Santa Paula";
                imprimir[4] = "Excelsior Gama Chuao";
                imprimir[5] = "Excelsior Gama Caurimare";
                for (int i = 6; i < sucursales; i++) {
                    String aux = JOptionPane.showInputDialog("Introducir nombre de la sucursal # " + (i+1) + " (P" + i + ")");
                    imprimir[i] = aux; 
                }
            }
            }
        }
