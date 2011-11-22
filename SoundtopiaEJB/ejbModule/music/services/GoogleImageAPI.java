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

	public static String retrieveData(String query) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		String delimiter = "\"url\":\"";
		int delIndex;

		WebResource webResource = client
				.resource("http://ajax.googleapis.com/ajax/services/search/images");
		
		String decodedQuery = EntityDecoder.htmlToChar(query);
		
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("v", "1.0");
		params.add("q", decodedQuery);
		//System.out.println(decodedQuery);
		
		String response = webResource.queryParams(params).accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		
		delIndex = response.indexOf(delimiter)+delimiter.length();
		
		String url = response.substring(delIndex, response.indexOf("\"", delIndex));
		return url;
		
	}
}

/*
 * try { JSONObject json = new JSONObject(sr); System.out.println("SR: " + sr);
 * JSONObject jO = json.getJSONObject("response").getJSONObject("myvideo"
 * ).getJSONObject("movie_list"); // for(int i = 0; i < jArray.length(); i++) {
 * // System.out.println(jArray.get(i)); // } System.out.println(jO);
 * System.out.println(jO.get("resultCount")); } catch (JSONException e) {
 * e.printStackTrace(); }
 */

