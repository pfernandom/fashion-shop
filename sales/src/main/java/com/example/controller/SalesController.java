package com.example.controller;

import java.util.List;

import com.example.bean.Sale;


public interface SalesController {
	Sale newSale(Sale sale);
	List<Sale> findAll();

}
