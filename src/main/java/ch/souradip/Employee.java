package ch.souradip;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name = "EMPLOYEE_DATA"
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "employee_name", length = 100)
    private String name;
    @Column(unique = true, length = 10, nullable = false)
    private String ssn;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @Transient
    private String debugString;

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    private Date dob;
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", employeeType=" + employeeType +
                ", dob=" + dob +
                '}';
    }
}
