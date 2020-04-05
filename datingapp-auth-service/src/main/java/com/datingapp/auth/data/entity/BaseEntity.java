package com.datingapp.auth.data.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class BaseEntity implements Serializable {
    @Id
    private String id;
}
