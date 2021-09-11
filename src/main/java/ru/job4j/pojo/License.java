package ru.job4j.pojo;

import java.util.Date;
import java.util.Objects;

/**
 * 1.2.3.Инкапсуляция
 * 2.Модель данных.[#174683#127064]пример
 * 4.Сравнение моделей.Метод equals[#174893#127069]
 * @since 11.09.2021
 */
public class License {

    private String owner;
    private String model;
    private String code;
    private Date created;

    public License() {
    }

    public License(String owner, String model, String code, Date created) {
        this.owner = owner;
        this.model = model;
        this.code = code;
        this.created = created;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        License license = (License) o;
        return Objects.equals(owner, license.owner) && Objects.equals(model, license.model) && Objects.equals(code, license.code) && Objects.equals(created, license.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, model, code, created);
    }
}
