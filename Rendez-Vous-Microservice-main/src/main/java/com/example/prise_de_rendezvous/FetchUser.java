package com.example.prise_de_rendezvous;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "users-registration")
public interface FetchUser {
    @GetMapping("/findUserByName/{nom}")
    public UserBean findUserByName(@PathVariable("nom")String nom);
}
