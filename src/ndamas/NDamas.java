/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ndamas;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class NDamas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TODO lo que está comentado lo hizo pipe, por ahora lo comento
        //Ahora lo descomento para acomodar las comparaciones de los cromosomas
        //int poblacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la poblacion inicial:"));
        int reinas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de reinas:"));

        //GeneradorPoblacion gp = new GeneradorPoblacion(poblacion, reinas);
        //ArrayList <ArrayList<Gen>> cromosomas = gp.obtenerPoblacion();

        //Comento lo que hizo Jhon para hacer mis pruebas
        ChromosomeGenerator cg = new ChromosomeGenerator(reinas);
        cg.revisarAtaques();
        ArrayList<Gen> cromosomas = (cg.obtenerCromosoma());

        for (int j = 0; j < cromosomas.size(); j++) {
            //for (int i = 0; i < reinas; i++) {

                //System.out.println("El cromosoma:" + j + " Posición X: " + cromosomas.get(j).get(i).getX() + "Posición Y: " + cromosomas.get(j).get(i).getY());
                System.out.println("Posición X: " + cromosomas.get(j).getX() + " Posición Y: " + cromosomas.get(j).getY());
            //}
        }

    }
}
