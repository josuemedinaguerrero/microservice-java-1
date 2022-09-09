package com.example.usuarioservice.service;

import com.example.usuarioservice.entity.Usuario;
import com.example.usuarioservice.feignclients.CarroFeignClient;
import com.example.usuarioservice.feignclients.MotoFeignClient;
import com.example.usuarioservice.models.Carro;
import com.example.usuarioservice.models.Moto;
import com.example.usuarioservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioServiceImpl implements UsuarioService {

   @Autowired
   private UsuarioRepository usuarioRepository;

   @Autowired
   private RestTemplate restTemplate;

   @Autowired
   private CarroFeignClient carroFeignClient;

   @Autowired
   private MotoFeignClient motoFeignClient;

   @Override
   public List<Usuario> getAll() {
      return usuarioRepository.findAll();
   }

   @Override
   public Usuario getUsuarioById(int id) {
      return usuarioRepository.findById(id).orElse(null);
   }

   @Override
   public Usuario save(Usuario usuario) {
      return usuarioRepository.save(usuario);
   }

   @Override
   public List<Carro> getCarros(int usuarioId) {
      return restTemplate.getForObject("http://localhost:8081/carro/usuario/" + usuarioId, List.class);
   }

   @Override
   public List<Moto> getMotos(int usuarioId) {
      return restTemplate.getForObject("http://localhost:8082/moto/usuario/" + usuarioId, List.class);
   }

   @Override
   public Carro saveCarro(int usuarioId, Carro carro) {
      carro.setUsuarioId(usuarioId);
      return carroFeignClient.save(carro);
   }

   @Override
   public Moto saveMoto(int usuarioId, Moto moto) {
      moto.setUsuarioId(usuarioId);
      return motoFeignClient.save(moto);
   }

   @Override
   public Map<String, Object> getUsuarioAndVehiculos(int usuarioId) {
      Map<String, Object> resultado = new HashMap<>();
      Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

      if (usuario == null) {
         resultado.put("Mensaje", "El usuario no existe");
         return resultado;
      }

      resultado.put("Usuario", usuario);

      List<Carro> carros = carroFeignClient.getCarros(usuarioId);

      if (carros.isEmpty()) {
         resultado.put("Carros", "El usuario no tiene carros");
      } else {
         resultado.put("Carros", carros);
      }

      List<Moto> motos = motoFeignClient.getMotos(usuarioId);

      if (motos.isEmpty()) {
         resultado.put("Motos", "El usuario no tiene motos");
      } else {
         resultado.put("Motos", motos);
      }

      return resultado;
   }

}
