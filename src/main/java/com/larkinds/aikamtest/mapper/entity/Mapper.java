package com.larkinds.aikamtest.mapper.entity;

import com.larkinds.aikamtest.dto.model.BaseEntityDto;
import com.larkinds.aikamtest.model.BaseEntity;

import java.util.List;

public interface Mapper<E extends BaseEntity, D extends BaseEntityDto>  {
    /**'
     * Maps a DTO inherited from BaseEntityDto class to an entity inherited from BaseEntity class
     * @param dto instance of Dto
     * @return isntance of Entity
     */
    E toEntity(D dto);

    /**
     * Maps entity inherited from BaseEntity class to a DTO inherited from BaseEntityDto class
     * @param entity instance of Entity
     * @return instance of Dto
     */
    D toDto(E entity);

    /**
     * Maps list of entities iherited from BaseEntity class to list of DTOs inherited from BaseEntityDto class
     * @param dtoList list of DTOs
     * @return list of entities
     */
    List<E> toEntityList(List<D> dtoList);

    /**
     * Maps list of DTOs inherited from BaseEntityDto class to list of entitites inherited from BaseEntity class
     * @param entityList list of entities
     * @return list of DTOs
     */
    List<D> toDtoList(List<E> entityList);
}
