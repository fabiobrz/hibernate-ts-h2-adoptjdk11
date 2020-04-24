package org.jboss.repro.h8.orm.ts.h2;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.H2Dialect;

public interface DefaultDialect {

    Dialect DIALECT = new H2Dialect();
}
