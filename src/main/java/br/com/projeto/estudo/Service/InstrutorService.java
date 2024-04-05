package br.com.projeto.estudo.Service;

import br.com.projeto.estudo.Entity.Instrutor;
import br.com.projeto.estudo.Entity.Turma;
import br.com.projeto.estudo.Repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorService {
    @Autowired
    InstrutorRepository instrutorRepository;

    public List<Instrutor> getAll() {
        return instrutorRepository.findAll();
    }

    public Instrutor getById(Integer id) {
        return  instrutorRepository.findById(id).orElse(null);
    }
    public Instrutor saveInstrutor(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }
    public Instrutor updateInstrutor(Integer id, Instrutor instrutor) {
        Instrutor instrutorAtualizado = instrutorRepository.findById(id).orElse(null);

        if(instrutorAtualizado != null) {
            instrutorAtualizado.setNascimento(instrutor.getNascimento());
            instrutorAtualizado.setNome(instrutor.getNome());
            instrutorAtualizado.setRG(instrutor.getRG());
            instrutorAtualizado.setTitulacao(instrutor.getTitulacao());
            instrutorAtualizado.setTurmas(instrutor.getTurmas());

            return instrutorRepository.save(instrutorAtualizado);
        } else {
            return null;
        }
    }

    public Boolean deleteInstrutor(Integer id) {
        Instrutor instrutor = instrutorRepository.findById(id).orElse(null);

        if(instrutor != null) {
            instrutorRepository.delete(instrutor);
            return true;
        } else {
            return false;
        }
    }
}
