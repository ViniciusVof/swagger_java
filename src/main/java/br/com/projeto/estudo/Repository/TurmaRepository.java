package br.com.projeto.estudo.Repository;

import br.com.projeto.estudo.Entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
