package caseModun4.model.dto;

public class ResetPassDTO {

    private  String password;

    public ResetPassDTO() {
    }

    public ResetPassDTO(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
