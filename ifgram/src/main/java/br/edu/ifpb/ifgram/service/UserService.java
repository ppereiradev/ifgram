package br.edu.ifpb.ifgram.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.bcel.ExceptionRange;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.ifgram.dto.UserRequest;
import br.edu.ifpb.ifgram.dto.UserResponse;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repository.UserRepository;

@Service 
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    @Transactional 
    public UserResponse criar(UserRequest request) throws Exception {
        if(repository.existsByEmail(request.email())){
            throw new Exception("Email já cadastrado: " + request.email());
        }
        User usuarioNovo = new User(request.nome(), request.email());
        User usuarioSalvo = repository.save(usuarioNovo);

        return UserResponse.from(usuarioSalvo);
    }

    public List<UserResponse> buscarTodosUsuarios(){
        List<User> listaUsuarios = repository.findAll();
        List<UserResponse> listaUsuariosResponse = new ArrayList<>();
        for(User user : listaUsuarios) {
            UserResponse userReponse = new UserResponse(
                user.getId(),
                user.getNome(),
                user.getEmail()
            );
            listaUsuariosResponse.add(userReponse);
        }
        return listaUsuariosResponse;
    }
}
