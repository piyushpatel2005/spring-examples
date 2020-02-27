package com.piyushpatel2005.consumingsoap;

import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class ConsumingSoapApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingSoapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		NumberClient numberClient = new NumberClient();

		// create and setup marshaller
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		marshaller.setContextPath("com.dataaccess.webserviceserver");

		// add marshaller to client
		numberClient.setMarshaller(marshaller);
		numberClient.setUnmarshaller(marshaller);

		// retrieve the word format of the number
		NumberToWordsResponse response = numberClient.getWords("34656");

		System.out.println("Response is: " + response.getNumberToWordsResult());

	}

}
