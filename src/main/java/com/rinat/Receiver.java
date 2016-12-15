package com.rinat;

import org.springframework.jms.annotation.JmsListener;

public class Receiver {

    @JmsListener(destination = "tweets")
    public void receiveMessage(Tweet tweet) {
        System.out.println("Received: " + tweet);
    }
}
