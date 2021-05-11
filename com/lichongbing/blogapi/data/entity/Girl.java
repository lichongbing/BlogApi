package com.lichongbing.blogapi.data.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (girl)实体类
 *
 * @author kancy
 * @since 2021-05-03 20:19:01
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("girl")
public class Girl extends Model<Girl> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
    /**
     * title
     */
    private String title;
    /**
     * price
     */
    private Integer price;
    /**
     * girlimge
     */
    private String girlimge;
    /**
     * introduce
     */
    private String introduce;
    /**
     * isonlie
     */
    private Integer isonlie;
    /**
     * isworking
     */
    private Integer isworking;

}