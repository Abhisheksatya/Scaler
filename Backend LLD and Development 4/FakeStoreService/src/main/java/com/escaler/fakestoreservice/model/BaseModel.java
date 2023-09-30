package com.escaler.fakestoreservice.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
public class BaseModel {
    private Long id;
    private Date createAt;
    private Date lastUpdateAt;
    private boolean isDeleted;

}
