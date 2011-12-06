package music.services;


import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

import music.data.AmazonItemVO;

import com.ECS.client.jax.*;

/*AWSECommerceService;
import com.ECS.client.jax.AWSECommerceServicePortType;
import com.ECS.client.jax.AwsHandlerResolver;
import com.ECS.client.jax.Item;
import com.ECS.client.jax.ItemSearchRequest;
import com.ECS.client.jax.OperationRequest;
*/
public class AmazonAPI {
	public enum SearchIndex {
		All, MP3Downloads, Music, Electronics
	} // to be continued

	//keyword um "single" erweitern, weil erster eintrag eventuell album sein könnte?!
	public static AmazonItemVO retrieveData(SearchIndex searchIndex,
			String keywords) {
		final String AWS_ACCESS_KEY_ID = "AKIAJRWULOQJOTTEI66A";
		final String AWS_SECRET_KEY = "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";

		AmazonItemVO returnAmazonItemVO = new AmazonItemVO();
		// Set the service:
		AWSECommerceService service = new AWSECommerceService();

		// important, every request must be signed by secret key
		service.setHandlerResolver(new AwsHandlerResolver(AWS_SECRET_KEY));

		// Set the service port
		AWSECommerceServicePortType port = service
				.getAWSECommerceServicePortDE();

		// Get the operation object
		ItemSearchRequest itemSearchRequest = new ItemSearchRequest();
		itemSearchRequest.getResponseGroup().add("ItemAttributes");
		itemSearchRequest.getResponseGroup().add("Images");
		itemSearchRequest.getResponseGroup().add("Offers");

		// Fill in the request object:
		itemSearchRequest.setSearchIndex(searchIndex.toString());
		itemSearchRequest.setKeywords(keywords);
		// itemRequest.setVersion("2010-10-01");

		// itemElement.getRequest().add(itemRequest);

		List<ItemSearchRequest> request = new ArrayList<ItemSearchRequest>();

		// itemLookup.setResponseGroup(new String[] { "Images", "ItemAttributes"
		// });

		request.add(itemSearchRequest);

		// Call the Web service operation and store the response
		// in the response object:
		Holder<OperationRequest> operationRequest = new Holder<OperationRequest>();
		Holder<List<Items>> items = new Holder<List<Items>>();

		port.itemSearch("", AWS_ACCESS_KEY_ID, AWS_ACCESS_KEY_ID, "", "",
				itemSearchRequest, request, operationRequest, items);

		// System.out.println("Response:" + items);

		java.util.List<Items> result = items.value;

		try {
			Item myItem = result.get(0).getItem().get(0);

			returnAmazonItemVO.setAmount(myItem.getOffers().getOffer().get(0)
					.getOfferListing().get(0).getPrice().getAmount());
		} catch (Exception e) {
			returnAmazonItemVO.setAmount(null);
		}

		System.out.println("Preis von " + keywords + ": "
				+ returnAmazonItemVO.getAmount());

		// BigInteger totalPages = result.get(0).getTotalResults();
		// System.out.println(totalPages);

		/*
		 * 
		 * for (int i = 0; i < result.get(0).getItem().size(); ++i) { Item
		 * myItem = result.get(0).getItem().get(i);
		 * 
		 * System.out.println(myItem.getItemAttributes().getTitle());
		 * System.out.println(myItem.getASIN());
		 * 
		 * System.out.println(myItem.getDetailPageURL());
		 * 
		 * // System.out.println(myItem.getItemAttributes().getListPrice().
		 * getFormattedPrice().toString());
		 * System.out.println(myItem.getOffers().getOffer().get(0)
		 * .getOfferListing().get(0).getPrice().getFormattedPrice());
		 * System.out.println(myItem.getSmallImage() == null ? "" : myItem
		 * .getSmallImage().getURL());
		 * 
		 * System.out.println("-------------"); }
		 */
		return returnAmazonItemVO;
	}
}
