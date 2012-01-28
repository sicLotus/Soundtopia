package music.data.ValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import music.data.DataObject.Price;

public class PriceVO {
	private String provider;
	private String url;
	private float value;
	private String currency;

	public String getProvider() {
		return provider.toLowerCase();
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public static List<PriceVO> valueOf(Set<Price> prices) {
		if (prices != null) {
			List<PriceVO> pricesVO = new ArrayList<PriceVO>();
			for (Price p : prices) {
				pricesVO.add(valueOf(p));
			}
			return pricesVO;
		} else
			return null;
	}

	private static PriceVO valueOf(Price p) {
		PriceVO priceVO = new PriceVO();
		priceVO.setCurrency(p.getCurrency());
		priceVO.setProvider(p.getProvider());
		priceVO.setUrl(p.getOfferUrl());
		priceVO.setValue(p.getValue());
		return priceVO;
	}
}
