package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //1.通过注解定义一个Dao
public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired //2.自动注入一个JdbcTemplate的bean
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getMatchAccount(String userName,String password) {
		String sql = "select count(*) from t_user where user_name=? and password=?";
		int num = jdbcTemplate.queryForObject(sql,new Object[] {userName,password},Integer.class);
		return num;
	}
	
}
