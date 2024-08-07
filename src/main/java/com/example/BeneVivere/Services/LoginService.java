package com.example.BeneVivere.Services;

import com.example.BeneVivere.Entity.Login;
import com.example.BeneVivere.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Autentica o usuário com base no email e senha
    public boolean authenticate(String email, String rawPassword) {
        Optional<Login> loginOpt = loginRepository.findAll().stream()
                .filter(login -> login.getEmail().getEmailUsuario().equals(email))
                .findFirst();

        if (loginOpt.isPresent()) {
            Login login = loginOpt.get();
            return passwordEncoder.matches(rawPassword, login.getSenha().getSenhaUsuario());
        }

        return false;
    }

    // Registra um novo login
    public Login register(Login login) {
        // Criptografa a senha antes de salvar
        login.getSenha().setSenhaUsuario(passwordEncoder.encode(login.getSenha().getSenhaUsuario()));
        return loginRepository.save(login);
    }

    // Muda a senha de um usuário
    public boolean changePassword(String email, String oldPassword, String newPassword) {
        Optional<Login> loginOpt = loginRepository.findAll().stream()
                .filter(login -> login.getEmail().getEmailUsuario().equals(email))
                .findFirst();

        if (loginOpt.isPresent()) {
            Login login = loginOpt.get();
            if (passwordEncoder.matches(oldPassword, login.getSenha().getSenhaUsuario())) {
                login.getSenha().setSenhaUsuario(passwordEncoder.encode(newPassword));
                loginRepository.save(login);
                return true;
            }
        }

        return false;
    }

    // Deleta um login pelo email
    public boolean deleteByEmail(String email) {
        Optional<Login> loginOpt = loginRepository.findAll().stream()
                .filter(login -> login.getEmail().getEmailUsuario().equals(email))
                .findFirst();

        if (loginOpt.isPresent()) {
            loginRepository.delete(loginOpt.get());
            return true;
        }

        return false;
    }
}
