package com.dateupdate.com.springmvc.model;


import java.sql.Timestamp;
import java.util.Date;

public class CardTimeDocutor {
    private String person_no;
    private Timestamp pe_date;
    private Integer operator_id;

    public String getPerson_no() {
        return person_no;
    }

    public void setPerson_no(String person_no) {
        this.person_no = person_no;
    }

    public Timestamp getPe_date() {
        return pe_date;
    }

    public void setPe_date(Timestamp pe_date) {
        this.pe_date = pe_date;
    }

    public Integer getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(Integer operator_id) {
        this.operator_id = operator_id;
    }

    @Override
    public String toString() {
        return "CardTimeDocutor{" +
                "person_no='" + person_no + '\'' +
                ", pe_date=" + pe_date +
                ", operator_id=" + operator_id +
                '}';
    }
}
