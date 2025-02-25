package com.test.demo.setting;

import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

public interface Mapping<EN, D, C,U> {

	void update(@MappingTarget EN target, U dataObject);

	EN toEntity(U dataObject);
	EN fromUpdateCommand(U dataObject);
	EN fromCreateCommand(C dataObject);


	D toDto(EN entity);

	Collection<EN> toEntities(Collection<D> dataObjects);

	List<D> toDtos(List<EN> entities);

}
