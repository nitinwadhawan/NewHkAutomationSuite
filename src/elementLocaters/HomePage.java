package elementLocaters;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 10/24/13
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomePage {
	private String searchBox=".//*[@id='globalSearch']/input";
	private String signInLink= ".//*[@id='header']/div/div/div/div/div/a";
	private String searchBtn=".//*[@id='search']/span";

	public String getSearchBox() {
		return searchBox;
	}

	public String getSignInLink() {
		return signInLink;
	}

	public String getSearchBtn() {
		return searchBtn;
	}
}
