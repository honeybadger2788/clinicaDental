package com.example.clinicaDental.service;

import com.example.clinicaDental.dto.OdontologoDTO;
import com.example.clinicaDental.entity.Odontologo;

import java.util.Collection;

public interface IOdontologoService {
    public void cargarOdontologo(OdontologoDTO odontologoDTO);

    public OdontologoDTO buscarOdontologo(Long id);

    public Collection<OdontologoDTO> listarOdontologos();

    public void actualizarOdontologo(OdontologoDTO odontologoDTO);

    public void eliminarOdontologo(Long id);
}
