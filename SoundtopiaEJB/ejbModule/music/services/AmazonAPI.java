package music.services;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

import music.data.ValueObject.PriceVO;

import com.ECS.client.jax.AWSECommerceService;
import com.ECS.client.jax.AWSECommerceServicePortType;
import com.ECS.client.jax.AwsHandlerResolver;
import com.ECS.client.jax.Item;
import com.ECS.client.jax.ItemSearchRequest;
import com.ECS.client.jax.Items;
import com.ECS.client.jax.OperationRequest;

public class AmazonAPI {
	private static String AWS_ACCESS_KEY_ID = "AKIAJRWULOQJOTTEI66A";
	private static String AWS_SECRET_KEY = "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";

	public enum SearchIndex {
		All, Apparel, Automotive, Baby, Beauty, Blended, Books, Classical, DVD, Electronics, ForeignBooks, Grocery, HealthPersonalCare, HomeGarden, Jewelry, Kitchen, Magazines, MP3Downloads, Music, MusicalInstruments, MusicTracks, OfficeProducts, OutdoorLiving, PCHardware, Photo, Software, SoftwareVideoGames, SportingGoods, Tools, Toys, VHS, Video, VideoGames, Watches
	}

	private AmazonAPI() {
	}

	public static String getCover(String interpreter, String title) {
		AWSECommerceService service = setService();
		AWSECommerceServicePortType port = service.getAWSECommerceServicePortDE();
		ItemSearchRequest itemSearchRequest = new ItemSearchRequest();
		itemSearchRequest.getResponseGroup().add("ItemAttributes");
		itemSearchRequest.getResponseGroup().add("Images");
		itemSearchRequest.setSearchIndex(SearchIndex.MP3Downloads.toString());
		itemSearchRequest.setKeywords(interpreter + " " + title);
		List<ItemSearchRequest> request = new ArrayList<ItemSearchRequest>();
		request.add(itemSearchRequest);
		Holder<OperationRequest> operationRequest = new Holder<OperationRequest>();
		Holder<List<Items>> items = new Holder<List<Items>>();
		port.itemSearch("", AWS_ACCESS_KEY_ID, AWS_ACCESS_KEY_ID, "", "", itemSearchRequest, request, operationRequest, items);
		java.util.List<Items> result = items.value;
		try {
			Item myItem = result.get(0).getItem().get(0);
			return myItem.getLargeImage().getURL();
		} catch (Exception e) {
			System.out.println("amazon kein picture");
			return "";
		}
	}

	// TODO kommentar
	/**
	 * asrfgzhuj
	 * 
	 * @param searchIndex
	 * @param keywords
	 * @return
	 */
	public static PriceVO getPrice(SearchIndex searchIndex, String interpreter, String title) {
		PriceVO returnPrice = new PriceVO();
		String keyword = interpreter + " " + title;
		AWSECommerceService service = setService();
		AWSECommerceServicePortType port = service.getAWSECommerceServicePortDE();
		ItemSearchRequest itemSearchRequest = getOperationObject(searchIndex, keyword);
		List<ItemSearchRequest> request = new ArrayList<ItemSearchRequest>();
		request.add(itemSearchRequest);
		// Call the Web service operation and store the response
		// in the response object:
		Holder<OperationRequest> operationRequest = new Holder<OperationRequest>();
		Holder<List<Items>> items = new Holder<List<Items>>();

		port.itemSearch("", AWS_ACCESS_KEY_ID, AWS_ACCESS_KEY_ID, "", "", itemSearchRequest, request, operationRequest, items);
		java.util.List<Items> result = items.value;

		try {
			Item myItem = result.get(0).getItem().get(0);
			returnPrice.setUrl(myItem.getDetailPageURL());
			returnPrice.setProvider("Amazon");
			returnPrice.setValue(myItem.getOffers().getOffer().get(0).getOfferListing().get(0).getPrice().getAmount().intValue() / 100.f);
			returnPrice.setCurrency("€");
		} catch (Exception e) {
			System.out.println("amazon return null");
			return null;
		}

		System.out.println("Preis von " + keyword + ": " + returnPrice.getValue());
		return returnPrice;
	}

	private static AWSECommerceService setService() {
		AWSECommerceService service = new AWSECommerceService();
		// important, every request must be signed by secret key
		service.setHandlerResolver(new AwsHandlerResolver(AWS_SECRET_KEY));
		return service;
	}

	private static ItemSearchRequest getOperationObject(SearchIndex searchIndex, String keywords) {
		ItemSearchRequest itemSearchRequest = new ItemSearchRequest();
		itemSearchRequest.getResponseGroup().add("ItemAttributes");
		itemSearchRequest.getResponseGroup().add("Images");
		itemSearchRequest.getResponseGroup().add("Offers");
		itemSearchRequest.getResponseGroup().add("OfferFull");
		itemSearchRequest.setSearchIndex(searchIndex.toString());
		itemSearchRequest.setKeywords(keywords + " -album");
		return itemSearchRequest;
	}
}
