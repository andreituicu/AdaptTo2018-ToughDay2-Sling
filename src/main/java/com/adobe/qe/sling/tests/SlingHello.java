/*
Copyright 2018 Adobe

All Rights Reserved.
NOTICE: Adobe permits you to use, modify, and distribute this file in
accordance with the terms of the Adobe license agreement accompanying
it. If you have received this file from a source other than Adobe,
then your use, modification, or distribution of it requires the prior
written permission of Adobe.
*/
package com.adobe.qe.sling.tests;

import com.adobe.qe.sling.tests.sequential.SlingTestBase;
import com.adobe.qe.toughday.api.annotations.*;
import com.adobe.qe.toughday.api.core.AbstractTest;
import com.adobe.qe.toughday.api.core.FluentLogging;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Level;

public class SlingHello extends SlingTestBase {

    private String path;

    public SlingHello() {}

    public SlingHello(String path) {
        this.path = path;
    }


    @Setup
    public final void setup() {
        logger().info("Executing Setup...");
    }

    @Before
    public final void before() {
        logger().info("Executing Before...");
    }

    @Override
    public void test() throws Throwable {
        FluentLogging.create(logger())
                .before(Level.INFO, "Executing GET request to " + path)
                .onThrowable(Level.ERROR, "Error occured", true)
                .onSuccess(Level.INFO, "Request executed successfully")
                .run(() -> benchmark().measure(this, "Request", getDefaultClient()).doGet(path, HttpStatus.SC_OK));
    }

    @After
    public final void after() {
        logger().info("Executing After...");
    }

    @Override
    public AbstractTest newInstance() {
        return new SlingHello(path);
    }

    @ConfigArgSet(required = false, defaultValue = "/content.html", desc = "Path to where the get request should be done")
    public void setPath(String path) {
        this.path = path;
    }

    @ConfigArgGet
    public String getPath() {
        return path;
    }
}
