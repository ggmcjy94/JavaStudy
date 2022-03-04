package back.exception;

import java.sql.*;
//https://github.com/ByungJun25/study/tree/main/java/whiteship-study/9week
// java 및 spring unchecked, checked exception 에 대한 roll-back 에 오해
public class JdbcConnect {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:mem:";
        Connection con = DriverManager.getConnection(url);
        con.setAutoCommit(false); // auto commit을 비활성화 합니다.
        try (Statement stm = con.createStatement()) {
            stm.execute("CREATE TABLE TEST (id INTEGER not NULL, value VARCHAR(255), PRIMARY KEY(id))");
            JdbcConnect.insert(con, 1, "test1"); // test1 데이터를 추가
            JdbcConnect.createRuntimException(); // 런타임 예외 발생
            JdbcConnect.insert(con, 2, "test2");
            con.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException 발생");
//            con.rollback();  // 만약 여기에 주석을 지우고 rollback을 호출한다면 test1이 입력되지 않습니다.
        } catch (Exception exception) {
            System.out.println("Exception 발생");
        }

        try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM TEST")) {
            while (rs.next()) {
                String value = rs.getString("value");
                System.out.println("Value: " + value); // test1이 출력됩니다.
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException 발생");
        } catch (Exception exception) {
            System.out.println("Exception 발생");
        }

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void insert(Connection con, int id, String value) throws SQLException {
        final String query = "INSERT INTO TEST VALUES (" + id + ", '" + value + "')";
        con.prepareStatement(query).executeUpdate();
    }

    public static void insert(Statement stm, int id, String value) throws SQLException {
        stm.execute("INSERT INTO TEST VALUES (" + id + ", '" + value + "')");
    }

    public static void createRuntimException() {
        throw new RuntimeException();
    }

    public static void createException() throws Exception {
        throw new Exception();
    }
}
