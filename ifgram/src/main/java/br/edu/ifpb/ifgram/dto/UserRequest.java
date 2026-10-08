package br.edu.ifpb.ifgram.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
    @Email
    String email,
    
    @Size(min=3)
    @NotNull 
    String nome,
    
    @Size(min=4)
    @NotNull 
    String senha
) {}