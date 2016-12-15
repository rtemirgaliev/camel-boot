package com.rinat;

import org.apache.camel.main.Main;
//import org.apache.camel.spring.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static String consumerKey = "NMqaca1bzXsOcZhP2XlwA";
	private static String consumerSecret = "VxNQiRLwwKVD0K9mmfxlTTbVdgRpriORypnUbHhxeQw";
	private static String accessToken = "26693234-W0YjxL9cMJrC0VZZ4xdgFMymxIQ10LeL1K8YlbBY";
	private static String accessTokenSecret = "BZD51BgzbOdFstWZYsqB5p5dbuuDV12vrOdatzhY4E";


	public static void main(String[] args) throws Exception {


		TwitterRoute twitterRoute = new TwitterRoute();
		twitterRoute.setAccessToken(accessToken);
		twitterRoute.setAccessTokenSecret(accessTokenSecret);
		twitterRoute.setConsumerKey(consumerKey);
		twitterRoute.setConsumerSecret(consumerSecret);

		twitterRoute.setSearchTerm("Путин");
		twitterRoute.setDelay(6000);
		twitterRoute.setPort(9091);

//		Main main = new Main();
//		main.addRouteBuilder(twitterRoute);

//		main.run();



		SpringApplication.run(DemoApplication.class, args);
//		SpringApplication.run(main, args);
	}

}
