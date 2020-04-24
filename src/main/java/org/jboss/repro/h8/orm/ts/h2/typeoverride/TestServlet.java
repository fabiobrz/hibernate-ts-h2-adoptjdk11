/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.repro.h8.orm.ts.h2.typeoverride;

import org.jboss.repro.h8.orm.ts.sources.typeoverride.StoredPrefixedStringType;
import org.jboss.repro.h8.orm.ts.sources.typeoverride.model.Entity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Fabio Burzigotti
 * @HttpServlet}. The {@link ProgrammaticallyConfiguredEntityTestService } is injected by CDI.
 */
@SuppressWarnings("serial")
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    static String PAGE_HEADER = "<html><head><title>Hibernate ORM TypeOverride test servlet</title></head><body>";

    static String PAGE_FOOTER = "</body></html>";

    @Inject
    ProgrammaticallyConfiguredEntityTestService programmaticallyConfiguredEntityTestService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(PAGE_HEADER);

        Entity entity = null;
        try {
            entity = programmaticallyConfiguredEntityTestService.testInsert();
            writer.println("<h1>Asserting false on e.getName().startsWith( StoredPrefixedStringType.PREFIX ): " + entity.getName().startsWith( StoredPrefixedStringType.PREFIX ) + "</h1>");
            writer.println("<h1>Asserting equals on e.getName().equals( \"name\" ): " + entity.getName().equals( "name" ) + "</h1>");

        } catch (Exception e) {
            e.printStackTrace();
        }

        writer.println(PAGE_FOOTER);
        writer.close();
    }
}
