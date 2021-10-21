package app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class Controlador {



    @Autowired
    private ManejadorDeArchivos archivoCSV;



    public Controlador() {
        this.archivoCSV = new ManejadorDeArchivos();
    }


    @GetMapping("/")
    public String index() {
        return "inicio";
    }



    @RequestMapping(value = "/datos/csv",method = RequestMethod.GET)
    public ResponseEntity<Object> enviarDatosCSV(){
        HashMap<String,Object> valores = new HashMap<>();
        valores.put("Testeos",obtenerTesteos());
        return new ResponseEntity<>(valores,HttpStatus.OK);
    }

    @RequestMapping(value = "/datos/json",method = RequestMethod.GET)
    public ResponseEntity<Object> enviarDatosJson(){
        return new ResponseEntity<>(this.archivoCSV.obtenerArchivoJson(),HttpStatus.OK);
    }

    public ArrayList<Testeo> obtenerTesteos(){

        ArrayList<Testeo> listaTesteos = new ArrayList<>();
        Iterator<String[]> iterador = archivoCSV.obtenerIterador();

        while (iterador.hasNext()){

            String[] fila = iterador.next();

            String fecha_muestra = fila[0];
            String tipo = fila[1];
            String dispositivo = fila[2];
            String genero = fila[3];
            String grupo_etario = fila[4];
            String n = fila[5];


            Testeo testeo= new Testeo(fecha_muestra,tipo,dispositivo,genero,grupo_etario,n);

            listaTesteos.add(testeo);

        }

        return listaTesteos;
    }
}

