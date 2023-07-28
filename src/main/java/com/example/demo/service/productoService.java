package com.example.demo.service;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.repository.productoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class productoService {

    private final productoRepository productoRepository;

    public ProductoEntity saveProduct(ProductoEntity productoEntity){
        return productoRepository.save(productoEntity);
    }

    public ProductoEntity updateProduct(int id, ProductoEntity productoEntity) {

        Optional<ProductoEntity> productoId = productoRepository.findById(id);

        ProductoEntity productoEntityAct = productoId.get();
        productoEntityAct.setNombre(productoEntity.getNombre());
        productoEntityAct.setReferencia(productoEntity.getReferencia());
        productoEntityAct.setPrecio(productoEntity.getPrecio());
        productoEntityAct.setPeso(productoEntity.getPeso());
        productoEntityAct.setCategoria(productoEntity.getCategoria());
        productoEntityAct.setStock(productoEntity.getStock());
        productoEntityAct.setFecha(productoEntity.getFecha());

        return productoRepository.save(productoEntityAct);

    }

    public List<ProductoEntity> getAllProducts (){
        return productoRepository.findAll();
    }

    public Optional<ProductoEntity> findById(int id){
        return productoRepository.findById(id);
    }

    public void deleteProduct(int id){
        productoRepository.deleteById(id);
    }

}