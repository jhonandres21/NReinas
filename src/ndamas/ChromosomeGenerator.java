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

        ArrayList valoresX = new ArrayList();
        ArrayList valoresY = new ArrayList();


        for (int x = 0; x < reinas; x++) {
            //revisando Columnas iguales -> se atacan 
            if (!contieneComponente(valoresX, cromosoma.get(x).getX())) {

                valoresX.add(cromosoma.get(x).getX());
            }
            //revisando Filas iguales -> se atacan 
            if (!contieneComponente(valoresY, cromosoma.get(x).getY())) {

                valoresY.add(cromosoma.get(x).getY());
            }
        }
        //imprimirArreglo(valores);
        System.out.println("Número de ataques Columnas: " + contadorOcurrenciasX(valoresX));
        System.out.println("Número de ataques Filas: " + contadorOcurrenciasY(valoresY));
    }

    //para revisar si son iguales en la componente X o Y
    private boolean contieneComponente(ArrayList arreglo, int componente) {

        boolean contenido = false;

        for (int i = 0; i < arreglo.size(); i++) {

            if (arreglo.get(i) == componente) {
                return true;
            }
        }
        return contenido;
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

    private int contadorOcurrenciasX(ArrayList arreglo) {

        int contadorInterno = 0;
        int contadorGeneral = 0;

        for (int i = 0; i < arreglo.size(); i++) {
            for (int j = 0; j < reinas; j++) {

                if (arreglo.get(i) == cromosoma.get(j).getX()) {
                    contadorInterno += 1;
                }
            }

            if (contadorInterno > 1) {
                contadorGeneral += contadorInterno;
            }
            contadorInterno = 0;
        }

        return contadorGeneral;
    }

    private int contadorOcurrenciasY(ArrayList arreglo) {

        int contadorInterno = 0;
        int contadorGeneral = 0;

        for (int i = 0; i < arreglo.size(); i++) {
            for (int j = 0; j < reinas; j++) {

                if (arreglo.get(i) == cromosoma.get(j).getY()) {
                    contadorInterno += 1;
                }
            }

            if (contadorInterno > 1) {
                contadorGeneral += contadorInterno;
            }
            contadorInterno = 0;
        }

        return contadorGeneral;
    }
//    private void imprimirArreglo(ArrayList arreglo) {
//
//        for (int i = 0; i < arreglo.size(); i++) {
//            System.out.print(arreglo.get(i) + " ");
//        }
//        System.out.println();
//    }
}
