package com.adriano.main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adriano.main.model.Paciente;
import com.adriano.main.repository.PacienteRepository;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository PacienteRepository;

    public Paciente addPaciente(Paciente paciente){
        Paciente SalvoPaciente = PacienteRepository.save(paciente);
        return SalvoPaciente;
    }

    public List<Paciente> listaPacientes(){
        return PacienteRepository.findAll();
    }

    public Paciente atualizarPaciente (Paciente paciente){
        Paciente pacienteBD = PacienteRepository.findById(paciente.getIdPaciente()).orElse(null);
        if (pacienteBD != null) {
            pacienteBD.setEmail(paciente.getEmail());
            pacienteBD.setNome(paciente.getNome());
            return PacienteRepository.save(pacienteBD);
        }
        return null;
    }


    public void deletarPaciente (int idPaciente){
        if (PacienteRepository.existsById(idPaciente)) {
            PacienteRepository.deleteById(idPaciente);
        }
    }
}
