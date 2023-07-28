package com.example.demo.controller;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.service.productoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/producto")
public class productoController {

    private final productoService productoService;
    @GetMapping
    public List<ProductoEntity> listarProductos (){
        return productoService.getAllProducts();
    }
    @PostMapping
    public ProductoEntity guardarProducto(@RequestBody ProductoEntity productoEntity){
        return productoService.saveProduct(productoEntity);
    }
    @PutMapping("/act/{id}")
    public ProductoEntity actualizarProducto(@PathVariable int id, @RequestBody ProductoEntity productoEntity){
        return productoService.updateProduct(id, productoEntity);
    }
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id){
        productoService.deleteProduct(id);
    }

}