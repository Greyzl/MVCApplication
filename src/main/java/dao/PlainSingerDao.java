package dao;

import entity.Singer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlainSingerDao implements SingerDao {
    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);
    static {
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            logger.error("Failed to load jdbs driver", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/SpringTest",
                "prospring5","prospring5");

    }
    private void closeConnection(Connection connection){
        if (connection == null){
            return;
        }
        try {
            connection.close();
        } catch (SQLException e){
            logger.error("Problem closing connection to the DB", e);
        }
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select " +
                    "* from musicdb.singer");
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            connection.close();
        }catch (SQLException e){
            logger.error("Error while executing");
        }finally {closeConnection(connection);
        return result;
        }
    }

//    @Override
//    public List<Singer> findAllByFirstName(String firstName) {
//        return null;
//    }
//
//    @Override
//    public String findLastNameById(Long id) {
//        return null;
//    }
//
//    @Override
//    public String findFirstNameByID(Long id) {
//        return null;
//    }
//
    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into musicdb.singer " +
                    "(first_name,last_name,birth_date) " +
                    "values (?,?,?) ",Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,singer.getFirstName());
            statement.setString(2,singer.getLastName());
            statement.setDate(3,singer.getBirthDate());

            System.out.println(statement.toString());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                singer.setId(resultSet.getLong(1));
            }
            statement.close();
        }catch (SQLException ex){
            logger.error("Error while executing INSERT",ex);
        }finally {
            closeConnection(connection);
        }
    }
//
//    @Override
//    public void update(Singer singer) {
//
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public List<Singer> findAllWithDetail() {
//        return null;
//    }
//
//    @Override
//    public void insertWithDetail(Singer singer) {


}
