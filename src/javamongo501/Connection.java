package javamongo501;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.BasicDBObject;

/**
 *
 * @author Jorge Luis Gómez Rangel
 */
public class Connection {  
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Connection(){
        Mongo mongo = new Mongo("localhost",27017);
        BaseDatos = mongo.getDB("Actividades504");
        coleccion = BaseDatos.getCollection("Actividades501");
        System.out.println("Conexion Exitosa");
    }
    
    //METODOS CRUD
    //INSERTAR
    public boolean Insertar(String accion){
        document.put("accion", accion);
        coleccion.insert(document);
        return true;
    }
    
    //MOSTRAR
    public void Mostrar(){
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    //ACTUALIZAR
    public boolean Actualizar(String accionVieja, String accionNueva){
        document.put("accionNueva", accionNueva);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("accion",accionNueva);
        coleccion.findAndModify(document, documentoNuevo);
        return true;
    }
    
    //ELIMINAR
    public boolean Eliminar(String accion){
        document.put("accion", accion);
        coleccion.remove(document);
        return true;
    }
    
}
