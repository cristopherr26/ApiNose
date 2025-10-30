package co.edu.uco.nose.business.assembler.entity;

import java.util.List;

public interface EntityAssembler <E, D>{
	
	E toEntity(D domain);
	
	D toDomain(E entity);
	
	List<D> toDomain(List<E> entityList);
	
	

}
