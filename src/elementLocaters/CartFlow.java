package elementLocaters;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 10/24/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class CartFlow {
	private String placeOrderBtn = ".//*[@id='cartForm']/input[2]";
	private String address1Box = "html/body/div/div/div[1]/div[1]";
	private String newAddNameTextBox = ".//*[@id='newAddressForm']/div[3]/input";
	private String newAddMobileTextBox = ".//*[@id='phone']";
	private String newAddLine1TextBox = ".//*[@id='line1']";
	private String newAddLine2 = ".//*[@id='line2']";
	private String newAddPinCode = ".//*[@id='pin']";
	private String newAddCity = ".//*[@id='cityselect']";
	private String newAddStateDropDown = ".//*[@id='stateselect']";
	private String newAddContinueBtn = ".//*[@id='newAddressForm']/div[17]/input";
	private String payNowBtn="html/body/div/div/div/div/form/div/div/input[2]";


	public String getPayNowBtn() {
		return payNowBtn;
	}

	public String getPlaceOrderBtn() {
		return placeOrderBtn;
	}

	public String getAddress1Box() {
		return address1Box;
	}

	public String getNewAddNameTextBox() {
		return newAddNameTextBox;
	}

	public String getNewAddMobileTextBox() {
		return newAddMobileTextBox;
	}

	public String getNewAddLine1TextBox() {
		return newAddLine1TextBox;
	}

	public String getNewAddLine2() {
		return newAddLine2;
	}

	public String getNewAddPinCode() {
		return newAddPinCode;
	}

	public String getNewAddCity() {
		return newAddCity;
	}

	public String getNewAddStateDropDown() {
		return newAddStateDropDown;
	}

	public String getNewAddContinueBtn() {
		return newAddContinueBtn;
	}
}
