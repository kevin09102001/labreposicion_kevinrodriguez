/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labreposicion_kevinrodriguez;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class adminregular {
    private ArrayList<regular> listaregular = new ArrayList();
    private File archivo = null;

    public adminregular(String path) {
        this.archivo = new File(path);
    }

    public ArrayList<regular> getregular() {
        return listaregular;
    }

    public void setAutos(ArrayList<regular> autos) {
        this.listaregular = listaregular;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    

    //metodos de administracion
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
             for (regular t : listaregular) {
                bw.write(t.getCodigo()+ ";");
                bw.write(t.getNivel()+ ";");
                bw.write(t.getNum()+ ";");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
 
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaregular = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    listaregular.add(new regular(sc.nextInt(),
                            sc.nextInt(),
                            sc.nextInt()
                    )
                    );
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
}
