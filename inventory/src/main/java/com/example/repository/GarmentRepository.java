package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.bean.Garment;

public interface GarmentRepository  extends MongoRepository<Garment, String>{

}
