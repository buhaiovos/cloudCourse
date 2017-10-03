package osb.test;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class TestConnection {


    @Test
    public void retrievedConnectionIsNotNull() throws SQLException, URISyntaxException {
//        System.setProperty("DATABASE_URL", "jdbc:postgresql://ec2-50-17-203-195.compute-1.amazonaws.com:5432/dbor3ci1tlb8a9?user=rkzhwbnwnffqqz&password=589eef7a8229f62f4f6e82c9f8837eb1dbcbf7bfab43b82cd3c9301571f6d646&sslmode=require");

        String dbUrl = "jdbc:postgresql://ec2-50-17-203-195.compute-1.amazonaws.com:5432/dbor3ci1tlb8a9?user=rkzhwbnwnffqqz&password=589eef7a8229f62f4f6e82c9f8837eb1dbcbf7bfab43b82cd3c9301571f6d646&sslmode=require";

        assertNotNull(DriverManager.getConnection(dbUrl));
    }
// postgres://rkzhwbnwnffqqz:589eef7a8229f62f4f6e82c9f8837eb1dbcbf7bfab43b82cd3c9301571f6d646@ec2-50-17-203-195.compute-1.amazonaws.com:5432/dbor3ci1tlb8a9
}
