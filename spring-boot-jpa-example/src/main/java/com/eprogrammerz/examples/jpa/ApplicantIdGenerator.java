package com.eprogrammerz.examples.jpa;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.internal.SessionImpl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.IllegalFormatException;

public class ApplicantIdGenerator implements IdentifierGenerator {

    @Override
    public synchronized Serializable generate(SessionImplementor session, Object o) throws HibernateException {
        if(!(o instanceof Applicant)) {
            throw new IllegalArgumentException("Invalid class");
        }
        final Applicant applicant = (Applicant) o;
        String prefix = "I-";
        Connection connection = session.connection();
        try (PreparedStatement ps = connection
                .prepareStatement("SELECT MAX(id) AS id FROM APPLICANT for update"); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
//                int id = rs.getString("id") != null ? Integer.valueOf(rs.getString("id").split("-")[1]) + 1 : 1;
                int id = rs.getInt("id") + 1;
                String code = prefix + id;
                System.out.println("Generated Stock Code: " + code);
                applicant.setApplicantId(code);
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.flush();
        return null;
    }
}