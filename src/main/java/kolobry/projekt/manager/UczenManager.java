package kolobry.projekt.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kolobry.projekt.mejwen.Uczen;

public class UczenManager {

	private Connection connection;

	private final String URL = "jdbc:hsqldb:hsql://localhost/";
	private final String USERNAME = "konrad";
	private final String PASSWORD = "lol";

	private String createTableUczen = "CREATE TABLE Uczen (idUczen BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1) PRIMARY KEY,"
										+ "Imie VARCHAR(30) NOT NULL, "
										+ "nazw VARCHAR(50) NOT NULL,"
										+ "doswiadczenie VARCHAR(50) NOT NULL,"
										+ "idLekcja BIGINT FOREIGN KEY REFERENCES Lekcja(idLekcja));";

	private PreparedStatement addUczenStmt;
	private PreparedStatement deleteAllUczenStmt;
	private PreparedStatement getAllUczenStmt;
	private PreparedStatement deleteUczenStmt;

	private Statement statement;

	public UczenManager() {
		try {
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Uczen".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTableUczen);

			addUczenStmt = connection
					.prepareStatement("INSERT INTO Uczen (imie,nazw,doswiadczenie,idLekcja) VALUES (?, ?, ?, ?)");
			deleteAllUczenStmt = connection
					.prepareStatement("DELETE FROM Uczen");
			deleteUczenStmt = connection
					.prepareStatement("DELETE FROM Uczen WHERE idUczen= ? ");
			getAllUczenStmt = connection
					.prepareStatement("SELECT * FROM Uczen");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void clearUczen() {
		try {
			deleteAllUczenStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void clearUczen(long aj) {
		try {
			deleteUczenStmt.setLong(1, aj);
			deleteUczenStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addUczen(Uczen Uczen) {
		int count = 0;
		try {
			addUczenStmt.setString(1, Uczen.getImie());
			addUczenStmt.setString(2, Uczen.getNazw());
			addUczenStmt.setString(3, Uczen.getDosw());
			addUczenStmt.setLong(4, Uczen.getLekcja());

			count = addUczenStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Uczen> getAllUczen() {
		List<Uczen> Uczniowie = new ArrayList<Uczen>();

		try {
			ResultSet rs = getAllUczenStmt.executeQuery();

			while (rs.next()) {
				Uczen u = new Uczen();
				u.setIdUczen(rs.getInt("idUczen"));
				u.setImie(rs.getString("imie"));
				u.setNazw(rs.getString("nazw"));
				u.setDosw(rs.getString("doswiadczenie"));
				u.setLekcja(rs.getLong("IdLekcja"));
				Uczniowie.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Uczniowie;
	}

}
