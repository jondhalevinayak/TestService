package com.testSevice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.testSevice.error.Name;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @NotNull
    @NotEmpty
    @Name
    @Size(min = 2, max = 50, message = "Length should be within range")
    public String title;


    public Integer pages;

    @NotNull
    @NotEmpty
    public String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createTs;

    public Date getCreateTs() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(dateFormat.format(this.createTs));
        } catch (ParseException ex) {
            log.error("Parse exception");
        }

        return date;
    }


}
