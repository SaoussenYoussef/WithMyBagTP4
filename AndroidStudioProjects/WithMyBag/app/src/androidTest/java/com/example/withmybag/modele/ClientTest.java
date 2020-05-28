package com.example.withmybag.modele;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ClientTest {

    private Client client = new Client("Dupon", "dupont@gmail.com", 123456789 );

    // message a afficher
    private String  message = "Hello";

    @Test
    public void getName() {

    }

    @Test
    public void getEmail() {
    }

    @Test
    public void getPhone() {
    }

    @Test
    public void getMsg() {
        assertEquals( message, client.getMsg());

    }




}