package br.com.projeto.estudo.Repository;

import br.com.projeto.estudo.Entity.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {
}
