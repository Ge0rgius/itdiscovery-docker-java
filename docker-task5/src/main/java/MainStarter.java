import java.sql.*;

public class MainStarter {
	private static final String url = "jdbc:mysql://mysql:3306/discovery?useSSL=false&allowPublicKeyRetrieval=true";
	private static final String user = "root";
	private static final String password = "root";

	public static void main(String args[]) {
		String query = "select name from greeting";

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			try (Statement st = conn.createStatement()) {

				try (ResultSet rs = st.executeQuery(query)) {

					while (rs.next()) {
						String greeting = rs.getString("name");
						System.out.println(greeting);
					}
				}
			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

}