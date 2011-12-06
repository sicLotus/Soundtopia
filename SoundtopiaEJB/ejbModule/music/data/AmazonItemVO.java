package music.data;

import java.math.BigInteger;

public class AmazonItemVO {
	private BigInteger amount;

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}
	
	public float getFloatAmount() {
		return (float)amount.intValue()/100;
	}
}
