package lecturaXMLJson;

import java.io.FileReader;
import java.io.IOException;

import org.bson.Document;

import com.google.gson.Gson;

public class LecturaJSON {

	public static Document lecturaJSON(String path) throws IOException {

		Gson gson = new Gson();

		Document object = gson.fromJson(new FileReader(path), Document.class);
		
		return object;

	}
	
	public static Boolean compareJSON(String json, Document json1) {
		
		if (json.equals(json1.toJson())) return true;
		
		return false;
	}
	
	
}
