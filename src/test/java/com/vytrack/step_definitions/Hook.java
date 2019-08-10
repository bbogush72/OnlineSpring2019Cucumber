package com.vytrack.step_definitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

    @Before (order = 2)
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println("BEFORE");

    }

    @Before (value ="@storemanager", order =1)
    public void setup2(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println("BEFORE FOR Store Manager");

    }

    @After
    public void teardown(){
        System.out.println("AFTER");



    }
}
