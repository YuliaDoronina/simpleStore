package org.store.webapp.web;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/*TODO: complete all rest tests: update, delete*/
/*TODO: complete all ui tests*/
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-mvc.xml",
        "classpath:spring/spring-db.xml",})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = {"classpath:db/initDB.sql", "classpath:db/fillDBforTest.sql"})
public abstract class WebTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }
}
