package com.example.emailverificationmysql.email;

public interface EmailSender {

    void send(String to, String email);
}
