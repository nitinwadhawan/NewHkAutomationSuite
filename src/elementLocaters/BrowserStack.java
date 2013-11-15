package elementLocaters;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 11/15/13
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class BrowserStack {

	private String signInHomePage=".//*[@id='header']/div/div/ul[2]/li[4]/a";
	private String emailTextBox=".//*[@id='user_email_login']";
	private String passwordBox=".//*[@id='user_password']";
	private String signInBtn=".//*[@id='user_submit']";
	private String pullDownBrowser=".//*[@id='pulldown-browser']";
	private String startTestingBtn=".//*[@id='btnStartTest']";

	public String getStartTestingBtn() {
		return startTestingBtn;
	}

	public String getPullDownBrowser() {
		return pullDownBrowser;
	}

	public String getSignInHomePage() {
		return signInHomePage;
	}

	public String getEmailTextBox() {
		return emailTextBox;
	}

	public String getPasswordBox() {
		return passwordBox;
	}

	public String getSignInBtn() {
		return signInBtn;
	}
}
