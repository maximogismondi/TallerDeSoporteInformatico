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
        valores=obtenerInformacionSolicitada();
        return new ResponseEntity<>(valores,HttpStatus.OK);
    }

    @RequestMapping(value = "/datos/json",method = RequestMethod.GET)
    public ResponseEntity<Object> enviarDatosJson(){/*RELLENAR*/
        return new ResponseEntity<>(this.archivoCSV.obtenerArchivoJson(),HttpStatus.OK);
    }

    public ArrayList<OrdenDeCompra> obtenerListaDeOrdenesDeCompra(){

        ArrayList<OrdenDeCompra> sociosList= new ArrayList<>();
        Iterator<String[]> iterador = archivoCSV.obtenerIterador();

        while (iterador.hasNext()){

            String[] fila = iterador.next();

             String fecha=fila[0];
             String numero_oc=fila[1];
             String provedorfila=fila[2];
             String importenEnArs=fila[3];
             String objeto=fila[4];
             String tipoDeProcedimiento=fila[5];


             OrdenDeCompra ordenDeCompra= new OrdenDeCompra(fecha,numero_oc,provedorfila,importenEnArs,objeto,tipoDeProcedimiento);


            sociosList.add(ordenDeCompra);

        }

        return sociosList;
    }


    public HashMap<String,Object> obtenerInformacionSolicitada(){

        HashMap<String,Object> informacion = new HashMap<>();

        informacion.put("cantidadTotalDeOrdenesDeCompra",this.obtenerListaDeOrdenesDeCompra());

        return informacion;
    }

}

