package om.gov.taxoman.entity;

public class Department {

    private int id;
    private String departmentName;
    private int managerId;
    private int locationId;


    public Department() {
        this.id = id;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", managerId=" + managerId +
                ", locationId=" + locationId +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

}
