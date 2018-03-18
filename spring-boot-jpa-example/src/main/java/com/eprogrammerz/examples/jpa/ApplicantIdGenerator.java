package com.eprogrammerz.examples.jpa;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicantIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
        String prefix = "I-";
        Connection connection = session.connection();
        try(PreparedStatement ps = connection
                .prepareStatement("SELECT MAX(id) AS id FROM applicant");ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int id = rs.getString("id") != null? Integer.valueOf(rs.getString("id").split("-")[1]) + 1 : 0;
                String code = prefix + id;
                System.out.println("Generated Stock Code: " + code);
                return code;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}