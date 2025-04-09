package com.example.obj2100.service;

import com.example.obj2100.model.Email;
import com.example.obj2100.model.MyDTO;
import com.example.obj2100.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MailServiceImpl implements MailService {

    private final MailRepository repository;

    @Autowired
    public MailServiceImpl(MailRepository repository) {
        this.repository = repository;
    }

    @Override
    public Email getMailById(Long id) {
        Optional<Email> mailOptional = repository.findById(id);
        return mailOptional.orElse(null);
    }

    @Override
    public void saveMail(Email mail) {
        repository.save(mail);
    }

    @Override
    public void deleteMail(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Email> getAllMails() {
        return repository.findAll();
    }

    @Override
    public List<Email> getAllFromEmail(String fromEmail) {
        return repository.findAllByFromEmail(fromEmail);
    }

    @Override
    public List<Email> getAllToEmail(String toEmail) {
        return repository.findAllByToEmail(toEmail);
    }

    @Override
    public List<MyDTO> getAllDTOs() {
        return Arrays.asList(
                new MyDTO("n1", "l1"),
                new MyDTO("n2", "l2")
        );
    }

    @Override
    public List<Email> getMailsByDomain(String domain) {
        return repository.getMailsByDomain(domain);
    }
}