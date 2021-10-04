package com.Converter.Converter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "vitusja3105";
    private static final String DB_URL = "jdbc:postgresql://localhost:5433/currency";


    public static void insert(int id, String time, String rate, String currency, String[] country) throws Exception {


        Connection connection = DriverManager.getConnection( DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        //connection.close();

        int idRateCurrecy = id - 1;
        System.out.println( idRateCurrecy );
        for(int i = 1; i < 33; i++){

                //System.out.println( idRateCurrecy );
                statement.executeUpdate("update valuta set date='"+time+"' where vid ='"+i+"'");

            if(currency != "" && rate != ""){
                //System.out.println( idRateCurrecy + " " + rate + currency );
                statement.executeUpdate("update valuta set code='"+currency+"', rate='"+rate+"' where vid ='"+idRateCurrecy+"'");
                return;
            }

            for(int j = 0; j <= 32; j++){
                //System.out.println(id++ +""+ country[j]);
                statement.executeUpdate("update valuta set name='"+country[j]+"' where vid ='"+id++ +"'");
            }

        }

    }
}
