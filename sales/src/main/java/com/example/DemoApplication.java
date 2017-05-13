package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import com.example.bean.Sale;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Source.class)
public class DemoApplication {

	private static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*
	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
	public MessageSource<Sale> orderSource() {
		return () -> {
			Sale sale = new Sale();
			sale.setProduct("Better skirt");
			LOG.info("Sending sale: " + sale);
			return new GenericMessage<>(sale);
		};
	}
	*/
	
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
