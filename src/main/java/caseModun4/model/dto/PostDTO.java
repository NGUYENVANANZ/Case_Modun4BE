package caseModun4.model.dto;

import caseModun4.model.Page;

import javax.persistence.OneToMany;


public class PostDTO {

    private Page page;
    private boolean isLike;

    public PostDTO(Page page, boolean isLike) {
        this.page = page;
        this.isLike = isLike;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
