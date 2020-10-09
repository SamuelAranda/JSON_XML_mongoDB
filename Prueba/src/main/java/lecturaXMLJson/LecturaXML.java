package lecturaXMLJson;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import net.bytebuddy.dynamic.scaffold.MethodGraph.NodeList;

public class LecturaXML {

	public static void main(String[] args) {

		try {

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public static Document cachtXML(String path) {

		try {
			// Creo una instancia de DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			// Creo un documentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Obtengo el documento, a partir del XML
			Document documento = builder.parse(new File(path));

			return documento;
		} catch (Exception e) {
			return null;
		}
	}


	public static String XMLtoString(Document doc) {

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tf.newTransformer();

			StringWriter writer = new StringWriter();

			transformer.transform(new DOMSource(doc), new StreamResult(writer));

			String xmlString = writer.getBuffer().toString();   
			return xmlString;
		} 
		catch (TransformerException e) 
		{
			e.printStackTrace();
		}

		return "";
	}

	
	public static String cambioCampo(Document doc, String campo, String cambio) {
		
		String nuevoXML = "";
		String xml = XMLtoString(doc);
		
		String[] completo = xml.split("\"");
		
		for (int i = 0; i < completo.length; i++) {
			nuevoXML += completo[i] + "\"";
			if (completo[i].contains(campo)) {
				nuevoXML += cambio + "\"";
				i++;
			}
		}
		
		System.out.println(nuevoXML);
		
		return null;
	}


}
