package com.zycus.emailpractice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import com.zycus.emailpractice.service.Emailsenderimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import model.Mail;

@Controller
public class MailController {
    @Autowired
    private Emailsenderimpl email;

    @PostMapping("/sendmail")
    public ResponseEntity<String> mail(@RequestBody Mail mail) throws MessagingException, IOException {
     
            mail.setFrom(mail.getFrom());
            mail.setTo(mail.getTo());
            mail.setSubject(mail.getSubject());
            Map<String, Object> props = new HashMap<String, Object>();
            props.put("name",mail.getName());
            props.put("info", mail.getInfo());
            mail.setProps(props);
           ResponseEntity<String> resp= email.sendEmail(mail);
         return resp;

    }
}
