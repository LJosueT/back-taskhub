package com.taskhub.taskhubbackend.security;

import com.taskhub.taskhubbackend.entity.Usuario;
import com.taskhub.taskhubbackend.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    Usuario userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userDetail = usuarioRepository.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + username));

        return new User(userDetail.getCorreo(), userDetail.getContraseña(), Collections.emptyList());
    }

    public Usuario getUserDetail(){
        return userDetail;
    }
}
