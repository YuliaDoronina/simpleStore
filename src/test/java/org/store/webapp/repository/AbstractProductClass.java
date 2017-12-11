package org.store.webapp.repository;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"})
@Sql(scripts = {"classpath:db/initDB.sql", "classpath:db/fillDB.sql"})
public class AbstractProductClass extends ProductServiceTest{
}
