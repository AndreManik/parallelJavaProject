package ru.parallelProject.parallel.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionUtil.class);

    public static void check(boolean found, int id) {
        check(found, "id" + id);
    }

    public static void check(boolean found, String msg) {
        if (!found) throw new NotFoundException("Not found entity with " + msg);
    }

    public static <T> T check (T object, int id) {
        return check(object, "id = " + id);
    }

    public static <T> T check (T object, String msg) {
        if (object == null) throw new NotFoundException("Not found entity with " + msg);
        return object;
    }
}
