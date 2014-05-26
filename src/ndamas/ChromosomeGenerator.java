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

    public ArrayList obtenerCromosoma() {
        return cromosoma;
    }

    private void GeneGenerator() {

        int contador = 0;
        while (contador < reinas) {
            int posicionX = posicionGenerator();
            int posicionY = posicionGenerator();

            Gen gen = new Gen(posicionX, posicionY);

            if (!contenido(cromosoma, gen)) {

                //yo creo que este contains no funciona =D, tocaría comparar elemento por elemento (posiciones) del gen
                if (!cromosoma.contains(gen)) {

                    cromosoma.add(gen);
                    contador++;
                }
            }
        }
    }

    private int posicionGenerator() {

        int posicion = (int) (Math.random() * reinas);
        return posicion;
    }

    public void revisarAtaques() {

        int ataquesColumnas = 0;

        for (int i = 0; i < reinas; i++) {
            //revisando Columnas iguales -> se atacan 
            if (contadorOcurrenciasX(cromosoma.get(i).getX(), i)) {
                ataquesColumnas++;
            }
        }

        System.out.println("Ataques columnas: " + ataquesColumnas);

    }

    private boolean contenido(ArrayList<Gen> cromosomaEntrada, Gen gen) {

        boolean contenido = false;

        for (int i = 0; i < cromosomaEntrada.size(); i++) {

            if (cromosomaEntrada.get(i).getX() == gen.getX() && cromosomaEntrada.get(i).getY() == gen.getY()) {
                return true;
            }
        }
        return contenido;
    }

    private boolean contadorOcurrenciasX(int valor, int indice) {

        for (int i = 0; i < reinas; i++) {

            int valorArreglo = cromosoma.get(i).getX();

            if (valorArreglo == valor && i != indice) {
                return true;
            }
        }
        return false;
    }
//    private void imprimirArreglo(ArrayList arreglo) {
//
//        for (int i = 0; i < arreglo.size(); i++) {
//            System.out.print(arreglo.get(i) + " ");
//        }
//        System.out.println();
//    }
}
