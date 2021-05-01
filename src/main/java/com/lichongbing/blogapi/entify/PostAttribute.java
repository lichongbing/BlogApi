package com.lichongbing.blogapi.entify;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("(PostAttribute)表实体类")
@TableName(value = "mto_post_attribute")
public class PostAttribute extends Model<PostAttribute> {
    @ApiModelProperty("主键")
    @TableId
    private long id;
    @ApiModelProperty("内容")
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostAttribute{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
