package com.BillGenrationsSystem.BillManagementSystem.Services;


import com.BillGenrationsSystem.BillManagementSystem.BillManagementSystemApplication;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Customer;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Order;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SMSservices {

    @Autowired
    CustomerServices customerServices;

    @Value("${TWILIO_ACCOUNT_SID}")
    private String accountSid;

    @Value("${TWILIO_AUTH_TOKEN}")
    private String authToken;

    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    private String outgoingSmsNumber;

    @PostConstruct
    public void Intilize() {
        Twilio.init(accountSid, authToken);
    }

    public void sendwhatsapp(Integer custId, Integer proId, Order order) {
        Customer customer = customerServices.getbyacustId(custId);
        String phoneNumber = customer.getMobileNumber();
        BillManagementSystemApplication b=new BillManagementSystemApplication();
        b.sendSms("whatsapp:"+"+91"+customer.getMobileNumber(),"whatsapp:+13858992566","Your order is register and your payment is panding...");


    }
    public void sendwhatsappwithpayment(Integer custId, Integer proId, Order order) {

        Customer customer = customerServices.getbyacustId(custId);
        String phoneNumber = customer.getMobileNumber();
        BillManagementSystemApplication b=new BillManagementSystemApplication();
        b.sendSms("whatsapp:"+"+91"+customer.getMobileNumber(),"whatsapp:+13858992566","Your order is register and your payment is done...");

    }


    public void sendsmswithpayment(Integer custId, Integer proId, Order order) {
        Customer customer = customerServices.getbyacustId(custId);
        String phoneNumber = customer.getMobileNumber();
        BillManagementSystemApplication b=new BillManagementSystemApplication();
        b.sendSms("+91"+customer.getMobileNumber(),"+13858992566","Your order is register and your payment is done...");

    }

    public void sendsms(Integer custId, Integer proId, Order order) {
        Customer customer = customerServices.getbyacustId(custId);
        String phoneNumber = customer.getMobileNumber();
        BillManagementSystemApplication b=new BillManagementSystemApplication();
        b.sendSms("+91"+customer.getMobileNumber(),"+13858992566","Your order is register and your payment is panding...");
    }
    @Autowired
    JavaMailSender javaMailSender;
    public void  sendemailwithpayment(Integer custId, Integer proId, Order order)
    {
        Customer c=customerServices.getbyacustId(custId);
        String to=c.getEmail();
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setFrom("lathiyaom52725@gmail.com");
            System.out.println(to);
            mailMessage.setTo(to);
            mailMessage.setSubject("Alert.......");
            mailMessage.setText("Thanks to give me  your order ..........." +
                    "your payment is done........");
            javaMailSender.send(mailMessage);
            System.out.println("send email");
    }
    public void  sendemail(Integer custId, Integer proId, Order order)
    {
        Customer c=customerServices.getbyacustId(custId);
        String to=c.getEmail();
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("lathiyaom52725@gmail.com");
        System.out.println(to);
        mailMessage.setTo(to);
        mailMessage.setSubject("Alert.......");
        mailMessage.setText("Thanks to give me  your order  ..........." +
                "but your payment is panding ......");
        javaMailSender.send(mailMessage);
        System.out.println("send email");
    }

    public void sendMailtotheAdmin(Integer custId, Integer proId, Order order) {
        Customer c=customerServices.getbyacustId(custId);
        BillManagementSystemApplication b=new BillManagementSystemApplication();
        b.sendSms("+91"+c.getMobileNumber(),"+13858992566","kasjnfkjajfkkf");
    }

    public void sendsmstotheAdmin(Integer custId, Integer proId, Order order) {
        Customer c=customerServices.getbyacustId(custId);
        BillManagementSystemApplication b=new BillManagementSystemApplication();
        b.sendSms("+91"+c.getMobileNumber(),"+13858992566","ProId is"+proId+"this product has les stock then level......");
    }
}


