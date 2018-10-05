/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.Coches;

/**
 *
 * @author aitor
 */
public class Gestioa {

    static FileReader lectura = null;
    static BufferedReader br = null;

    //  
    public static ArrayList<Coches> cargarDatos() {

        try {
            //Strima irekitzen dugu.
            lectura = new FileReader("Coches.txt");
            br = new BufferedReader(lectura);
            String aux;
            String[] arrString;
            ArrayList<Coches> car = new ArrayList();
            while ((aux = br.readLine()) != null) {
                if (!"".equals(aux)) {
                    arrString = aux.split(",");
                    car.add(new Coches(arrString[0], arrString[1], arrString[2], arrString[3]));
                }
            }
            br.close();
            return car;
        } catch (FileNotFoundException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Artxiboa ez da aurkitu.");
            error.showAndWait();
            return null;
        } catch (IOException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Errorea egon da irakurketan.");
            error.showAndWait();
            return null;
        }
        
        
    }

}
