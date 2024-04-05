package br.com.projeto.estudo.Controller;

import br.com.projeto.estudo.Entity.Turma;
import br.com.projeto.estudo.Repository.TurmaRepository;
import br.com.projeto.estudo.Service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")

@Tag(description = "Métodos disponíveis no Controller de Turma", name = "Turmas")
public class TurmaController {
    @Autowired
    TurmaService turmaService;

    @GetMapping
    @Operation(summary = "Listar todas as turmas", description = "Listar todos as turmas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<List<Turma>> getAll() {
        List<Turma> turmas = turmaService.getAll();

        if(!turmas.isEmpty()) {
            return new ResponseEntity<>(turmas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Obter apenas uma turma", description = "Obter apenas uma turma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    @GetMapping("/{id}")
    public ResponseEntity<Turma> getById(@PathVariable Integer id) {
        Turma turma = turmaService.getById(id);
        if(turma != null) {
            return new ResponseEntity<>(turma, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @Operation(summary = "Cadastrar turma", description = "Cadastrar turma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    @PostMapping
    public  ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
        return new ResponseEntity<>(turmaService.saveTurma(turma), HttpStatus.CREATED);
    }
    @Operation(summary = "Atualizar turma", description = "Atualizar turma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    @PutMapping("/{id}")
    public ResponseEntity<Turma> updateTurma(@PathVariable Integer id, @RequestBody Turma turma){
        Turma turmaAtualizada = turmaService.updateTurma(id, turma);
        if(turmaAtualizada != null) {
            return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @Operation(summary = "Deletar turma", description = "Deletar turma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    @DeleteMapping("/{id}")
    public  ResponseEntity<Boolean> deleteTurma(@PathVariable Integer id) {
        if(turmaService.deleteTurma(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }
}
