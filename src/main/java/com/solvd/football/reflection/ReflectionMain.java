package com.solvd.football.reflection;

import com.solvd.football.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;

public class ReflectionMain {
    private static final Logger LOGGER = LogManager.getLogger(ReflectionMain.class);

    public static void getConstructors() {
        try {
            Class person = Person.class;
            Constructor[] constructors = Person.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                LOGGER.info("Constructor: " + constructor.getName());
                LOGGER.info("Parameters:" + constructor.getParameterCount());
            }
        } catch (Throwable e) {
            LOGGER.error(e);
        }
    }

    public static void getFields() {
        try {
            Class person = Person.class;
            Field[] fields = Person.class.getDeclaredFields();
            for (Field field : fields) {
                LOGGER.info("Fields: " + Modifier.toString(field.getModifiers()) + " - " + field.getType().getName() + " - " + field.getName());
            }
        } catch (Throwable e) {
            LOGGER.error(e);
        }
    }

    public static void getMethods() {
        try {
            Class person = Person.class;
            Method[] methods = Person.class.getDeclaredMethods();
            for (Method method : methods) {
                LOGGER.info("The method's name is: " + method.getName() + " and the method return type is " + method.getReturnType());
            }
        } catch (Throwable e) {
            LOGGER.error(e);
        }
    }

    public static void main(String[] args) {

        getConstructors();
        getFields();
        getMethods();
    }
}