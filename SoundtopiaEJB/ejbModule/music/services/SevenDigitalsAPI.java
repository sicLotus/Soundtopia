package music.services;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import music.data.ValueObject.PriceVO;

import org.jdom.DataConversionException;
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
	private static final String AUTHENTIFICATION_KEY = "7dt3fmzvh3cy";
	/**
	 * Name des Authentifikationsschluessels der fuer die API benoetigt wird
	 */
	private static final String CONSUMER_KEY = "oauth_consumer_key";
	/**
	 * Name der Suchbegriffe fuer die API
	 */
	private static final String SEARCH_NAME = "q";
	private static final String COUNTRY_NAME = "country";
	private static final String COUNTRY_PARAM = "DE";

	private SevenDigitalsAPI() {

	}

	public static PriceVO getPrice(String interpreter, String title) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		PriceVO returnPrice = new PriceVO();

		try {
			int releaseID = searchReleaseID(interpreter, title, client);
			returnPrice = searchPrice(client, releaseID);
		} catch (DataConversionException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException ex) {
			return null;
		}
		return returnPrice;
	}

	private static PriceVO searchPrice(Client client, int releaseID) throws JDOMException, IOException {
		PriceVO priceVO = new PriceVO();
		WebResource webResource = client.resource("http://api.7digital.com/1.2/release/tracks");
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add(CONSUMER_KEY, AUTHENTIFICATION_KEY);
		params.add(COUNTRY_NAME, COUNTRY_PARAM);
		params.add("releaseId", "" + releaseID);
		String response = webResource.queryParams(params).accept(MediaType.TEXT_PLAIN).get(String.class);
		SAXBuilder builder = new SAXBuilder();
		response = webResource.queryParams(params).accept(MediaType.TEXT_PLAIN).get(String.class);
		Reader in = new StringReader(response);
		Document document = (Document) builder.build(in);
		Element rootNode = document.getRootElement();

		String url = rootNode.getChild("tracks").getChild("track").getChildText("url");
		float price = Float.valueOf(rootNode.getChild("tracks").getChild("track").getChild("price").getChildText("value"));
		priceVO.setValue(price);
		priceVO.setCurrency("€");
		priceVO.setProvider("7Digital");
		priceVO.setUrl(url);
		return priceVO;
	}

	private static int searchReleaseID(String interpreter, String title, Client client) throws JDOMException, IOException {
		WebResource webResource = client.resource("http://api.7digital.com/1.2/track/search");
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add(CONSUMER_KEY, AUTHENTIFICATION_KEY);
		params.add(COUNTRY_NAME, COUNTRY_PARAM);
		params.add(SEARCH_NAME, interpreter + " " + title);
		String response = webResource.queryParams(params).accept(MediaType.TEXT_PLAIN).get(String.class);
		SAXBuilder builder = new SAXBuilder();
		Reader in = new StringReader(response);
		Document document = (Document) builder.build(in);
		Element rootNode = document.getRootElement();
		@SuppressWarnings("rawtypes")
		List list;
		int id = 0;
		list = rootNode.getChild("searchResults").getChildren();

		for (int i = 0; i < list.size(); i++) {
			Element e = (Element) list.get(i);
			if (e.getName().equals("searchResult")) {
				if (e.getChild("track").getChild("release").getChildText("type").equals("Single")) {
					id = e.getChild("track").getChild("release").getAttribute("id").getIntValue();
					break;
				}
			}
		}
		return id;
	}
}
