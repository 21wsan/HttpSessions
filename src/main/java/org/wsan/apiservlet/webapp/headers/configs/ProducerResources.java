package org.wsan.apiservlet.webapp.headers.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ProducerResources {

    @Resource(name="jdbc/mysqlDB")
    private DataSource ds;

    @Produces
    @RequestScoped
    //@Named("conn")    -   es reemplazado por Qualifier @MysqlConn
    @MysqlConn
    private Connection beanConnection() throws NamingException, SQLException {
        //Context initContext = new InitialContext();
        //Context envContext  = (Context)initContext.lookup("java:/comp/env");
        //DataSource ds = (DataSource)envContext.lookup("jdbc/mysqlDB");
        return ds.getConnection();
    }
}
