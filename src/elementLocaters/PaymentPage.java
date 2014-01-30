package elementLocaters;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 10/24/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PaymentPage {
	private String creditCardTab = ".//*[@id='tab1']";
	private String ccMakePaymentBtn = ".//*[@id='tabs_content1']/form/div[1]/input";
	private String codTab=".//*[@id='tab4']";
	private String codPayment=".//*[@id='tabs_content4']/form/div[3]/input";
	private String enableVisa=".//*[@id='Dummy']";
	private String pGatewayYes="html/body/div/form/p[1]/input[1]";
	private String pGatewayProceed="html/body/div/form/input[5]";

	public String getpGatewayYes() {
		return pGatewayYes;
	}

	public String getpGatewayProceed() {
		return pGatewayProceed;
	}

	public String getEnableVisa() {
		return enableVisa;
	}

	public String getCodTab() {
		return codTab;
	}

	public String getCodPayment() {
		return codPayment;
	}

	public String getCreditCardTab() {
		return creditCardTab;
	}

	public String getCcMakePaymentBtn() {
		return ccMakePaymentBtn;
	}
}
