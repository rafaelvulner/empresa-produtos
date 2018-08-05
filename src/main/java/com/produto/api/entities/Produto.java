package com.produto.api.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produto {
	
	@Id
	private Long codProduto;
	
	private String descProduto;
	
	private BigDecimal valorUnitario;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar  dataCricao;

	
	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Calendar getDataCricao() {
		return dataCricao;
	}

	public void setDataCricao(Calendar dataCricao) {
		this.dataCricao = dataCricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProduto == null) ? 0 : codProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codProduto == null) {
			if (other.codProduto != null)
				return false;
		} else if (!codProduto.equals(other.codProduto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [codProduto=" + codProduto + ", descProduto=" + descProduto + ", valorUnitario=" + valorUnitario
				+ ", dataCricao=" + dataCricao + "]";
	}
	
	
	
	

}
