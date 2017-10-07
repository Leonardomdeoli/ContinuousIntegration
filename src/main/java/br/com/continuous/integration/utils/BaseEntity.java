package br.com.continuous.integration.utils;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Leonardo Mendes
 *
 */
public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistable<ID> {

	private static final long serialVersionUID = 201505091502L;

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public void setId(ID id) {
		super.setId(id);
	}

	@Override
	@JsonIgnore
	public boolean isNew() {
		return null == this.getId();
	}

}
