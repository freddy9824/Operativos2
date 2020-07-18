/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamabanquero;

import java.util.Scanner;

import Interfaz.CategoriaSucursal;
import Interfaz.Empleados;

/**
 *
 * @author Sagasjan
 */
public class GamaBanquero {

    public static void main(String[] args) {
        Lógica logica = new Lógica();
        CategoriaSucursal categoriaSucursal = new CategoriaSucursal();
        
        logica.revisarInterbloqueo();
    }
}
