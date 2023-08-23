package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.sql.SQLException;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    private static UserDaoSQLImpl instance = null;
    private UserDaoSQLImpl(){
        super("User");
    }

    public static UserDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new UserDaoSQLImpl();
        return instance;
    }
    @Override
    public User row2object(ResultSet rs) throws ProjectException{
        try{
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setAddress(rs.getString("address"));
            return user;
        }catch(SQLException e){
            throw new ProjectException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row (User object){
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("firstname", object.getName());
        row.put("lastname", object.getLastName());
        row.put("email", object.getEmail());
        row.put("password", object.getPassword());
        row.put("address", object.getAddress());
        return row;
    }

    @Override
    public List<User> searchByEmail(String email) throws ProjectException{
        return executeQuery("SELECT * FROM freedb_RPRbaza555.user WHERE email = ?", new Object[]{email});
    }

}
