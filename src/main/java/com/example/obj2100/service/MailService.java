package com.example.obj2100.service;

import com.example.obj2100.model.Email;
import com.example.obj2100.model.MyDTO;

import java.util.List;

public interface MailService {

    Email getMailById(Long id);

    void saveMail(Email mail);

    void deleteMail(Long id);

    List<Email> getAllMails();

    List<Email> getAllFromEmail(String fromEmail);

    List<Email> getAllToEmail(String toEmail);

    List<MyDTO> getAllDTOs();

    List<Email> getMailsByDomain(String domain);
}