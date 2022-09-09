package com.example.carroservice.service;

import com.example.carroservice.entity.Carro;
import com.example.carroservice.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

   @Autowired
   private CarroRepository carroRepository;

   public List<Carro> getAll() {
      return carroRepository.findAll();
   }

   public Carro getCarroById(int id) {
      return carroRepository.findById(id).orElse(null);
   }

   public Carro save(Carro carro) {
      return carroRepository.save(carro);
   }

   @Override
   public List<Carro> byUsuarioId(int usuarioId) {
      return carroRepository.findByUsuarioId(usuarioId);
   }

}
