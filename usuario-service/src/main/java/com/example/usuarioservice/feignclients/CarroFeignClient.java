package com.example.usuarioservice.feignclients;

import com.example.usuarioservice.models.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "carro-service", url = "http://localhost:8081/carro")
public interface CarroFeignClient {

   @PostMapping
   public Carro save(@RequestBody Carro carro);

   @GetMapping("/usuario/{usuarioId}")
   public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);

}
