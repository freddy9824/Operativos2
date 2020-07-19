/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamabanquero;

import java.util.Scanner;

import Interfaz.CategoriaSucursal;

/**
 *
 * @author Sagasjan
 */
public class GamaBanquero {

    public static void main(String[] args) {
        Logica logica = new Logica();
        CategoriaSucursal categoriaSucursal = new CategoriaSucursal(logica);
    }
}
