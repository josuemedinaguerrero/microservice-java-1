package com.example.carroservice.service;

import com.example.carroservice.entity.Carro;

import java.util.List;

public interface CarroService {

   List<Carro> getAll();
   Carro getCarroById(int id);
   Carro save(Carro usuario);
   List<Carro> byUsuarioId(int usuarioId);

}
