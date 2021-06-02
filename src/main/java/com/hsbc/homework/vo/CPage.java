package com.hsbc.homework.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
/**
 *  description:  page vo
 *  author: mark3
 *  Date: 2021-05-29
 */
@Data
@JsonView({})
public class CPage<T> {

    private Long startPage;

    private Long totalPage=0L;

    private Long pageSize;

    private Long totalSize=0L;

    private List<T> list=new ArrayList<>();

    private T content;

    @JsonIgnore
    public Long getOffset(){
        return (this.startPage-1)*this.getPageSize();
    }

    public Long getStartPage() {
        return startPage;
    }

    public void setStartPage(Long startPage) {
        this.startPage = startPage<=0?1:startPage;
    }

    public Long getTotalPage(Long totalSize){
        return (totalSize+this.getPageSize())/this.getPageSize();
    }

    public CPage() {
    }

    public CPage(CPage cPage, Long totalSize) {
        this.setStartPage(cPage.getStartPage());
        this.setPageSize(cPage.getPageSize());
        this.setTotalPage(cPage.getTotalPage(totalSize));
        this.setTotalSize(totalSize);
    }

    public void changeStartPage(Long totalSize){
        if (totalSize <= this.getOffset() && this.getStartPage() > 0 || this.getStartPage()>this.getTotalPage(totalSize)) {
            this.setStartPage(0L);
        }
    }
}
