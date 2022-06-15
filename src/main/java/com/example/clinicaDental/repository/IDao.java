package com.example.clinicaDental.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDao<T> {
    public T cargar(T t);
    public void eliminar(Long id);
    public T buscar(Long id);
    public List<T> buscarTodos();
}
