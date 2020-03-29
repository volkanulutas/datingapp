package com.datingapp.auth.converter;


import com.datingapp.auth.data.dto.BaseDto;
import com.datingapp.auth.data.entity.BaseEntity;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public abstract class BaseConverter<T extends BaseDto, E extends BaseEntity> {

    public abstract T toDto(E entity);

    public abstract E toEntity(T dto);
}
