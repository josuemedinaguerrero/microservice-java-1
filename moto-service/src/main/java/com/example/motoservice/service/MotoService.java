package com.example.motoservice.service;

import com.example.motoservice.entity.Moto;

import java.util.List;

public interface MotoService {

   List<Moto> getAll();
   Moto getMotoById(int id);
   Moto save(Moto moto);
   List<Moto> byUsuarioId(int usuarioId);

}
