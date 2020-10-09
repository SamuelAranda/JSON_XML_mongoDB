import java.awt.List;
import java.util.ArrayList;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Conexion {

	public MongoDatabase db;
	public static MongoClient mongo = null;

	/////////////////////////////////////
	/*CONEXIÓN Y SELECCIÓN DE COLECCIÓN*/
	/////////////////////////////////////

	/*Clase para crear una conexión a MongoDB.
	 * @return MongoClient conexión
	 */
	public static MongoClient crearConexion(String host, int ip) {

		try {
			mongo = new MongoClient(host, 27017);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mongo;
	}

	//Crea o se conecta a la BBDD dada
	public boolean crearBBDD(String nombreBBDD) {
		try {
			db = mongo.getDatabase(nombreBBDD);
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	
	///////////////////////////////////////
	/*INTRODUCCIÓN DE DATOS Y COLECCIÓNES*/
	///////////////////////////////////////

	
	/*Añade datos y crea una colecion sencilla genérica (Sin colecciones dentro) en caso de que no exista
	  Si la tabla no existe o no se le asignan datos no se creará*/
	public void addTableAndData(String nombreTabla, String ... parametroValor) {
		MongoCollection<Document> table = db.getCollection(nombreTabla);
		table.insertOne(createNewSimplyDocument(parametroValor));
	}

	//Crea un documento simple
	public Document createNewSimplyDocument(String ... parametroValor) {

		Document document = new Document();

		for (int i = 0; i < parametroValor.length ; i = i+2) {	
			document.put(parametroValor[i], parametroValor[i+1]);
		}

		return document;
	}

	//Añada x cantidad de documentos a la coleccion
	public void addDocuments(String nombreTabla, Document...documents) {

		MongoCollection<Document> table = db.getCollection(nombreTabla);

		ArrayList<Document> listDocuments = new ArrayList<Document>();

		for (Document docu : documents) {
			listDocuments.add(docu);
		}

		table.insertMany(listDocuments);
	}


	//////////////
	/*CONSULTAS*/
	/////////////

	//Devuelve en un JSON el primer resultado de una busqueda en coleccion a partir de una key y un valor
	public String findDocument(String collection, String key, String value) {
		// Select the collection
		MongoCollection<Document> col = db.getCollection(collection);

		// Create the document to specify find criteria
		Document findDocument = new Document(key, value);

		// Document to store query results
		FindIterable<Document> resultDocument = col.find(findDocument);

		// Return the name of the first returned document
		return resultDocument.first().toJson();

	}

	//Devuelve un String en forma de JSON del primer documento que encuentre en la bbdd.
	public String findFirst() {
		MongoIterable<String> tables = db.listCollectionNames();

		MongoCollection<Document> col = db.getCollection(tables.first());
		FindIterable<Document> documentos = col.find();

		return documentos.first().toJson();

	}

	//Devuelve una lista (ArrayList) de String en formato JSON que cumplan las condiciones dadas
	public ArrayList<String> findList(String coleccion, String... keyValue) {

		MongoCollection<Document> collection = db.getCollection(coleccion);
		Document findDocument = new Document();
		ArrayList<String> lista = new ArrayList<>();

		for (int i= 0; i < keyValue.length; i= i+2) {
			findDocument.append(keyValue[i], keyValue[i+1]);
		}

		MongoCursor<Document> resultDocument = collection.find(findDocument).iterator();

		// Iterate over the results printing each document
		while (resultDocument.hasNext()) {
			
			lista.add(resultDocument.tryNext().toJson());
		}
		return lista;
	}

	//////////////
	/*IMPRESIÓN*/
	/////////////

	//Imprime por pantalla todas las bases de datos existentes
	public static void printDatabases() {
		MongoIterable<String> dbs = mongo.listDatabaseNames();

		for (String db : dbs) {
			System.out.println(" - " + db);
		}
	}

	//Imprime los nombres de tablas o colecciones
	public void printColecciones() {
		MongoIterable<String> tables = db.listCollectionNames();

		for(String coleccion : tables){
			System.out.println(" - " + coleccion);

		}
	}

	//Imprime todos los datos y tablas de la base de datos
	public void printAll() {
		MongoIterable<String> tables = db.listCollectionNames();

		for(String coleccion : tables){
			System.out.println("Tabla ::: " + coleccion);
			MongoCollection<Document> col = db.getCollection(coleccion);
			FindIterable<Document> documentos = col.find();

			for(Document docu : documentos){

				System.out.println(docu.toJson().toString());
			}
		}
	}
	
	
	
	/*CERRAR CONEXIÓN*/
	public void disconnect() {
		mongo.close();
	}
}