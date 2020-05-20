package com.uca.capas.domain;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Table(schema="public",name="public_importancia")
public class Importancia {

	@Id
	@Column(name="c_Importancia")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoImportancia;
	
	
	@OneToMany(mappedBy="importancia", fetch = FetchType.EAGER)
	private List<Contribuyente> contribuyentes;
	
	@Column(name="s_Importancia")
	private String importancia;

	public Integer getCodigoImportancia() {
		return codigoImportancia;
	}

	public void setCodigoImportancia(Integer codigoImportancia) {
		this.codigoImportancia = codigoImportancia;
	}

	public List<Contribuyente> getContribuyentes() {
		return contribuyentes;
	}

	public void setContribuyentes(List<Contribuyente> contribuyentes) {
		this.contribuyentes = contribuyentes;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}
	
	
	
}
