package com.adriano.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adriano.main.model.Paciente;
import com.adriano.main.services.PacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    

    @Autowired
    PacienteService pacienteService;
    
    @PostMapping
    public Paciente adicionarUsuario(@RequestBody Paciente paciente){
        return pacienteService.addPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listarPacientes(){
        return pacienteService.listaPacientes();
    }

    @PutMapping
    public Paciente atualizPaciente(@RequestBody Paciente paciente){
        return pacienteService.atualizarPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        pacienteService.deletarPaciente(id);
    }
}
