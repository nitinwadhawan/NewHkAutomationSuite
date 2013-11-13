package elementLocaters;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 10/24/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductDetailPage {

	private String buyNowBtn=".//*[@id='variant-page']/div/div/div/div[1]/div/input";
	private String cartMouseOver=".//*[@id='header']/div/div/div[4]/div[1]/div";
	private String proceedToCartBtn=".//*[@id='cartPop']/div/div/div/div/a";

	public String getBuyNowBtn() {
		return buyNowBtn;
	}

	public String getCartMouseOver() {
		return cartMouseOver;
	}

	public String getProceedToCartBtn() {
		return proceedToCartBtn;
	}
}
