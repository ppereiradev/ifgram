package br.edu.ifpb.ifgram.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.ifgram.service.UserService;
import br.edu.ifpb.ifgram.dto.UserRequest;
import br.edu.ifpb.ifgram.dto.UserResponse;

@RestController
@RequestMapping("user")
public class UserController {

    public final UserService service;

    public UserController(UserService service){
        this.service = service;
    }


    @GetMapping
    public List<UserResponse> getUsers(){
        List<UserResponse> listaUsuarios = service.buscarTodosUsuarios();
        return listaUsuarios;        
    }

    @PostMapping 
    public UserResponse postUser(UserRequest request) throws Exception {
        UserResponse userResponse = service.criar(request);
        return userResponse;
    }

    @DeleteMapping 
    public String deleteUser(){
        return "chamei o endpoint como um DELETE!";
    }

}
