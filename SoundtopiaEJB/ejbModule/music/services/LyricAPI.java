package music.services;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import music.data.LyricVO;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class LyricAPI {
	public static LyricVO retrieveData(String artist, String title) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		SAXBuilder builder = new SAXBuilder();
		LyricVO lyricVO = new LyricVO();

		WebResource webResource = client
				.resource("http://lyrics.wikia.com/api.php");
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("func", "getSong");
		params.add("artist", artist);
		params.add("song", title);
		params.add("fmt", "xml");

		String response = webResource.queryParams(params)
				.accept(MediaType.APPLICATION_XML).get(String.class);

		try {
			Reader in = new StringReader(response);

			Document document = (Document) builder.build(in);
			Element rootNode = document.getRootElement();
			lyricVO.setText(rootNode.getChildText("lyrics"));
			lyricVO.setUrl(rootNode.getChildText("url"));
		} catch (IOException io) {
			System.err.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.err.println(jdomex.getMessage());
		}
		
		return lyricVO;
	}
}
