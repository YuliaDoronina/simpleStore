package org.store.webapp.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.store.webapp.model.Product;
import org.store.webapp.web.WebTest;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.store.webapp.DataClass.*;

public class RestProductControllerTest extends WebTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/rest/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string(objectMapper.writeValueAsString(Arrays.asList(PRODUCT1, PRODUCT2))))
                .andDo(print());
    }

    @Test
    public void getById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/rest/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andReturn();

        Product product = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Product.class);
        Assert.assertEquals(PRODUCT1, product);
    }

    @Test
    public void create() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/rest/products")
                .content(objectMapper.writeValueAsString(new Product("/", "/", "/", false, 1)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andReturn();

        Product product = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Product.class);
        Assert.assertEquals(PRODUCT3, product);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }
}