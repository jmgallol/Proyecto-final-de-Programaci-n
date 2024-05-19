/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.narvasoft.gui;

/**
 *
 * @author USER
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Archivos {
    public static void Escribirtxt(ArrayList<Jugadores> jugadores){
        try {
           
           String contenido=ExtraerInfo(jugadores);
           
          // Se Crea un BufferedWriter para poder mejorar la eficiencia
            BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(System.getProperty("user.dir")+"//src//main//java//com//narvasoft//gui//resources//Archivo.txt"));

            // Esto se hace para poder escribir el contenido en el archivo
            bufferedWriter.write(contenido);

            // Se Cierra el BufferedWriter
            bufferedWriter.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static String ExtraerInfo(ArrayList<Jugadores> jugadores){
       String info="!Lista de jugadores! \n";
       
       for(int i=0;i<jugadores.size();i++){
           info=info+"\n"+
           "Id: "+jugadores.get(i).getId()+"\n"+
           "Nombre: "+jugadores.get(i).getNombre()+"\n"+
           "Juego Favorito: "+jugadores.get(i).getJuegoFavorito()+"\n"+
           "Level: "+jugadores.get(i).getLevel()+"\n"+
           "Max Score: "+jugadores.get(i).getMaxScore()+"\n"+
                   "-----------------------------";
        }
       return info;
    }
    public static void Mostrar_mensaje(){
        JOptionPane.showMessageDialog(null, "Archivo.txt generado correctamente", "Archivo", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
