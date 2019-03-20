package parser;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.parameters.seedTemplate.SeedTemplate;

public class SeedTemplateParser {
	public static SeedTemplate parseSeedTemplate(String file){
		ObjectMapper mapper = new ObjectMapper();
		SeedTemplate seed = null;
		try {
			//SeedTemplate seed = mapper.readValue(new File("Documents/DecreasingSeedTemplate.json"), SeedTemplate.class);
			seed = mapper.readValue(new File(file), SeedTemplate.class);
			System.out.println(seed);
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
		return seed;
	}
}
