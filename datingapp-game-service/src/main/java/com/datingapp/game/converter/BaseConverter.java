package com.datingapp.game.converter;

import com.datingapp.game.data.dto.BaseDto;
import com.datingapp.game.data.entity.BaseEntity;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

public abstract class BaseConverter<T extends BaseDto, E extends BaseEntity> {

    public abstract T toDto(E entity);

    public abstract E toEntity(T dto);

}
