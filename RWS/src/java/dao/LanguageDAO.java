/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Language;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LanguageDAO {
    public static ArrayList<Language> retrieve(int appID) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Language> languageList = new ArrayList<Language>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from language where appID = " + appID + ";");

            while (rs != null && rs.next()) {
                String language = rs.getString(2);
                String spoken = rs.getString(3);
                String written = rs.getString(4);
                
                languageList.add(new Language(language, spoken, written));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return languageList;
    }
}
