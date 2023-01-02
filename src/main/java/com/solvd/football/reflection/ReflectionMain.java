package com.solvd.football.reflection;

import com.solvd.football.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;

public class ReflectionMain {
    private static final Logger LOGGER = LogManager.getLogger(ReflectionMain.class);

    //Using Person Class for testing

    public static void getConstructors() {
        try {
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