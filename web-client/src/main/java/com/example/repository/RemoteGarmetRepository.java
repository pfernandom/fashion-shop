package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.bean.Garment;
import com.example.bean.RestResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RemoteGarmetRepository implements GarmentRepository {
	
	private static Logger LOG = LoggerFactory.getLogger(RemoteGarmetRepository.class);

	@Autowired	
	protected RestTemplate restTemplate;

	@Value("${services.inventory}")
	protected String serviceUrl;

	@HystrixCommand(fallbackMethod = "defaultFindAll")
	@Override
	public List<Garment> findAll() {
		RestResult result = restTemplate.getForObject(serviceUrl + "/garments", RestResult.class);
		return result.getGarments();
	}
	
	private List<Garment> defaultFindAll() {
		LOG.debug("Using default call");
		return new ArrayList<Garment>();
	}

	@Override
	public List<Garment> insert(Iterable<Garment> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@HystrixCommand(fallbackMethod = "defaultInsertOne")
	@Override
	public Garment insert(Garment entity) {
		return restTemplate.postForObject(serviceUrl + "/garments", entity, Garment.class);
	}
	
	private Garment defaultInsertOne(Garment entity) {
		LOG.debug("Using default call");
		return entity;
	}

}
