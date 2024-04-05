package br.com.projeto.estudo.Controller;

import br.com.projeto.estudo.Entity.Instrutor;
import br.com.projeto.estudo.Repository.InstrutorRepository;
import br.com.projeto.estudo.Service.InstrutorService;
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
@RequestMapping("/instrutor")


@Tag(description = "Métodos disponíveis no Controller de Instrutores", name = "Instrutores")
public class InstrutorController {
    @Autowired
    InstrutorService instrutorService;

    @GetMapping
    @Operation(summary = "Listar todos os intrutores", description = "Listar todos os intrutores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<List<Instrutor>> getAll() {
        List<Instrutor> instrutores = instrutorService.getAll();

        if(!instrutores.isEmpty()) {
            return new ResponseEntity<>(instrutores, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @Operation(summary = "Obter apenas um instrutor", description = "Obter apenas um instrutor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> getById(@PathVariable Integer id) {
        Instrutor instrutor = instrutorService.getById(id);
        if(instrutor != null) {
            return new ResponseEntity<>(instrutor, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Cadastrar instrutor", description = "Cadastrar instrutor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    @PostMapping
    public  ResponseEntity<Instrutor> saveInstrutor(@RequestBody Instrutor instrutor) {
        return new ResponseEntity<>(instrutorService.saveInstrutor(instrutor), HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar instrutor", description = "Atualizar instrutor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> updateInstrutor(@PathVariable Integer id, @RequestBody Instrutor instrutor){
        Instrutor instrutorAtualizada = instrutorService.updateInstrutor(id, instrutor);
        if(instrutorAtualizada != null) {
            return new ResponseEntity<>(instrutorAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @Operation(summary = "Deletar instrutor", description = "Deletar instrutor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    @DeleteMapping("/{id}")
    public  ResponseEntity<Boolean> deleteInstrutor(@PathVariable Integer id) {
        if(instrutorService.deleteInstrutor(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }
}
