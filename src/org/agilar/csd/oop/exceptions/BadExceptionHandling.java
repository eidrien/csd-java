package org.agilar.csd.oop.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BadExceptionHandling {

	public void pruebaExcepciones(String fichero) {
		try {
			FileInputStream fin = new FileInputStream(fichero);
			// HACER COSAS CON EL FICHERO
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void parseQueryResults(Connection con, String query) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// HACER COSAS CON EL RESULTADO
			}
			stmt.close();
		} catch (SQLException e) {
			// NO HACER NADA CON LA EXCEPCION
		}

	}
}
