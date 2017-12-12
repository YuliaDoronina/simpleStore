package org.store.webapp.web.ui.roleadmin;

import org.junit.Test;
import org.store.webapp.web.WebTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoryControllerTest extends WebTest {
    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/admin/categories"))
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(forwardedUrl("/WEB-INF/jsp/admin/categoryList.jsp"))
                .andDo(print());
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(get("/admin/categories/delete").param("id", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/categories"))
                .andDo(print());
    }

    @Test
    public void update() throws Exception {
    }

}