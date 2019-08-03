package dao;

import entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcSingerDao implements SingerDao, InitializingBean {
    private DataSource dataSource;
    private Logger logger = LoggerFactory.getLogger(JdbcSingerDao.class);
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    public void afterPropertiesSet() throws Exception{
        if (dataSource == null){
            throw new BeanCreationException("Must set dataSource on SingerDao");
        }
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select " +
                    "* from musicdb.singer");
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            connection.close();
        }catch (SQLException e){
            logger.error("Error while executing");
        }finally {
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
    @Override
    public String findFirstNameByID(Long id) {
        jdbcTemplate.queryForObject("select first_name ||' '||"+
                "last_name from singer where id = ?", new Object[]{id},String.class);
        return null;
    }
//
    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into musicdb.singer " +
                    "(first_name,last_name,birth_date) " +
                    "values (?,?,?) ", Statement.RETURN_GENERATED_KEYS);
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
        }
    }
    //
//    @Override
//    public void update(Singer singer) {
//
//    }
//
    @Override
    public void delete(Long id) {
        Connection connection = null;
        try{
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from singer where id=?");
            statement.setLong(1,id);
            statement.execute();
            statement.close();
        }catch (SQLException ex){
            logger.error("Problem while executing delete",ex);
        }
    }

}
