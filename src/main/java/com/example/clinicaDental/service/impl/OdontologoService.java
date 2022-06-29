package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.OdontologoDTO;
import com.example.clinicaDental.entity.Odontologo;
import com.example.clinicaDental.repository.IOdontologoRepository;
import com.example.clinicaDental.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void cargarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if (odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public Collection<OdontologoDTO> listarOdontologos() {
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        List<Odontologo> odontologos = odontologoRepository.findAll();
        for (Odontologo odontologo :
                odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    @Override
    public void actualizarOdontologo(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }
}


