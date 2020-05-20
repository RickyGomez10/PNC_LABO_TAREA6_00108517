package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

public interface ContribuyenteDAO {
	
	public List<Contribuyente> findAll() throws DataAccessException;
	public void insertar(Contribuyente contribuyente) throws DataAccessException;
}
