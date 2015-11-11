package org.agilar.csd.oop.exceptions;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GoodExceptionHandling {

	public void pruebaExcepciones(String fichero) throws Exception {
		FileInputStream fin = new FileInputStream(fichero);
		// HACER COSAS CON EL FICHERO
	}

	public void parseQueryResults(Connection con, String query) throws SQLException {

		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// HACER COSAS CON EL RESULTADO
			}
		} finally {
			stmt.close();
		}
	}
}
