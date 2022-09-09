package com.example.usuarioservice.service;

import com.example.usuarioservice.entity.Usuario;
import com.example.usuarioservice.models.Carro;
import com.example.usuarioservice.models.Moto;

import java.util.List;
import java.util.Map;

public interface UsuarioService {

   List<Usuario> getAll();
   Usuario getUsuarioById(int id);
   Usuario save(Usuario usuario);
   List<Carro> getCarros(int usuarioId);
   List<Moto> getMotos(int usuarioId);
   public Carro saveCarro(int usuarioId, Carro carro);
   public Moto saveMoto(int usuarioId, Moto moto);
   public Map<String, Object> getUsuarioAndVehiculos(int usuarioId);

}
