package com.dateupdate.com.springmvc.model;

public class LnrzytzKey {
    private String patientNo;

    private Integer questionId;

    private Integer answer;

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "LnrzytzKey{" +
                "patientNo='" + patientNo + '\'' +
                ", questionId=" + questionId +
                ", answer=" + answer +
                '}';
    }
}