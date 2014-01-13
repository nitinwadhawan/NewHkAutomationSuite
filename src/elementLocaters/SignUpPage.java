package elementLocaters;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 10/24/13
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class SignUpPage {
	private String nameTextBox=".//*[@id='container']/div[2]/div[1]/div/div/form/fieldset/input[1]";
	private String emailIdTextBox=".//*[@id='container']/div[2]/div[1]/div/div/form/fieldset/input[2]";
	private String passwordTextBox=".//*[@id='container']/div[2]/div[1]/div/div/form/fieldset/input[3]";
	private String confirmPassTextBox=".//*[@id='container']/div[2]/div[1]/div/div/form/fieldset/input[4]";
	private String createAccountBtn=".//*[@id='container']/div/div/div/div/form/fieldset/input[5]";
	private String agreeConditionsCheckBox=".//*[@id='container']/div/div/div/div/form/fieldset/div/input";

	public String getAgreeConditionsCheckBox() {
		return agreeConditionsCheckBox;
	}

	public String getNameTextBox() {
		return nameTextBox;
	}

	public String getEmailIdTextBox() {
		return emailIdTextBox;
	}

	public String getPasswordTextBox() {
		return passwordTextBox;
	}

	public String getConfirmPassTextBox() {
		return confirmPassTextBox;
	}

	public String getCreateAccountBtn() {
		return createAccountBtn;
	}
}
