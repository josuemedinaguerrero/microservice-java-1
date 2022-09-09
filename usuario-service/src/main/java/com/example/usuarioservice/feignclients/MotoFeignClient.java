package com.example.usuarioservice.feignclients;

import com.example.usuarioservice.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "moto-service", url = "http://localhost:8082/moto")
public interface MotoFeignClient {

   @PostMapping
   public Moto save(@RequestBody Moto moto);

   @GetMapping("/usuario/{usuarioId}")
   public List<Moto> getMotos(@PathVariable("usuarioId") int usuarioId);

}
