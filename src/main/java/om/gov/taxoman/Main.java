package om.gov.taxoman;

import om.gov.taxoman.entity.Department;

import java.sql.*;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(222);
//        queue.add(333);
//        queue.add(444);
//        queue.add(555);
//
//        int size = queue.size();
//
//        for (int i = 0; i < size; i++) {
//            System.out.println(queue.poll());
//        }




//        Map<String, Employee> employeeMap = new HashMap<>();
//        employeeMap.put("ahmed", new Employee("ahmed", "amin"));
//
//        System.out.println(employeeMap.get("amin"));


        try {

            List<Department> departments = new ArrayList<>();


            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

            //For Select
            PreparedStatement ps = conn.prepareStatement("select department_id, department_name, manager_id, location_id from departments");
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

            for (int i = 0; i < departments.size(); i++) {
                System.out.println(departments.get(i));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}