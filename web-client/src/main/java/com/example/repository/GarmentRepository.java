package com.example.repository;

import java.util.List;

import com.example.bean.Garment;

public interface GarmentRepository{
	List<Garment> findAll();
	List<Garment> insert(Iterable<Garment> entities);
	Garment insert(Garment entities);
	
}
