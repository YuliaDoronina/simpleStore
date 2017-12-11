package org.store.webapp.util;

public class ExceptionCheck {

    public ExceptionCheck() {
    }

    public static <T> T check(T entity, Integer id) {
        if (entity == null) {
            throw new NotFoundException("Not found entity with id = " + id);
        }
        return entity;
    }
}
