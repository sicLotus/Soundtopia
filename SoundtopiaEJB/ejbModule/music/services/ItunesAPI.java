package music.services;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import music.data.PriceVO;
import music.util.JSONException;
import music.util.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ItunesAPI {
	final static int queryCount = 3;

	public static void main(String[] args) {
		retrieveData("Tim Bendzko Wenn Worte meine Sprache wären song");
	}

	/**
	 * @param query
	 *            e.g. "Lady Gaga Poker Face"
	 */
	public static PriceVO retrieveData(String query) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		PriceVO price;

		WebResource webResource = client
				.resource("http://itunes.apple.com/search");

		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("term", query);
		params.add("country", "DE");
		params.add("limit", "" + queryCount);
		params.add("entity", "musicTrack");

		String response = webResource.queryParams(params)
				.accept(MediaType.TEXT_PLAIN).get(String.class);

		try {
			JSONObject json;
			int i = 0;
			do {
				json = new JSONObject(response).getJSONArray("results")
						.getJSONObject(i);
				price = new PriceVO();
				price.setValue(Float.valueOf(json.getString("trackPrice")));
				price.setUrl(json.getString("trackViewUrl"));
				price.setProvider("iTunes");
				price.setCurrency("€");
				//System.out.println("Preis von " + query + ": "
				//		+ price.getValue());
				if (price.getValue() < 0) {
					i++;
				//	System.out.println(response);
				}
				else
					i = queryCount; // HACK! HAHA
			} while (i < queryCount);
		} catch (JSONException e) {
			// e.printStackTrace();
			//System.out.println("Preis von " + query + ": " + "null");

			return null;
		}
		return price;
	}
}
