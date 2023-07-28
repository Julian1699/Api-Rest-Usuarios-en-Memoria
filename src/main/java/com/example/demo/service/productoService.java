package com.example.demo.service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.productoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class productoService {

    private final productoRepository productoRepository;

    public Producto saveProduct(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto updateProduct(int id, Producto producto) {

        Optional<Producto> productoId = productoRepository.findById(id);

        Producto productoAct = productoId.get();
        productoAct.setNombre(producto.getNombre());
        productoAct.setReferencia(producto.getReferencia());
        productoAct.setPrecio(producto.getPrecio());
        productoAct.setPeso(producto.getPeso());
        productoAct.setCategoria(producto.getCategoria());
        productoAct.setStock(producto.getStock());
        productoAct.setFecha(producto.getFecha());

        return productoRepository.save(productoAct);

    }

    public List<Producto> getAllProducts (){
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(int id){
        return productoRepository.findById(id);
    }

    public void deleteProduct(int id){
        productoRepository.deleteById(id);
    }

}