package com.bootcamp.framework.runner;

import com.bootcamp.framework.selenium.Selenium;
import com.bootcamp.framework.web.Browser;
import pageObjects.PageObjectBase;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Colegio on 27/12/2016.
 */
public class GenericWebAutomationTest<T extends PageObjectBase> {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(Selenium.SERVER::stop));
    }

    private T startingPage;

    @SuppressWarnings("unchecked")
    private Class<T> getParameterizedType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    protected T getStartingPage() {
        return startingPage;
    }

    public void setUp(Browser browser){

    }




}
