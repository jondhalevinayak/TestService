package com.testSevice.controller;

import com.testSevice.TestSeviceApplication;
import com.testSevice.model.Book;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.testSevice.util.TestUtil.asJsonString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {TestSeviceApplication.class})
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Order(1)
    @Test
    void saveBook() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(dateFormat.format(new Date()));
        Book book = Book.builder().title("Spring111 in action")
                .pages(100).author("Vinayak").createTs(date).build();

        mockMvc.perform(post("/api/book").content(asJsonString(book))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isCreated());
    }

    @Order(2)
    @Test
    void getAllBooks() throws Exception {
        mockMvc.perform(get("/api/books").accept(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isOk());
    }

    @Order(3)
    @Test
    void updateBook() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(dateFormat.format(new Date()));
        Book book = Book.builder().id(1).title("Spring113 in action")
                .pages(100).author("Vinayak").createTs(date).build();
        mockMvc.perform(put("/api/book").content(asJsonString(book)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

    }

    @Order(4)
    @Test
    void deleteBook() throws Exception {
        mockMvc.perform(delete("/api/book/2")).andDo(print()).andExpect(status().isOk());
    }


}