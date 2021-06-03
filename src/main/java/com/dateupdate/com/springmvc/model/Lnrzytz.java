package com.dateupdate.com.springmvc.model;

import com.dateupdate.com.springmvc.model.LnrzytzKey;

public class Lnrzytz extends LnrzytzKey {
    private Integer answer;

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Lnrzytz{" +
                "answer=" + answer +
                '}';
    }
}