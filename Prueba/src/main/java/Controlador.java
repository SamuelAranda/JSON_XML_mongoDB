import java.io.IOException;

import org.w3c.dom.Document;

import com.mongodb.MongoClient;

import lecturaXMLJson.LecturaJSON;
import lecturaXMLJson.LecturaXML;

public class Controlador {

	static Conexion conexion = new Conexion();

	public static void main(String[] args) throws IOException {

		Document docu = LecturaXML.cachtXML("C:\\Users\\samuel.aranda\\Desktop\\Proyecto Minerva\\XML\\"
				+ "MensajesenvioStandardPrueba\\MensajesenvioStandardPrueba1.xml");

		System.out.println(LecturaXML.XMLtoString(LecturaXML.cachtXML("C:\\Users\\samuel.aranda\\Desktop\\Proyecto Minerva\\XML\\"
				+ "MensajesenvioStandardPrueba\\MensajesenvioStandardPrueba1.xml")));

		LecturaXML.cambioCampo(docu, "fecha", "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");



		/*	System.out.println("Prueba MongoDB");

		conexion.crearConexion("localhost", 27017);

		System.out.println(conexion.crearBBDD("1"));*/

//		conexion.printDatabases();
//		conexion.printColecciones();
		
		
//		conexion.addTableAndData("Espadas", "Nombre", "Espada corta", "Da�o", "10");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada larga", "Da�o", "15");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada ancha", "Da�o", "20");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada guay", "Da�o", "20");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada brehcen", "Da�o", "200");
//		conexion.addTableAndData("Espadas", "Nombre", "Espada sfsf", "Da�o", "240");
//		
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza corta", "Da�o", "10");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza larga", "Da�o", "15");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza ancha", "Da�o", "20");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza guay", "Da�o", "20");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza brehcen", "Da�o", "200");
//		conexion.addTableAndData("Lanzas", "Nombre", "Lanza sfsf", "Da�o", "240");
		
//		conexion.printAll();
		
//		System.out.println("\n ///////////////// Impresion de bbdd \n" + conexion.findFirst().toJson().toString());
		
//		System.out.println(LecturaXML.XMLtoString(LecturaXML.cachtXML("C:\\Users\\samuel.aranda\\Desktop\\Proyecto Minerva\\XML\\MensajesenvioStandardPrueba107.xml")));
		
//		System.out.println(LecturaJSON.lecturaJSON("C:\\Users\\samuel.aranda\\Desktop\\Proyecto Minerva\\JSON\\new.json"));
		
//		System.out.println("///////////////// Impresion de archivo");
//		System.out.println(LecturaJSON.lecturaJSON("C:\\Users\\samuel.aranda\\Desktop\\Proyecto Minerva\\JSON\\new1.json").toJson().toString());
		
	/*	System.out.println(conexion.findList("Espadas", "Nombre", "Lanza corta", "Danio", "10"));
		System.out.println(conexion.findList("Lanzas", "Nombre", "Lanza larga").get(0));
		System.out.println(conexion.findList("Lanzas", "Nombre", "Lanza larga").get(1));
		
//		
		System.out.println(LecturaJSON.compareJSON(conexion.findList("Lanzas", "Nombre", "Lanza corta").get(0), LecturaJSON.lecturaJSON("C:\\Users\\samuel.aranda\\Desktop\\Proyecto Minerva\\JSON\\new.json")));
		System.out.println(LecturaJSON.compareJSON(conexion.findList("Lanzas", "Nombre", "Lanza corta").get(0), LecturaJSON.lecturaJSON("C:\\Users\\samuel.aranda\\Desktop\\Proyecto Minerva\\JSON\\new1.json")));
//
		conexion.disconnect();
		*/
		
		
	}
}
