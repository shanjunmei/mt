package test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

	public static void main(String[] args) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xd", 'd');
		map.put("current", new Date());
		System.out.println("source:" + map);
		ObjectMapper mapper = new ObjectMapper();
		String x = mapper.writeValueAsString(map);
		System.out.println("se :" + x);
		Map<String, Object> rx = mapper.readValue(x, Map.class);
		System.out.println("de :" + rx);
	}

}
