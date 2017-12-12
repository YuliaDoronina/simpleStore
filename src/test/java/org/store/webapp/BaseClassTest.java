package org.store.webapp;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"})
@Sql(scripts = {"classpath:db/initDB.sql", "classpath:db/fillDBforTest.sql"})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class BaseClassTest {
}
