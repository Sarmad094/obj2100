package com.example.obj2100.Controller;

import com.example.obj2100.model.Email;
import com.example.obj2100.model.MyDTO;
import com.example.obj2100.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails") // Endret fra /api/mail til /api/emails for å matche modelnavnet og REST-konvensjon
public class MailController {

    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/{id}")
    public Email getMailById(@PathVariable Long id) {
        return mailService.getMailById(id);
    }

    @GetMapping
    public List<Email> getAllMails() {
        return mailService.getAllMails();
    }

    @GetMapping("/from/{from}")
    public List<Email> getAllFromMail(@PathVariable String from) {
        return mailService.getAllFromEmail(from);
    }

    @GetMapping("/to/{to}")
    public List<Email> getAllToMail(@PathVariable String to) {
        return mailService.getAllToEmail(to);
    }

    @PostMapping
    public void addMail(@RequestBody Email mail) {
        mailService.saveMail(mail);
    }

    @DeleteMapping("/{id}")
    public void deleteMail(@PathVariable Long id) {
        mailService.deleteMail(id);
    }

    @GetMapping("/dto")
    public List<MyDTO> getAllDTOs() {
        return mailService.getAllDTOs();
    }

    @GetMapping("/domain/{domain}")
    public List<Email> getAllFromDomain(@PathVariable String domain) {
        return mailService.getMailsByDomain(domain);
    }
}
