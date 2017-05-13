package com.example.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.bean.Sale;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RemoteSalesRepository implements SalesRepository{
	
	private static Logger LOG = LoggerFactory.getLogger(RemoteGarmetRepository.class);

	@Autowired	
	protected RestTemplate restTemplate;

	@Value("${services.sales}")
	protected String serviceUrl;

	@HystrixCommand(fallbackMethod = "newSaleDefault")
	@Override
	public Sale newSale(Sale sale) {
		return restTemplate.postForObject(serviceUrl + "/sales", sale, Sale.class);
	}
	
	private Sale newSaleDefault(Sale sale) {
		return null;
	}

}
