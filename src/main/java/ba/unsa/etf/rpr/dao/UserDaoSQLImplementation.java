package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserDaoSQLImplementation extends AbstractDao<User> implements UserDao {

    private static UserDaoSQLImplementation instance = null;
    public static UserDaoSQLImplementation getInstance(){
        if(instance == null) instance = new UserDaoSQLImplementation();
        return instance;
    }
    public static void removeInstance() {
        if(instance!=null) instance = null;
    }
    public UserDaoSQLImplementation(){
        super("User");
    }
    @Override
    public List<User> searchByFirstName(String firstName) throws ProjectException {
        return executeQuery("select * from User where firstName LIKE concat('%',?,'%')",new Object[]{firstName});
    }

    @Override
    public List<User> searchByLastName(String lastName) {
        return executeQuery("select * from User where lastName LIKE concat('%',?,'%')",new Object[]{lastName});
    }

    @Override
    public User searchByUsername(String username) throws ProjectException {
        return executeQueryUnique("select * from User where username = ?",new Object[]{username});

    }
    @Override
    public User row2object(ResultSet rs) throws ProjectException {
        try{
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setFirstName(rs.getString("firstName"));
            u.setLastName(rs.getString("lastName"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setUserName(rs.getString("username"));
            return u;
        } catch (SQLException e) {
            throw new ProjectException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String,Object> map = new TreeMap<>();
        map.put("id",object.getId());
        map.put("firstName",object.getFirstName());
        map.put("lastName",object.getLastName());
        map.put("email",object.getEmail());
        map.put("username",object.getUserName());
        map.put("password",object.getPassword());
        return map;
    }
}
