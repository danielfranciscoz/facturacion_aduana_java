/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaReflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author W4LT3R
 */
public class ListStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> cadenas = new ArrayList<>();
        cadenas.add("Walter");
        cadenas.add("Andrea");
        cadenas.add("Hamilton");
        cadenas.add("William");
        cadenas.add("Jorge");
        cadenas.add("Daysis");
        cadenas.add("Darwing");

        cadenas.stream()
                .filter(nombre -> nombre.equals("Walter"))
                .forEach((nombre) -> {
                    System.out.println(nombre);
                    if ("Walter".equals(nombre)) {
                        System.out.println("Encontrado...");
                    }
                });

        cadenas.stream().forEach((nombre) -> {
            System.out.println(nombre);
            if ("Walter".equals(nombre)) {
                System.out.println("Encontrado...");
//                cadenas.stream().close();
                return;
            }
        });
    
       
    }

}

