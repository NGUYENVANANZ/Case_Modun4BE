package caseModun4.model.dto;

public class CmtDto {
    private String text;

    public CmtDto() {
    }

    public CmtDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
