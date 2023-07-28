package com.example.demo.controller;

import com.example.demo.entity.Producto;
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
    public List<Producto> listarProductos (){
        return productoService.getAllProducts();
    }
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoService.saveProduct(producto);
    }
    @PutMapping("/act/{id}")
    public Producto actualizarProducto(@PathVariable int id, @RequestBody Producto producto){
        return productoService.updateProduct(id, producto);
    }
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id){
        productoService.deleteProduct(id);
    }

}