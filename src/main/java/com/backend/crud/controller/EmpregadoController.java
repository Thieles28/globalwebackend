package com.backend.crud.controller;

import com.backend.crud.exception.ResourceNotFoundException;
import com.backend.crud.model.Empregado;
import com.backend.crud.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class EmpregadoController {
    @Autowired
    private EmpregadoRepository empregadoRepository;

    @GetMapping("/empregado")
    public List<Empregado> todosEmpregados() {
        return empregadoRepository.findAll();
    }

    @GetMapping("/empregado/{id}")
    public ResponseEntity<Empregado> empregadoId(@PathVariable( value = "id") Long empregadoId) throws ResourceNotFoundException {
        Empregado empregado = empregadoRepository.findById(empregadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado não encontrado para esse id ::" + empregadoId));
        return ResponseEntity.ok().body(empregado);
    }

    @PostMapping("/empregado")
    public Empregado criarEmpregado(@Valid @RequestBody Empregado empregado) {
        return empregadoRepository.save(empregado);
    }

    @PutMapping("/empregado/{id}")
    public ResponseEntity<Empregado> atualizarEmpregado(@PathVariable(value = "id") Long empregadoId,
                    @Valid @RequestBody Empregado empregadoDetalhes) throws ResourceNotFoundException {
        Empregado empregado = empregadoRepository.findById(empregadoId).orElseThrow(() -> new ResourceNotFoundException("Empregado não encontrado para esse id ::" + empregadoId));
        empregado.setNome(empregadoDetalhes.getNome());
        empregado.setSobrenome(empregadoDetalhes.getSobrenome());
        empregado.setEmail(empregadoDetalhes.getEmail());
        empregado.setGenero(empregadoDetalhes.getGenero());
        empregado.setTelefone(empregadoDetalhes.getTelefone());
        empregado.setActive(empregadoDetalhes.isActive());
        final Empregado atualizarEmpregado = empregadoRepository.save(empregado);
        return ResponseEntity.ok(atualizarEmpregado);
    }

    @DeleteMapping("/empregado/{id}")
    public Map<String, Boolean> deleteEmpregado(@PathVariable(value = "id") Long empregadoId) throws ResourceNotFoundException {
        Empregado empregado = empregadoRepository.findById(empregadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado não encontrado para esse id ::" + empregadoId));
        empregadoRepository.delete(empregado);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/empregado/delete")
    public ResponseEntity<String> deleteAllCustomers() {
        System.out.println("Removendo todos empregados");

        empregadoRepository.deleteAll();

        return new ResponseEntity<>("Todos os empregados foram excluídos!", HttpStatus.OK);
    }
}
