package org.jboss.repro.h8.orm.ts.h2.typeoverride;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.jboss.repro.h8.orm.ts.sources.typeoverride.StoredPrefixedStringType;
import org.jboss.repro.h8.orm.ts.sources.typeoverride.model.Entity;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ProgrammaticallyConfiguredEntityTestService extends ProgrammaticallyConfiguredTestService<Entity>
{
    @Override
    protected void configure(Configuration cfg) {
        cfg.registerTypeOverride( StoredPrefixedStringType.INSTANCE );
    }

    @Override
    protected String[] getMappings() {
        return new String[] { "Entity.hbm.xml" };
    }

    @Override
    protected Entity doTestInsert() {
        Session s = openSession();
        s.getTransaction().begin();
        Entity e = new Entity( "name" );
        s.save( e );
        s.getTransaction().commit();
        s.close();

        s = openSession();
        s.getTransaction().begin();
        e = ( Entity ) s.get( Entity.class, e.getId() );
        //___assertFalse( e.getName().startsWith( StoredPrefixedStringType.PREFIX ) );
        //___assertEquals( "name", e.getName() );
        s.delete( e );
        s.getTransaction().commit();
        s.close();
        return e;
    }
}
