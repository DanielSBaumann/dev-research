package com.devresearch.devresearch.dto;

import com.devresearch.devresearch.entity.Usuario;
import com.devresearch.devresearch.enums.CategoriaUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    private CategoriaUsuario categoria;

    public Usuario toUser(Usuario usuario) {
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        return usuario;
    }

    public void fromUser(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.categoria = usuario.getCategoria().getCategoria();
    }
}
