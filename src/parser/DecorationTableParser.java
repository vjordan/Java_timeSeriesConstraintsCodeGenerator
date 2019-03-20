package parser;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.parameters.decorationTable.DecorationTable;


public class DecorationTableParser {
	public static DecorationTable parseDecorationTable(String file){
		ObjectMapper mapper = new ObjectMapper();
		DecorationTable table = null;
		try {
			//DecorationTable table = mapper.readValue(new File("Documents/FootprintDecorationTable.json"), DecorationTable.class);
			table = mapper.readValue(new File(file), DecorationTable.class);
			System.out.println(table);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}
}
