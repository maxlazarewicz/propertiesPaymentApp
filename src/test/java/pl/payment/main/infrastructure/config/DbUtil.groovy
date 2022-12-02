package pl.payment.main.infrastructure.config

import java.sql.Connection
import java.sql.DriverManager


class DbUtil {

    private static final String CONNECTION_URL = "jdbc:h2:mem:cms;MODE=MYSQL;DB_CLOSE_DELAY=-1;PASSWORD=;USER=sa;DATABASE_TO_UPPER=false";

    static clearDb() {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_URL)
            conn.createStatement().execute("DROP ALL OBJECTS")
            conn.commit()
        } catch (Exception e) {
            throw e
        }
    }
}

