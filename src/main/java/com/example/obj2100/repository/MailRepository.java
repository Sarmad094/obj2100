package com.example.obj2100.repository;

import com.example.obj2100.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MailRepository extends JpaRepository<Email, Long> {

    List<Email> findAllByToEmail(String toEmail);

    List<Email> findAllByFromEmail(String fromEmail);

    List<Email> findMailByContentContainingAndSubjectContains(String str1, String str2);

    @Query(value = "SELECT * FROM email WHERE from_email LIKE %:domain", nativeQuery = true)
    List<Email> getMailsByDomain(String domain);
}