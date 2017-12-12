package org.store.webapp.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.store.webapp.model.Category;
import org.store.webapp.web.WebTest;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.store.webapp.DataClass.CATEGORY1;
import static org.store.webapp.DataClass.CATEGORY2;

public class RestCategoryControllerTest extends WebTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/rest/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string(objectMapper.writeValueAsString(Arrays.asList(CATEGORY1, CATEGORY2))))
                .andDo(print());
    }

    @Test
    public void getById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/rest/categories/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andReturn();

        Category category = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Category.class);
        Assert.assertEquals(CATEGORY1, category);
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }
}