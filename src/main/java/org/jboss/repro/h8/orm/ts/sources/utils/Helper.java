package org.jboss.repro.h8.orm.ts.sources.utils;

import java.util.Map;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/**
 * Centralized utility functionality
 *
 * @author Steve Ebersole
 */
public final class Helper {

    /**
     * @see #createH2Schema(String, Map)
     */
    public static void createH2Schema(String schemaName, Configuration cfg) {
        createH2Schema( schemaName, cfg.getProperties() );
    }

    /**
     * Create additional H2 schema.
     *
     * @param schemaName New schema name.
     * @param settings Current settings.
     */
    public static void createH2Schema(String schemaName, Map settings) {
        settings.put(
                Environment.URL,
                settings.get( Environment.URL ) + ";INIT=CREATE SCHEMA IF NOT EXISTS " + schemaName
        );
    }
}