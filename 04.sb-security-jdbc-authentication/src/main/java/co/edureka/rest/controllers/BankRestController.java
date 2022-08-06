package co.edureka.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	@GetMapping("/home")
	public String sendHomePage() {
		return "Welcome to State Bank of India";
	}
	
	@GetMapping("/balance")
	public String getAccountBalance() {
		return "Your Current Balance is Rs:27500.50";
	}	
	
	@GetMapping("/statement")
	public String getStatement() {
		return "Your Account Statement is Generated and will be send to your registered email";
	}
	
	@GetMapping("/myloan")
	public String getLoanBalance() {
		return "Your Loan Account Balance is Rs:125000.50";
	}
	
	@GetMapping("/customercare")
	public String getCustomerCare() {
		return "Thank you for contacting SBI.. We will be back to you soon!";
	}		
}
