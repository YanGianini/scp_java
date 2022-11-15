package br.edu.universidadedevassouras.SCP.service;


import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import br.edu.universidadedevassouras.SCP.Repository.PessoaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PessoaDAO pessoaDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Pessoa> pessoa = pessoaDAO.findByUsername(userName);
        if(pessoa.isEmpty()){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        Pessoa p = pessoa.get();
        return new User(p.getUsername(), p.getPassword(), new ArrayList<>());
    }

}