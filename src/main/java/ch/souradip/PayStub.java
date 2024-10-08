package ch.souradip;

import javax.persistence.*;
import java.util.Date;
@Entity
public class PayStub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "startDate")
    private Date payPeriodStart;

    @Column(name = "endDate")
    private Date payPeriodEnd;
    private float salary;
    @ManyToOne
    @JoinColumn(name = "payStub_for")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getPayPeriodStart() {
        return payPeriodStart;
    }

    public void setPayPeriodStart(Date payPeriodStart) {
        this.payPeriodStart = payPeriodStart;
    }

    public Date getPayPeriodEnd() {
        return payPeriodEnd;
    }

    public void setPayPeriodEnd(Date payPeriodEnd) {
        this.payPeriodEnd = payPeriodEnd;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PayStub{" +
                "id=" + id +
                ", payPeriodStart=" + payPeriodStart +
                ", payPeriodEnd=" + payPeriodEnd +
                ", salary=" + salary +
                ", employee=" + employee +
                '}';
    }
}
