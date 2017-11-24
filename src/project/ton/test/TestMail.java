package project.ton.test;

import project.ton.controller.MailController;

public class TestMail {

	public static void main(String[] args) {
		MailController mail = new MailController();
		mail.sendMail("daniefelipec18@hotmail.com", "AH mlk");
	}
}
