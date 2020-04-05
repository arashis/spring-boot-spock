package com.example.springbootmysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    /*
     * テーブルのIDカラム
     * */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer bookId;

    private String title;

    private String description;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean deleteFlag;
}
