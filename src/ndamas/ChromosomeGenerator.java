/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ndamas;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class ChromosomeGenerator {

    int reinas;
    private ArrayList<Gen> cromosoma = new ArrayList();

    public ChromosomeGenerator(int reinas) {
        this.reinas = reinas;
        GeneGenerator();
    }
    
    public ArrayList obtenerCromosoma(){
        return cromosoma;
    }

    private void GeneGenerator() {

        int contador = 0;
        while(contador < reinas) {
            int posicionX = posicionGenerator();
            int posicionY = posicionGenerator();

            Gen gen = new Gen(posicionX, posicionY);

            //yo creo que este contains no funciona =D, tocaría comparar elemento por elemento (posiciones) del gen
            if (!cromosoma.contains(gen)) {
                cromosoma.add(gen);
                contador++;
            }

        }

    }

    private int posicionGenerator() {

        int posicion = (int) (Math.random() * reinas);

        return posicion;
    }

}
