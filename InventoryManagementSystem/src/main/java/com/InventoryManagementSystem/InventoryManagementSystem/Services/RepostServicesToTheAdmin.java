package com.BillGenrationsSystem.BillManagementSystem.Services;


import com.BillGenrationsSystem.BillManagementSystem.EntityModels.HalperCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class RepostServicesToTheAdmin{
    @Autowired(required = true)
    private HalperCount h;
    @Autowired
    private CustomerServices customerServices;

    @Value("${stirng_my}")
    private String emailreciver;
    @Autowired
    JavaMailSender javaMailSender;
    // Now you can access the methods of CustomerServices
    public void  sendRepostTotheAdmin()
    {
      

        Long ordercount=h.getOrdercount();
        Long newuser=h.getTotalnewuser();
        Long billgenraters=h.getTotaltimeofbill();
        Long timeofpayment=h.getTotaltimeofpayment();
        Long totalAmount=h.getTotalpaymnet();
        Long stockupdate=h.getStockupdated();
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        String report = "Daily Report:\n" +
                "Order Count: " + ordercount + "\n" +
                "New Users: " + newuser + "\n" +
                "Bill Generators: " + billgenraters + "\n" +
                "Time of Payment: " + timeofpayment + "\n" +
                "Total Amount: " + totalAmount + "\n" +
                "Stock Updates: " + stockupdate;
        mailMessage.setFrom("lathiyaom52725@gmail.com");
        mailMessage.setTo(emailreciver);
        mailMessage.setSubject("RepostOfTheDay...");
        mailMessage.setText(report);

        javaMailSender.send(mailMessage);
        h.resetCountForNewDay();
    }
}
