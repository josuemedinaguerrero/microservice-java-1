package com.example.motoservice.service;

import com.example.motoservice.entity.Moto;
import com.example.motoservice.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoServiceImpl implements MotoService {

   @Autowired
   private MotoRepository motoRepository;

   public List<Moto> getAll() {
      return motoRepository.findAll();
   }

   public Moto getMotoById(int id) {
      return motoRepository.findById(id).orElse(null);
   }

   public Moto save(Moto moto) {
      return motoRepository.save(moto);
   }

   @Override
   public List<Moto> byUsuarioId(int usuarioId) {
      return motoRepository.findByUsuarioId(usuarioId);
   }

}
