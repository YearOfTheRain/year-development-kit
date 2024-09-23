package org.year.mysql.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.year.mysql.entity.User;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author YearOfTheRain
 * @create 2024-09-12  11:33
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer countAll() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<User> listAll() {
        String sql = "select id, name, age, email, created_at from user";
        return jdbcTemplate.query(sql, (rs, i) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setEmail(rs.getString("email"));
            user.setCreatedAt(LocalDateTime.parse(rs.getString("created_at"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            return user;
        });
    }

    public void update(User user) {
        String sql = "update user set name = ?, age = ?, email = ? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail(), user.getId());
    }

    public void deleteById(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Integer save(User user) {
        String sql = "insert into user(name, age, email, created_at) values(?, ?, ?, now())";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getEmail());
            return ps;
        }, keyHolder);

        Number id = keyHolder.getKey();
        assert null != id;
        return id.intValue();
    }


}
