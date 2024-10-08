package ch.souradip;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(
        name = "EMPLOYEE_DATA"
)
@NamedQuery(query = "select e from Employee e order by e.name asc", name = "emp name asc")
@NamedQuery(query = "select e from Employee e order by e.name desc", name = "emp name desc")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "employee_name", length = 100)
    private String name;
    @Column(unique = true, length = 10, nullable = false)
    private String ssn;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @Transient
    private String debugString;

    private int age;

    @OneToOne
    private AccessCard accessCard;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<PayStub> payStubs = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "EMAIL_GROUP_SUBSCRIPTIONS",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "EMAIL_SUBSCRIPTION_ID")
    )
    private List<EmailGroup> emailGroups = new ArrayList<>();

    public List<PayStub> getPayStubs() {
        return payStubs;
    }

    public void setPayStubs(List<PayStub> payStubs) {
        this.payStubs = payStubs;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

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
    public void addPayStub(PayStub payStub){
        this.payStubs.add(payStub);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", employeeType=" + employeeType +
                ", accessCard=" + accessCard +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
    public void addToEmailGroups(EmailGroup group){
        this.emailGroups.add(group);
    }
}
