package org.store.webapp.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.store.webapp.model.Subcategory;
import org.store.webapp.web.WebTest;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.store.webapp.DataClass.*;

public class RestSubcategoryControllerTest extends WebTest{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/rest/subcategories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string(objectMapper.writeValueAsString(Arrays.asList(SUBCATEGORY1, SUBCATEGORY2))))
                .andDo(print());
    }

    @Test
    public void getById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/rest/subcategories/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andReturn();

        Subcategory subcategory = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Subcategory.class);
        Assert.assertEquals(SUBCATEGORY1, subcategory);
    }

    @Test
    public void create() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/rest/subcategories")
                .content(objectMapper.writeValueAsString(new Subcategory("/", 1)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andReturn();

        Subcategory subcategory = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Subcategory.class);
        Assert.assertEquals(SUBCATEGORY3, subcategory);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }
}