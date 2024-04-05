package br.com.projeto.estudo.Service;

import br.com.projeto.estudo.Entity.Instrutor;
import br.com.projeto.estudo.Entity.Turma;
import br.com.projeto.estudo.Repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    @Autowired
    TurmaRepository turmaRepository;


    public List<Turma> getAll() {
        return turmaRepository.findAll();
    }

    public Turma getById(Integer id) {
        return  turmaRepository.findById(id).orElse(null);
    }

    public Turma saveTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma updateTurma(Integer id, Turma turma) {
        Turma turmaAtualizada = turmaRepository.findById(id).orElse(null);

        if(turmaAtualizada != null) {
            turmaAtualizada.setDataInicio(turma.getDataInicio());
            turmaAtualizada.setDataFim(turma.getDataFim());
            turmaAtualizada.setDuracao(turma.getDuracao());
            turmaAtualizada.setHorario(turma.getHorario());
            turmaAtualizada.setInstrutor(turma.getInstrutor());

            return turmaRepository.save(turmaAtualizada);
        } else {
            return null;
        }
    }

    public Boolean deleteTurma(Integer id) {
        Turma turma = turmaRepository.findById(id).orElse(null);

        if(turma != null) {
            turmaRepository.delete(turma);
            return true;
        } else {
            return false;
        }
    }
}
