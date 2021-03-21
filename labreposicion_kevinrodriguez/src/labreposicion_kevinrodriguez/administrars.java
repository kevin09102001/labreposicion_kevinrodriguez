/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labreposicion_kevinrodriguez;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Kevin
 */
public class administrars extends Thread {

    Random a = new Random();
    int z = 1 + a.nextInt(10);
    public int aa, cant;
    private JProgressBar progBar_t;
    private boolean avanzar;
    private boolean vive;

    public administrars(int cant, int aa, JProgressBar progBar_t) {
        this.cant = cant;
        this.aa = aa;
        this.progBar_t = progBar_t;
        avanzar = true;
        vive = true;
    }

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    public JProgressBar getProgBar_t() {
        return progBar_t;
    }

    public void setProgBar_t(JProgressBar progBar_t) {
        this.progBar_t = progBar_t;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }
    int g = (cant * aa) ;

    @Override
    public void run() {
        while (vive) {
            if (avanzar) {
                if (z == aa) {
                    JOptionPane.showMessageDialog(null, "los numero son iguales por lo tanto el hack es fallido");
                } else {
                    progBar_t.setValue(progBar_t.getValue() + 1);
                    try {
                        Thread.sleep(g);
                    } catch (InterruptedException ex) {

                    }
                }

            }
        }
    }
}
