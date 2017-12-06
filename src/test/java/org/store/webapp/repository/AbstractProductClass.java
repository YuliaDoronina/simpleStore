package org.store.webapp.repository;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"})
@Sql(scripts = {"classpath:db/createDB.sql", "classpath:db/initDB.sql"})
public class AbstractProductClass extends ProductServiceTest{
}
