package com.satya.springboot.jdbi;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.OutParameters;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

// Please check http://jdbi.org/ for more examples

@Repository
public class UserDao {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    public List<User> list(){
        Connection conn =  DataSourceUtils.getConnection(dataSource);
        Handle handle = DBI.open(conn);
        UserSQLs userQLs = handle.attach(UserSQLs.class);
        return userQLs.list();
    }

    public Integer insert(User item){
        Connection conn =  DataSourceUtils.getConnection(dataSource);
        Handle handle = DBI.open(conn);
        UserSQLs userSQLs = handle.attach(UserSQLs.class);
        return userSQLs.insert(item);
    }
    
    public String getUserById(int userId) {
    	Connection conn =  DataSourceUtils.getConnection(dataSource);
        Handle handle = DBI.open(conn);
        Query query = handle.createQuery("SELECT name from users WHERE id=:userId").mapTo(String.class);
        query.bind("userId", userId);
		return (String) query.first();
	}
    
    public Integer getSum(int a, int b) {
    	Connection conn =  DataSourceUtils.getConnection(dataSource);
        Handle handle = DBI.open(conn);
    	OutParameters result = handle
    	        .createCall("{:sum = call add_demo(:a, :b)}") 
    	        .bind("a", a) 
    	        .bind("b", b) 
    	        .registerOutParameter("sum", Types.INTEGER)   
    	        .invoke(); 
		return result.getInt("sum");
	}

    @RegisterMapper(UserMapper.class)
    interface UserSQLs {
        @SqlQuery("select * from users")
        List<User> list();

        @SqlUpdate("insert into users (name) values(:name) ")
        @GetGeneratedKeys
        Integer insert(@BindBean User test);
    }

    public static class UserMapper implements ResultSetMapper<User> {
        @Override
        public User map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
            User bean = new User();
            bean.setId((Integer) r.getObject("id"));
            bean.setName(r.getString("name"));
            return bean;
        }
    }

}
