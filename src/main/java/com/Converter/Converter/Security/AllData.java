package com.Converter.Converter.Security;

import java.sql.*;
import java.util.ArrayList;

public class AllData  {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "pass";
    private static final String DB_URL = "jdbc:postgresql://localhost:5433/currency";

    public static Object GetAllData() throws SQLException {


          try {
              Connection connection = DriverManager.getConnection( DB_URL, DB_USERNAME, DB_PASSWORD);
              PreparedStatement  statement = connection.prepareStatement("SELECT name FROM valuta");

              ResultSet result = statement.executeQuery();

              while (result.next()){
                  result.getString("name");
              }

          } catch (Exception e){
              System.out.println(e);
          }
        return null;
    }


}
