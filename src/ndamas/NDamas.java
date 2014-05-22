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
        int reinas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de reinas:"));

        ChromosomeGenerator cg = new ChromosomeGenerator(reinas);

        ArrayList<Gen> cromosoma = (cg.obtenerCromosoma());

        for (int i = 0; i < reinas; i++) {
            System.out.println("Posición X: " + cromosoma.get(i).getX() + "Posición Y: " + cromosoma.get(i).getY());
        }

    }

}
