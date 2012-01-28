package music.services;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import music.data.ValueObject.PriceVO;
import music.util.json.JSONException;
import music.util.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ItunesAPI {
	private final static int queryCount = 3;

	private ItunesAPI() {

	}

	public static PriceVO getPrice(String interpreter, String title) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		PriceVO price;

		WebResource webResource = client.resource("http://itunes.apple.com/search");

		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", interpreter + " " + title);
		params.add("country", "DE");
		params.add("limit", "" + queryCount);
		params.add("entity", "musicTrack");

		String response = webResource.queryParams(params).accept(MediaType.TEXT_PLAIN).get(String.class);

		try {
			JSONObject json;
			boolean found = false;
			price = null;
			for (int i = 0; i < queryCount && !found; i++) {
				json = new JSONObject(response).getJSONArray("results").getJSONObject(i);
				price = new PriceVO();
				price.setValue(Float.valueOf(json.getString("trackPrice")));
				price.setUrl(json.getString("trackViewUrl"));
				price.setProvider("iTunes");
				price.setCurrency("€");
				if (price.getValue() > 0)
					found = true;
			}
			if (!found)
				return null; // TODO throw exception
			else
				return price;

		} catch (JSONException e) {
			e.printStackTrace();
			// System.out.println("Preis von " + query + ": " + "null");

			return null;
		}
	}
}
