package com.rinat;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.twitter.TwitterComponent;
import org.apache.camel.component.websocket.WebsocketComponent;
import org.springframework.stereotype.Component;

@Component
public class TwitterRoute extends RouteBuilder {

    private static String host = "localhost";
    private static int port = 9091;
    private static String searchTerm = "Путин";
    private static int delay = 5000;

//    private String consumerKey;
//    private String consumerSecret;
//    private String accessToken;
//    private String accessTokenSecret;

    private static String consumerKey = "NMqaca1bzXsOcZhP2XlwA";
    private static String consumerSecret = "VxNQiRLwwKVD0K9mmfxlTTbVdgRpriORypnUbHhxeQw";
    private static String accessToken = "26693234-W0YjxL9cMJrC0VZZ4xdgFMymxIQ10LeL1K8YlbBY";
    private static String accessTokenSecret = "BZD51BgzbOdFstWZYsqB5p5dbuuDV12vrOdatzhY4E";


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    @Override
    public void configure() throws Exception {

        WebsocketComponent wc = getContext().getComponent("websocket", WebsocketComponent.class);
        wc.setHost(host);
        wc.setPort(port);
        wc.setStaticResources("classpath:.");


        TwitterComponent tc = getContext().getComponent("twitter", TwitterComponent.class);
        tc.setAccessToken(accessToken);
        tc.setAccessTokenSecret(accessTokenSecret);
        tc.setConsumerKey(consumerKey);
        tc.setConsumerSecret(consumerSecret);



        fromF("twitter://search?type=polling&delay=%s&keywords=%s", delay, searchTerm)
//                .to("log:tweet")
                .to("websocket://camel-tweet?sendToAll=true");


    }
}
