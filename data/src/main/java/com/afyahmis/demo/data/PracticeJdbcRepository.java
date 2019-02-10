package com.afyahmis.demo.data;

import com.afyahmis.demo.core.interfaces.DbConnection;
import com.afyahmis.demo.core.interfaces.PracticeRepository;
import com.afyahmis.demo.core.model.Practice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PracticeJdbcRepository implements PracticeRepository {

    private final DbConnection dbConnection;

    public PracticeJdbcRepository(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public void create(Practice practice) throws Exception {
        String insertTableSQL = "insert into practices(code,name) values(?,?)";

        PreparedStatement statement = this.dbConnection.getConnection().prepareStatement(insertTableSQL);
        statement.setLong(1, practice.getCode());
        statement.setString(2, practice.getName());
        statement.executeUpdate();
    }

    @Override
    public void update(Practice practice) throws Exception {
        String insertTableSQL = "update practices"
                + " set name=?"
                + " where code=?";

        PreparedStatement statement = this.dbConnection.getConnection().prepareStatement(insertTableSQL);
        statement.setLong(2, practice.getCode());
        statement.setString(1, practice.getName());
        statement.executeUpdate();

    }

    @Override
    public void delete(long code) throws Exception {
        String insertTableSQL = "delete from practices where code=?";

        PreparedStatement statement = this.dbConnection.getConnection().prepareStatement(insertTableSQL);
        statement.setLong(1, code);
        statement.executeUpdate();
    }

    @Override
    public Practice get(long code) throws Exception {

        List<Practice> practices = new ArrayList<>();
        String insertTableSQL = "select * from practices where code=?";

        PreparedStatement statement = this.dbConnection.getConnection().prepareStatement(insertTableSQL);
        statement.setLong(1, code);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            practices.add(new Practice(resultSet.getLong("code"), resultSet.getString("name")));
        }

        return practices.size() > 0 ? practices.get(0) : null;
    }

    @Override
    public List<Practice> getAll() throws Exception {
        List<Practice> practices=new ArrayList<>();
        String insertTableSQL = "select * from practices";


        Statement statement = this.dbConnection.getConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(insertTableSQL);
        while (resultSet.next())
        {
            practices.add(new Practice(resultSet.getLong("code"),resultSet.getString("name")));
        }

        return practices;
    }

    @Override
    public void execute(String query) throws Exception {


       Statement statement = this.dbConnection.getConnection().createStatement();

        statement.execute(query);

    }
}
