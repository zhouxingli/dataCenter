package com.gdtopway.graphql.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springblade.core.mp.base.BaseEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("Book")
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity implements Serializable {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "书名")
    private String title;

    @ApiModelProperty(value = "是否")
    private String isbn;

    @ApiModelProperty(value = "总页数")
    private int pageCount;

    @ApiModelProperty(value = "作者")
    private long authorId;
}
