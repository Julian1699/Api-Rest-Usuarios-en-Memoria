package com.example.demo.repository;

import com.example.demo.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productoRepository extends JpaRepository<ProductoEntity, Integer> {

}
