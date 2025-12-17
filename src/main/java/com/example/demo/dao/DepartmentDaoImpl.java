package com.example.demo.dao;

import com.example.demo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Department department) {
        String sql = "INSERT INTO department (department_name, manager_id, location_id, description) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                department.getDepartmentName(),
                department.getManagerId(),
                department.getLocationId(),
                department.getDescription());
    }

    @Override
    public Department findById(Long id) {
        String sql = "SELECT * FROM department WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new DepartmentRowMapper());
    }

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM department";
        return jdbcTemplate.query(sql, new DepartmentRowMapper());
    }

    @Override
    public void update(Department department) {
        String sql = "UPDATE department SET department_name = ?, manager_id = ?, location_id = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                department.getDepartmentName(),
                department.getManagerId(),
                department.getLocationId(),
                department.getDescription(),
                department.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM department WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class DepartmentRowMapper implements RowMapper<Department> {
        @Override
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department department = new Department();
            department.setId(rs.getLong("id"));
            department.setDepartmentName(rs.getString("department_name"));
            department.setManagerId(rs.getLong("manager_id"));
            department.setLocationId(rs.getLong("location_id"));
            department.setDescription(rs.getString("description"));
            return department;
        }
    }
}
