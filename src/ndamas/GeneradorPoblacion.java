/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ndamas;

import java.util.ArrayList;

/**
 *
 * @author pipe
 */
public class GeneradorPoblacion {

    private int PoblacionInicial;
    private ChromosomeGenerator Cromosoma;
    private ArrayList<ArrayList<Gen>> poblacion = new ArrayList<ArrayList<Gen>>();

    public GeneradorPoblacion(int poblacionInicial, int reinas) {
        this.PoblacionInicial = poblacionInicial;
        this.Cromosoma = new ChromosomeGenerator(reinas);
        this.poblacion.add(Cromosoma.obtenerCromosoma());
        chromosomeGenerator(reinas);
    }

    public ArrayList obtenerPoblacion() {
        return poblacion;
    }

    private void chromosomeGenerator(int reinas) {

        int contador = 0;
        while (contador < PoblacionInicial - 1) {

            ChromosomeGenerator cromosomaNuevo = new ChromosomeGenerator(reinas);

            if (!existeCromosoma(cromosomaNuevo)) {
                this.poblacion.add(cromosomaNuevo.obtenerCromosoma());
                contador++;
            }

        }

    }

    private boolean existeCromosoma(ChromosomeGenerator cromosoma) {

        int noRepeticiones = 0;
        ArrayList<Gen> cromosomaNuevoAuxiliar = cromosoma.obtenerCromosoma();;
        ArrayList<Gen> cromosomaAntiguoAuxiliar;
        for (int i = 0; i < this.poblacion.size(); i++) {

            cromosomaAntiguoAuxiliar = poblacion.get(i);

            for (int j = 0; j < cromosomaNuevoAuxiliar.size(); j++) {

                if (!contiene(cromosomaAntiguoAuxiliar, cromosomaNuevoAuxiliar.get(j))) {

                    noRepeticiones++;
                    break;

                }

            }

        }

        if (noRepeticiones == (poblacion.size())) {
            return false;
        } else {
            return true;
        }
    }

    private boolean contiene(ArrayList<Gen> cromosomaEntrada, Gen gen) {

        for (int i = 0; i < cromosomaEntrada.size(); i++) {

            if (cromosomaEntrada.get(i).getX() == gen.getX() && cromosomaEntrada.get(i).getY() == gen.getY()) {

                return true;
            }
        }
        return false;
    }

}
