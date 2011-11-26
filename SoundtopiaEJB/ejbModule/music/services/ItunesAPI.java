package music.services;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import music.util.JSONException;
import music.util.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ItunesAPI {
	
	public static void main(String[] args) {
		retrieveData("");
	}
	
	/**
	 * 
	 * @param query e.g. "Lady Gaga Poker Face"
	 * @return
	 */
	public static String retrieveData(String query) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		WebResource webResource = client
				.resource("http://itunes.apple.com/search");
		
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", query);
		params.add("country", "DE");
		params.add("limit", "1");
		params.add("entity", "musicTrack");
		
		String response = webResource.queryParams(params).accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		
		try {
			JSONObject json = new JSONObject(response).getJSONArray("results").getJSONObject(0);
			System.out.println(json.getString("trackPrice"));
			System.out.println(response);			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return response;	
	}
}
