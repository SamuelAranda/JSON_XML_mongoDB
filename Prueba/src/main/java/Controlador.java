import java.io.IOException;

import org.w3c.dom.Document;

import com.mongodb.MongoClient;

import lecturaXMLJson.LecturaJSON;
import lecturaXMLJson.LecturaXML;

public class Controlador {

	static Conexion conexion = new Conexion();

	public static void main(String[] args) throws IOException {

		Document docu = LecturaXML.cachtXML("C:\\Users\\samuel.aranda\\Desktop\\XML\\"
				+ "MensajesenvioStandardPrueba\\MensajesenvioStandardPrueba1.xml");

		System.out.println(LecturaXML.XMLtoString(LecturaXML.cachtXML("C:\\Users\\samuel.aranda\\Desktop\\XML\\"
				+ "MensajesenvioStandardPrueba\\MensajesenvioStandardPrueba1.xml")));

		LecturaXML.cambioCampo(docu, "fecha", "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");



		/*	System.out.println("Prueba MongoDB");

		conexion.crearConexion("localhost", 27017);

		System.out.println(conexion.crearBBDD("1"));*/

//		conexion.printDatabases();
//		conexion.printColecciones();
		
		
//		conexion.addTableAndData("Espadas", "Nombre", "Espada corta", "Daño", "10");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada larga", "Daño", "15");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada ancha", "Daño", "20");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada guay", "Daño", "20");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada brehcen", "Daño", "200");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada sfsf", "Daño", "240");
//		
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza corta", "Daño", "10");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza larga", "Daño", "15");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza ancha", "Daño", "20");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza guay", "Daño", "20");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza brehcen", "Daño", "200");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza sfsf", "Daño", "240");
		
//		conexion.printAll();
		
//		System.out.println("\n ///////////////// Impresion de bbdd \n" + conexion.findFirst().toJson().toString());
		
//		System.out.println(LecturaXML.XMLtoString(LecturaXML.cachtXML("C:\\Users\\samuel.aranda\\Desktop\\XML\\MensajesenvioStandardPrueba107.xml")));
		
//		System.out.println(LecturaJSON.lecturaJSON("C:\\Users\\samuel.aranda\\Desktop\\JSON\\new.json"));
		
//		System.out.println("///////////////// Impresion de archivo");
//		System.out.println(LecturaJSON.lecturaJSON("C:\\Users\\samuel.aranda\\Desktop\\JSON\\new1.json").toJson().toString());
		
	/*	System.out.println(conexion.findList("Espadas", "Nombre", "Lanza corta", "Danio", "10"));
		System.out.println(conexion.findList("Lanzas", "Nombre", "Lanza larga").get(0));
		System.out.println(conexion.findList("Lanzas", "Nombre", "Lanza larga").get(1));
		
//		
		System.out.println(LecturaJSON.compareJSON(conexion.findList("Lanzas", "Nombre", "Lanza corta").get(0), LecturaJSON.lecturaJSON("C:\\Users\\samuel.aranda\\Desktop\\JSON\\new.json")));
		System.out.println(LecturaJSON.compareJSON(conexion.findList("Lanzas", "Nombre", "Lanza corta").get(0), LecturaJSON.lecturaJSON("C:\\Users\\samuel.aranda\\Desktop\\JSON\\new1.json")));
//
		conexion.disconnect();
		*/
		
		
	}
}
