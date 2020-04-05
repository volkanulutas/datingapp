package com.datingapp.matching.controller;


import com.datingapp.matching.data.dto.BaseDto;
import com.datingapp.matching.data.entity.BaseEntity;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public abstract class BaseConverter<T extends BaseDto, E extends BaseEntity> {

    public abstract T toDto(E entity);

    public abstract E toEntity(T dto);
}
