package music.services;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import music.data.PriceVO;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class SevenDigitalsAPI {
	
	public static void main(String[] args) {
		//retrieveData("");
	}

	@SuppressWarnings("rawtypes")
	/**
	 * 
	 * @param query e.g. Lady Gaga Poker Face
	 * @return
	 */
	public static PriceVO retrieveData(String interpreter, String title) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		SAXBuilder builder = new SAXBuilder();
		List list;
		PriceVO returnPrice = new PriceVO();

		WebResource webResource = client
				.resource("http://api.7digital.com/1.2/track/search");
		// http://api.7digital.com/1.2/?q=Happy
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("oauth_consumer_key", "7dt3fmzvh3cy");
		params.add("q", interpreter+" "+title);
		params.add("country", "DE");

		String response = webResource.queryParams(params)
				.accept(MediaType.TEXT_PLAIN).get(String.class);

		Reader in = new StringReader(response);

		Document document;
		try {
			document = (Document) builder.build(in);

			Element rootNode = document.getRootElement();
			int id = 0;
			list = rootNode.getChild("searchResults").getChildren();

			for (int i = 0; i < list.size(); i++) {
				Element e = (Element) list.get(i);
				if (e.getName().equals("searchResult")) {
					if (e.getChild("track").getChild("release")
							.getChildText("type").equals("Single")) {
						id = e.getChild("track").getChild("release")
								.getAttribute("id").getIntValue();
						break;
					}
				}
			}
			
			String foo = response;
		
			webResource = client
					.resource("http://api.7digital.com/1.2/release/tracks");
			params.clear();
			params.add("oauth_consumer_key", "7dt3fmzvh3cy");
			params.add("country", "DE");
			params.add("releaseId", "" + id);
			response = webResource.queryParams(params)
					.accept(MediaType.TEXT_PLAIN).get(String.class);

			in = new StringReader(response);
			document = (Document) builder.build(in);
			rootNode = document.getRootElement();
			
			try {
				String url = rootNode.getChild("tracks")
						.getChild("track").getChildText("url");
				float price = Float.valueOf(rootNode.getChild("tracks")
					.getChild("track").getChild("price").getChildText("value"));
				returnPrice.setValue(price);
				returnPrice.setCurrency("€");
				returnPrice.setProvider("7Digital");
				returnPrice.setUrl(url);
				//System.out.println("Preis von " + query + ": "
				//		+ price);
			}
			catch (NullPointerException ex) {
				return null;
			}

			//System.out.println(response);

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnPrice;
	}
}
