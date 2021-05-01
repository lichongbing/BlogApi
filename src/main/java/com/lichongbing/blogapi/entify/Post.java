package com.lichongbing.blogapi.entify;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("(Post)表实体类")
@TableName(value = "mto_post")
public class Post extends Model<Post> {
    @ApiModelProperty("主键")
    @TableId
    private long id;
    @ApiModelProperty("分组/模块ID")
    @TableField(value = "channel_id")
    private int channelId;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("摘要")
    private String summary;
    @ApiModelProperty("预览图")
    private String thumbnail;
    @ApiModelProperty("时间")
    private Date created;
    @ApiModelProperty("文章状态")
    private int status;
    @ApiModelProperty("推荐状态")
    private int featured;
    @ApiModelProperty("排序值")
    private int weight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFeatured() {
        return featured;
    }

    public void setFeatured(int featured) {
        this.featured = featured;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", created=" + created +
                ", status=" + status +
                ", featured=" + featured +
                ", weight=" + weight +
                '}';
    }
}
