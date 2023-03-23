package com.example.demo.database;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@Repository
public interface PersonDB extends JpaRepository<Person, Integer> {

//    @Query(value = "insert into people(id, name, age)" + "VALUES (?, ?, ?)",
//            nativeQuery = true)


@Query(value = "select people.name " +
        "from people "+
        " left join school_people on school_people.peopleId = people.personId where school_people.schoolId =?",nativeQuery = true)
    public List<Person> findPeopleBySchoolId (int id);
}

//    public int create(Person value) throws DataAccessException {
//        String query = "insert into people(name, age)" + "VALUES (?, ?)";
//
//        try(PreparedStatement s = db.getDbConn().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
//            s.setString(1,value.getName());
//            s.setInt(2,value.getAge());
//
//            return db.executeInsertWithID(s);
//        } catch (SQLException e) {
//            throw new DataAccessException(e.getMessage());
//        }
//    }
//
//    @Override
//    public Person selectByID(int id) throws DataAccessException {
//        String query = "SELECT TOP 1 * FROM people WHERE id=?";
//        try(PreparedStatement s = db.getDbConn().prepareStatement(query)){
//            s.setInt(1,id);
//            ResultSet rs = db.executeSelect(s);
//            if(rs.next()){
//                return new Person(
//                        rs.getString("name"),
//                        rs.getInt("age"),
//                        rs.getInt("personId")
//                );
//            }
//        } catch (SQLException e) {
//            throw new DataAccessException(e.getMessage());
//        }
//        return null;
//    }
//
//
//    @Override
//    public List<Person> all() throws DataAccessException {
//        return null;
//    }
//
//    @Override
//    public int update(Person value) throws DataAccessException {
//        return 0;
//    }
//
//    @Override
//    public int delete(Person value) throws DataAccessException {
//        return 0;
//    }
//
//    public int insertPersonName(List<Person> name, int id) throws DataAccessException {
//        return 0;
//    }

