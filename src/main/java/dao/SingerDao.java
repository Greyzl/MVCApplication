package dao;

import entity.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();
//    List<Singer> findAllByFirstName(String firstName);
//    String findLastNameById(Long id);
    String findFirstNameByID(Long id);
    void insert (Singer singer);
//    void update (Singer singer);
    void delete (Long id);
//    List<Singer> findAllWithDetail();
//    void insertWithDetail(Singer singer);
}
