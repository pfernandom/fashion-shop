package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Sale;
import com.example.repository.SalesRepository;

@RestController
@RequestMapping("/sales")
public class SalesRestController implements SalesController {

	private static Logger LOG = LoggerFactory.getLogger(SalesRestController.class);

	@Autowired
	SalesRepository repo;

	@Autowired
	Source src;

	@RequestMapping(method = RequestMethod.POST)
	@Override
	public Sale newSale(@RequestBody Sale sale) {
		LOG.debug("New sale:" + sale.getProduct());
		src.output().send(MessageBuilder.withPayload(sale).build());
		
		return repo.save(sale);
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public List<Sale> findAll() {
		List<Sale> sales = new ArrayList<Sale>();
		repo.findAll().forEach(s -> sales.add(s));
		return sales;
	}

}
