package music.services;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import music.data.ChartEntryVO;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/*
 * 
 Your Developer Key (dev_id) is: fd613876bee13bc19d5a4d8575a6fd47

 Your Website Key(s) (website_id) is (are): 

 For Website www.fh-brandenburg.de: 57c115313d1c7b9e531035af0e739973
 */
public class MyVideoAPI {

	public void retrieveData() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		SAXBuilder builder = new SAXBuilder();
		List<ChartEntryVO> chartList = new ArrayList<ChartEntryVO>();

		@SuppressWarnings("rawtypes")
		List list = null;
		int page = 1;

		WebResource webResource = client
				.resource("https://api.myvideo.de/prod/mobile/api2_rest.php");
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("dev_id", "fd613876bee13bc19d5a4d8575a6fd47");
		params.add("website_id", "57c115313d1c7b9e531035af0e739973");
		params.add("global_id", "de");
		params.add("o_format", "xml");
		params.add("method", "myvideo.videos.list_by_chart_id");
		params.add("per_page", "20");
		params.add("page", "" + page);
		params.add("chart_id", "117");

		do {
			params.putSingle("page", "" + page);
			String response = webResource.queryParams(params)
					.accept(MediaType.TEXT_PLAIN).get(String.class);

			try {
				Reader in = new StringReader(response);

				Document document = (Document) builder.build(in);
				Element rootNode = document.getRootElement();
				list = rootNode.getChild("myvideo").getChild("movie_list")
						.getChildren();

				for (int i = 0; i < list.size(); i++) {
					Element node = (Element) list.get(i);
					ChartEntryVO entry = new ChartEntryVO();

					entry.setMovie_id(Integer.parseInt(node
							.getChildText("movie_id")));
					entry.setMovie_length(Integer.parseInt(node
							.getChildText("movie_length")));
					entry.setMovie_owner_id(Integer.parseInt(node
							.getChildText("movie_owner_id")));
					entry.setMovie_views(Integer.parseInt(node
							.getChildText("movie_views")));
					entry.setMovie_added(Integer.parseInt(node
							.getChildText("movie_added")));
					entry.setMovie_rating(Double.parseDouble(node
							.getChildText("movie_rating")));
					entry.setMovie_title(node.getChildText("movie_title"));
					entry.setMovie_thumbnail(node
							.getChildText("movie_thumbnail"));
					entry.setMovie_owner(node.getChildText("movie_owner"));
					entry.setMovie_owner_url(node
							.getChildText("movie_owner_url"));
					entry.setPermalink(node.getChildText("permalink"));
					entry.setPermathumblink(node.getChildText("permathumblink"));
					entry.setMovie_url(node.getChildText("movie_url"));
/*
					entry.setCoverUrl(GoogleImageAPI.retrieveData(entry
							.getInterpreter()
							+ " "
							+ entry.getTitle()
							+ " cover"));
					entry.setLyricVO(LyricAPI.retrieveData(entry.getInterpreter(), entry.getTitle()));
*/
					chartList.add(entry);
					System.out.println("Current song: " + (i + 1) + " from " + list.size() + " page (" + page + ")");
					AmazonAPI.retrieveData(AmazonAPI.SearchIndex.MP3Downloads, entry.getInterpreter() + " " + entry.getTitle());
					
					//System.out.print(entry + " % ");
					//System.out.println(entry.getLyricVO().getText() + "$$" + entry.getLyricVO().getUrl());
				}

			} catch (IOException io) {
				System.out.println(io.getMessage());
			} catch (JDOMException jdomex) {
				System.out.println(jdomex.getMessage());
			}

			page++;

		} while (list != null && list.size() > 0);

		// System.out.println(chartList.size());

	}
}
