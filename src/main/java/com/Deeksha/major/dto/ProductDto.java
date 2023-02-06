package com.Deeksha.major.dto;

import com.Deeksha.major.model.Category;
import lombok.Data;

import javax.persistence.*;

@Data
public class ProductDto {

    private Long id;

    private String name;

    private int categoryId;
    private double price;
    private double weight;

    private String description;
    private String imageName;
}
