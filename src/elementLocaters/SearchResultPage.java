package elementLocaters;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 10/24/13
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchResultPage {

	private String firstProductResult=".//*[@id='variantResultView']/div[1]/div/a/img";//1 represents first product

	public String getFirstProductResult() {
		return firstProductResult;
	}
}
