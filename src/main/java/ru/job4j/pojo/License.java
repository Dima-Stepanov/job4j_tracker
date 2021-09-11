package ru.job4j.pojo;

import java.util.Date;

/**
 * 1.2.3.Инкапсуляция
 * 2.Модель данных.[#174683#127064]пример
 *
 * @since 11.09.2021
 */
public class License {

    private String owner;
    private String model;
    private String code;
    private Date created;

    public String getOwner() {
        return owner;
    }

    public License setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getModel() {
        return model;
    }

    public License setModel(String model) {
        this.model = model;
        return this;
    }

    public String getCode() {
        return code;
    }

    public License setCode(String code) {
        this.code = code;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public License setCreated(Date created) {
        this.created = created;
        return this;
    }
}
