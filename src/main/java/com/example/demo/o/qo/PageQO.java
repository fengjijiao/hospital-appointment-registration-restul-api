package com.example.demo.o.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@ApiModel("pageQO")
public class PageQO {
    @ApiParam(defaultValue = "3", required = true)
    @ApiModelProperty(value = "pageSize", required = true)
    private Integer pageSize;
    @ApiParam(defaultValue = "1", required = true)
    @ApiModelProperty(value = "pageNum", required = true)
    private Integer pageNum;

    @ApiParam(hidden = true)
    @ApiModelProperty(hidden = true)
    private Integer offset;

    public PageQO(Integer pageSize, Integer pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    private void updateOffset() {
        this.offset = (pageNum == null || pageNum < 1 ? 1-1 : pageNum-1) * (pageSize == null ? 3 : pageSize);
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        updateOffset();
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        updateOffset();
    }

    public Integer getOffset() {
        return offset;
    }
}
