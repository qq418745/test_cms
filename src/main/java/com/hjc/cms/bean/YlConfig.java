package com.hjc.cms.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xd on 2017/5/18.
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
public class YlConfig implements Serializable {
    @Id
    @TableGenerator(name = "ylConfig")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ylConfig")
    private Integer id;
    private String msgSrc;
    private String msgSrcId;
    private String mid;
    private String tid;
    private String ylKey;
    private String msgType;
}
