package com.example.clinicaDental.service;

import com.example.clinicaDental.dto.PacienteDTO;
import com.example.clinicaDental.entity.Paciente;

import java.util.*;

public interface IPacienteService {
    public void cargarPaciente(PacienteDTO pacienteDTO);

    public PacienteDTO buscarPaciente(Long id);

    public Collection<PacienteDTO> listarPacientes();

    public void actualizarPaciente(Paciente paciente);

    public void eliminarPaciente(Long id);
}
