package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.bean.Sale;

@Service
public interface SalesRepository extends CrudRepository<Sale, Long>{

}
