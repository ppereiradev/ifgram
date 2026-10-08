package br.edu.ifpb.ifgram.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpb.ifgram.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    List<User> findByNomeContainingIgnoreCase(String trecho);

    @Query("select u from User u where u.email like concat('%', :dominio)")
    List<User> doDominio(String dominio);
    
} 
