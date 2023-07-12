package om.gov.taxoman.repository;

import om.gov.taxoman.entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    private Connection connection;

    public DepartmentRepository() {
        try {
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("select department_id, department_name, manager_id, location_id from departments");
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int departmentId = resultSet.getInt(1);
            String departmentName = resultSet.getString(2);
            int managerId = resultSet.getInt(3);
            int locationId = resultSet.getInt(4);

            Department department = new Department();
            department.setId(departmentId);
            department.setDepartmentName(departmentName);
            department.setManagerId(managerId);
            department.setLocationId(locationId);

            departments.add(department);
        }

        return departments;
    }

    public void insertDepartment(Department department) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into departments(department_id, department_name, manager_id, location_id) values (?,?,?,?)");
        ps.setInt(1, department.getId());
        ps.setString(2, department.getDepartmentName());
        ps.setInt(3, department.getManagerId());
        ps.setInt(4, department.getLocationId());

        int rowsAffected = ps.executeUpdate();
        System.out.println("Number of Rows Inserted: " + rowsAffected);
    }

    public void updateDeptName(int deptId, String deptName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("update departments set department_name=? where department_id=?");
        ps.setString(1, deptName);
        ps.setInt(2, deptId);

        int rowsAffected = ps.executeUpdate();
        System.out.println("Number of Rows Updated: " + rowsAffected);
    }

    public void deleteDeptById(int deptId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete from departments where department_id=?");
        ps.setInt(1, deptId);

        int rowsAffected = ps.executeUpdate();
        System.out.println("Number of Rows Deleted: " + rowsAffected);
    }

}
