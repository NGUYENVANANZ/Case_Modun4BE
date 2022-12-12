package caseModun4.model.dto;

public class PageDTO {
    private  String text;

    private String img;

    public PageDTO(String text, String img) {
        this.text = text;
        this.img = img;
    }

    public PageDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
