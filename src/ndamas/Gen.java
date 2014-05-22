/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ndamas;

/**
 *
 * @author Juan
 */
public class Gen {

    private int posicionX, posicionY;

    public Gen(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;

    }

    public void setX(int posicion) {
        posicionX = posicion;
    }

    public int getX() {
        return posicionX;
    }

    public void setY(int posicion) {
        posicionY = posicion;
    }

    public int getY() {
        return posicionY;
    }
}
