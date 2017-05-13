package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bean.Garment;
import com.example.bean.Sale;
import com.example.repository.GarmentRepository;
import com.example.repository.SalesRepository;

@Controller
public class InventoryController {
	@Autowired
	GarmentRepository repo;
	
	@Autowired
	SalesRepository salesRepo;
	
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		Garment garment = new Garment();
		garment.setName("Skirt");
		garment.setColor("Red");
		garment.setDescription("A skirt");
		garment.setPrice(12.55f);
		garment.setSize("S");
		repo.insert(garment);
		
		Sale sale = new Sale();
		sale.setProduct("Good Skirtss");
		sale.setAmount(1);
		sale = salesRepo.newSale(sale );
		System.out.println("New sale:"+sale.getId());
		
		List<Garment> garments = repo.findAll();
		System.out.println("Garments:"+garments.size());
		garments.stream().forEach(g -> {System.out.println(g.getName());});
		model.put("message", this.message);
		model.put("garments", garments);
		return "welcome";
	}

}
