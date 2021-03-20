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
public class adminsuper {
       private ArrayList<hacksuper> listasuper= new ArrayList();
    private File archivo = null;

    public adminsuper(String path) {
        this.archivo = new File(path);
    }

    public ArrayList<hacksuper> getsuper() {
        return listasuper;
    }

    public void setAutos(ArrayList<hacksuper> autos) {
        this.listasuper = listasuper;
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
            for (hacksuper t : listasuper) {
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
        listasuper = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    listasuper.add(new hacksuper(sc.nextInt(),
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
