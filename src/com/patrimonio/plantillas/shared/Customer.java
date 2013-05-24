package com.patrimonio.plantillas.shared;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements java.io.Serializable {
        
                /**
                 * 
                 */
                private static final long serialVersionUID = 1L;

                @SequenceGenerator(name="CUSTOMER_SEQUENCE_GENERATOR",sequenceName="CUSTOMER_SEQ")
                @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_SEQUENCE_GENERATOR")      
            private long employeeId;
           
            @Column(name="employee_name", nullable = false, length=30)
            private String employeeName;
            
            @Column(name="employee_surname", nullable = false, length=30)
            private String employeeSurname;
            
            @Column(name="job", length=50)
            private String job;

                public Customer() {
                        
                }

                public Customer(String employeeName, String employeeSurname, String job) {
                        super();
                        this.employeeName = employeeName;
                        this.employeeSurname = employeeSurname;
                        this.job = job;
                }

                public long getEmployeeId() {
                        return employeeId;
                }

                public void setEmployeeId(long employeeId) {
                        this.employeeId = employeeId;
                }

                public String getEmployeeName() {
                        return employeeName;
                }

                public void setEmployeeName(String employeeName) {
                        this.employeeName = employeeName;
                }

                public String getEmployeeSurname() {
                        return employeeSurname;
                }

                public void setEmployeeSurname(String employeeSurname) {
                        this.employeeSurname = employeeSurname;
                }

                public String getJob() {
                        return job;
                }

                public void setJob(String job) {
                        this.job = job;
                }
                
}