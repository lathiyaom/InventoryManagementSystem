package com.BillGenrationsSystem.BillManagementSystem;

import com.BillGenrationsSystem.BillManagementSystem.Services.RepostServicesToTheAdmin;
import com.BillGenrationsSystem.BillManagementSystem.Services.SMSservices;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class InventoryManagementSystemApplications {

	public static void main(String[] args) {
		SpringApplication.run(BillManagementSystemApplication.class, args);
		System.out.println("api is started.............");

	}

	public void sendSms(String phonno, String outgoing, String message1) {
		Message message = Message.creator(	
						new com.twilio.type.PhoneNumber(phonno),
						new com.twilio.type.PhoneNumber(outgoing),
						message1)
				.create();
	}
    @Autowired
    RepostServicesToTheAdmin repostServicesToTheAdmin;
    @Scheduled(cron = "0 50 11 * * *")
    public  void sendtheEmailtotheAdminAttheEndOfTheDay()
    {
		System.out.println("shedulare is starter.......");
        System.out.println("befor the call the method.......");
        repostServicesToTheAdmin.sendRepostTotheAdmin();
        System.out.println("after the call the method.......");
    }


}
