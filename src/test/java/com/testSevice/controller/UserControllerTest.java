package com.testSevice.controller;

import com.testSevice.TestSeviceApplication;
import com.testSevice.model.Address;
import com.testSevice.model.Users;
import com.testSevice.util.TestUtil;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {TestSeviceApplication.class})
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Order(1)
    @Test
    public void saveUser() throws Exception {
        HashSet<Address> set = new HashSet<>();
        set.add(Address.builder().sreet1("steet1").street2("street2").build());
        Users user = Users.builder().name("Varad").age(4)
                .addresses(set).build();
        mockMvc.perform(post("/api/users").content(TestUtil.asJsonString(user))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Order(2)
    @Test
    public void getAllUsers() throws Exception {
        mockMvc.perform(get("/api/users").accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }
}