package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //1.ͨ��ע�ⶨ��һ��Dao
public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired //2.�Զ�ע��һ��JdbcTemplate��bean
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getMatchAccount(String userName,String password) {
		String sql = "select count(*) from t_user where user_name=? and password=?";
		int num = jdbcTemplate.queryForObject(sql,new Object[] {userName,password},Integer.class);
		return num;
	}
	
}
