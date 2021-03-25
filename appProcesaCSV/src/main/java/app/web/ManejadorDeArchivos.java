package app.web;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Service
public class ManejadorDeArchivos {

    private String ubicacionArchivo;
    private String nombreDeArchivo;
    private char separador;

    public ManejadorDeArchivos() {
        this.ubicacionArchivo = "src/main/resources/files/";
        this.separador = ',';
    }

    public CSVParser formatearSeparador(){
        CSVParserBuilder comaBuilder = new CSVParserBuilder();
        comaBuilder = comaBuilder.withSeparator(separador);
        CSVParser parser = comaBuilder.build();
        return parser;
    }

    public FileReader obtenerArchivoCSV(){
        FileReader reader = null;
        try {
            reader = new FileReader(ubicacionArchivo + "dataset_testeo_turismo.csv");
        } catch (FileNotFoundException e) {
            String mensaje = "Archivo no encontrado, verifique el nombre y/o la ubicaión del mismo";
            System.out.println(mensaje);
            e.printStackTrace();
        }
        return reader;
    }

    public FileReader obtenerArchivoJSON(){
        FileReader reader = null;
        try {
            reader = new FileReader(ubicacionArchivo + "municipios.json");
        } catch (FileNotFoundException e) {
            String mensaje = "Archivo no encontrado, verifique el nombre y/o la ubicaión del mismo";
            System.out.println(mensaje);
            e.printStackTrace();
        }
        return reader;
    }

    public CSVReader obtenerArchivoFormateado(){
        FileReader fileReader = this.obtenerArchivoCSV();
        CSVReaderBuilder readerBuilder = new CSVReaderBuilder(fileReader);
        CSVParser separadorFormateado = this.formatearSeparador();
        readerBuilder = readerBuilder.withCSVParser(separadorFormateado);
        CSVReader reader = readerBuilder.build();
        return reader;
    }


    public JSONObject obtenerArchivoJson(){
        JSONParser parser = new JSONParser();
        FileReader fileReader = this.obtenerArchivoJSON();

        try
        {
            Object object = parser.parse(fileReader);

            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;

            return jsonObject;


        }
        catch(FileNotFoundException fe)
        {
            System.out.println(fe);

        }
        catch(Exception e)
        {
            System.out.println(e);

        }
        return null;
    }


    public Iterator<String[]> obtenerIterador(){
        CSVReader reader = this.obtenerArchivoFormateado();
        Iterator<String[]> iterador = reader.iterator();
        return iterador;
    }

}
