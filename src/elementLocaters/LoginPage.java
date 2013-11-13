package elementLocaters;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 10/24/13
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage {
	private String emailIdTextBox=".//*[@id='loginName']";
	private String newUserRadioBtn=".//*[@id='container']/div/div/div/div/form[2]/fieldset/label[2]/input";
	private String existingUserRadioBtn=".//*[@id='container']/div/div/div/div/form/fieldset/label[3]/input";
	private String passwordTextBox=".//*[@id='container']/div/div/div/div/form/fieldset/input[2]";
	private String signInBtn=".//*[@id='container']/div/div/div/div/form/fieldset/div/input[1]" ;
	private String createAnAccountBtn=".//*[@id='container']/div/div/div/div/form/fieldset/div/input[2]" ;

	public String getCreateAnAccountBtn() {
		return createAnAccountBtn;
	}

	public String getEmailIdTextBox() {
		return emailIdTextBox;
	}

	public String getNewUserRadioBtn() {
		return newUserRadioBtn;
	}

	public String getExistingUserRadioBtn() {
		return existingUserRadioBtn;
	}

	public String getPasswordTextBox() {
		return passwordTextBox;
	}

	public String getSignInBtn() {
		return signInBtn;
	}
}
