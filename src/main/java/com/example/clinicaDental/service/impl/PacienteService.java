package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.PacienteDTO;
import com.example.clinicaDental.entity.Paciente;
import com.example.clinicaDental.repository.IPacienteRepository;
import com.example.clinicaDental.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    // reemplaza al
    // private static IDao<Paciente> pacienteDao = new PacienteDao();
    @Autowired
    IPacienteRepository pacienteRepository;

    /* reemplaza a
    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public void setpacienteDao( IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }*/
    @Autowired
    ObjectMapper mapper;

    @Override
    public void cargarPaciente(PacienteDTO pacienteDTO){
        // como recibo un pacienteDTO, debo mappear el objeto antes de poder cargarlo
        // el mapper sirve para asignar los valores del dto al paciente
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public PacienteDTO buscarPaciente(Long id){
        PacienteDTO pacienteDTO = null;
        // lo hace opcional porque puede ser nulo
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()){
            // para convertir un paciente a un pacienteDTO
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public Collection<PacienteDTO> listarPacientes(){
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        List<Paciente> pacientes = pacienteRepository.findAll();
        for (Paciente paciente:
                pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public void actualizarPaciente(Paciente paciente){
        // en este caso pasamos el paciente completo ya que necesitamos el id para actualizar
        pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }
}
