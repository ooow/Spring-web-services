package com.nc.model;

import com.nc.exception.SalaryTypeException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.math.BigDecimal;

/**
 * Created by Гога on 11.04.2016.
 */
@Entity
@Table(name = "positions", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Position extends Model {
    @Column
    private String title;
    @Column(name = "stype")
    private String salaryType;
    @Column
    private BigDecimal salary;

    public Position() {
        super();
    }

    public Position(Long id) {
        super(id);
    }

    public Position(String title, String salaryType, BigDecimal salary) throws SalaryTypeException {
        if ("dinamic".equals(salaryType) || "static".equals(salaryType)) {
            this.salaryType = salaryType;
            this.title = title;
            this.salary = salary;
        } else throw new SalaryTypeException("Please enter salaru type \"dinamic\" or \"static\"");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "    title: " + title + "\n" +
                "    salaryType: " + salaryType + "\n" +
                "    salary: " + salary.toString();
    }

}
