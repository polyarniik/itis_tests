package ru.itis.safiullin.miniplan.hw6.order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)


@Target({ ElementType.METHOD})

public @interface Order {
    public int order();
}