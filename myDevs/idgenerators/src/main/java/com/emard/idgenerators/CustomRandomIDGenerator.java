package com.emard.idgenerators;

import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomIDGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor si, Object obj) 
    throws HibernateException {
        Random random = new Random();
        Long id = random.nextLong(1000000);
        return id;
    }
    
}
