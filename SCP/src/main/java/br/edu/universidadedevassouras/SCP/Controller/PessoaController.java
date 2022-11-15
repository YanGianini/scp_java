package br.edu.universidadedevassouras.SCP.Controller;

import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import br.edu.universidadedevassouras.SCP.Repository.PessoaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoa")
@CrossOrigin
public class PessoaController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PessoaDAO pessoaDAO;
    private Pessoa pessoa;

    @GetMapping
    public @ResponseBody Iterable<Pessoa> getAll(){
       return pessoaDAO.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Pessoa> getPessoa(@PathVariable("id")Long id){
       return pessoaDAO.findById(id);
    }

    @PostMapping
    public Pessoa postPessoa(@RequestBody Pessoa p){
        p.setPassword(passwordEncoder.encode(p.getPassword()));
        return pessoaDAO.save(p);
    }

    @DeleteMapping
    public void Delete(){
        pessoaDAO.deleteAll();
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id")Long id){
        pessoaDAO.deleteById(id);
    }

    @PutMapping
    public Pessoa putPessoa(@RequestBody Pessoa p){

        return pessoaDAO.save(p);
    }


}
