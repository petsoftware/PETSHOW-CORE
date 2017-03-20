package br.com.petshow.util;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import br.com.petshow.model.Entidade;

public class JsonUtil {
	
	public static String getJSON(Object entidade) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(entidade);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static <T> T  transformObject(String json,Class<T> type) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		T  objeto = mapper.readValue(json, type);
        return objeto;
	}
	
	/*  public static <T> List<T> jsonToList(T instanceClass,String json,Class clazz) throws Exception
	    {
	        List<T> list;
	        ObjectMapper mapper = new ObjectMapper();

	        TypeFactory t = TypeFactory.defaultInstance();
	        list = mapper.readValue(json, t.constructCollectionType(ArrayList.class,clazz));

	        return list;
	    }*/
	
}
