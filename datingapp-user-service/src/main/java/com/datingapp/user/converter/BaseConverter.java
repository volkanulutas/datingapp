package com.datingapp.user.converter;


import com.datingapp.user.data.dto.BaseDto;
import com.datingapp.user.data.entity.BaseEntity;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public abstract class BaseConverter<T extends BaseDto, E extends BaseEntity> {

    public abstract T toDto(E entity);

    public abstract E toEntity(T dto);

    public E toEntity(T source, E target) {
        return null;
    }
}
