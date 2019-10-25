package com.company.motorcycleservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.javafx.beans.IDProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="moto_inventory")
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "9999999.99", inclusive = true)
    private BigDecimal price;
    @Column
    @NotNull
    @Size(max = 20)
    private String vin;
    @Column
    @NotNull
    @Size(max = 20)
    private String make;
    @Column
    @NotNull
    @Size(max = 20)
    private String model;
    @Column
    @NotNull
    @Size(max = 4)
    private String year;
    @Column
    @NotNull
    @Size(max = 20)
    private String color;

    public Motorcycle(int id, @NotNull @DecimalMin(value = "0.01", inclusive = true) @DecimalMax(value = "9999999.99", inclusive = true) BigDecimal price, @NotNull @Max(20) String vin, @NotNull @Max(20) String make, @NotNull @Max(20) String model, @NotNull @Max(4) String year, @NotNull @Max(20) String color) {
        this.id = id;
        this.price = price;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Motorcycle() {
    }

    public Motorcycle(@NotNull @DecimalMin(value = "0.01", inclusive = true) @DecimalMax(value = "9999999.99", inclusive = true) BigDecimal price, @NotNull @Max(20) String vin, @NotNull @Max(20) String make, @NotNull @Max(20) String model, @NotNull @Max(4) String year, @NotNull @Max(20) String color) {
        this.price = price;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return id == that.id &&
                price.equals(that.price) &&
                vin.equals(that.vin) &&
                make.equals(that.make) &&
                model.equals(that.model) &&
                year.equals(that.year) &&
                color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, vin, make, model, year, color);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "id=" + id +
                ", price=" + price +
                ", vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
