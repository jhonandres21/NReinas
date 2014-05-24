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
        //Para el método contadorOcurrencias el parametro 0 significa que va a revisar la componente x
        //el parametro 1 significa que va a revisar la componente y
        System.out.println("Número de ataques Columnas: " + contadorOcurrencias(valoresX, 0));
        System.out.println("Número de ataques Filas: " + contadorOcurrencias(valoresY, 1));
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

    private int contadorOcurrencias(ArrayList arreglo, int valor) {

        int contadorInterno = 0;
        int contadorGeneral = 0;
        int componente = 0;

        for (int i = 0; i < arreglo.size(); i++) {
            for (int j = 0; j < reinas; j++) {

                if (valor == 0) {
                    componente = cromosoma.get(j).getX();
                } else if (valor == 1) {
                    componente = cromosoma.get(j).getY();
                }

                if (arreglo.get(i) == componente) {
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
