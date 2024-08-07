package com.example.BeneVivere.Services;

import com.example.BeneVivere.Entity.Login;
import com.example.BeneVivere.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Login> loginOpt = loginRepository.findAll().stream()
                .filter(login -> login.getEmail().getEmailUsuario().equals(email))
                .findFirst();

        if (loginOpt.isPresent()) {
            Login login = loginOpt.get();
            return User.builder()
                    .username(login.getEmail().getEmailUsuario())
                    .password(login.getSenha().getSenhaUsuario())
                    .roles("USER")  // Você pode definir papéis diferentes aqui
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
        }
    }
}
