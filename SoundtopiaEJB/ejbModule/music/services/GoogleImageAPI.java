package music.services;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import music.util.EntityDecoder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class GoogleImageAPI {
	
	public static String retrieveData(String interpreter, String title) {
		return retrieveData(interpreter,title,0);
	}

	public static String retrieveData(String interpreter, String title, int index) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		String delimiter = "\"url\":\"";
		String query = interpreter + " " + title + " cover";
		int delIndex;

		WebResource webResource = client
				.resource("http://ajax.googleapis.com/ajax/services/search/images");
		
		String decodedQuery = EntityDecoder.htmlToChar(query);
		
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("v", "1.0"); //ProtocolNumber
		params.add("rsz", "1"); //Numbers of results
		params.add("start", ""+index);
		params.add("q", decodedQuery);
		
		System.out.println(index);
		
		String response = webResource.queryParams(params).accept(MediaType.TEXT_PLAIN)
				.get(String.class);
				
		delIndex = response.indexOf(delimiter)+delimiter.length();	
		String url = response.substring(delIndex, response.indexOf("\"", delIndex)).replaceAll("\\%2520", "%20");
		return url;		
	}
}