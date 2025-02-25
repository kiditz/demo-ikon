package com.test.demo.setting;

import org.mapstruct.MappingTarget;

public interface Mapping<EN, D, C,U> {

	void update(@MappingTarget EN target, U dataObject);

//	EN toEntity(U dataObject);
//	EN fromUpdateCommand(U dataObject);
	EN fromCreateCommand(C dataObject);


	D toDto(EN entity);

//	Collection<EN> toEntities(Collection<D> dataObjects);

//	List<D> toDtos(List<EN> entities);

}
