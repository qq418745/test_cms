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
public class WxConfig implements Serializable {
    @Id
    @TableGenerator(name = "wxConfig")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "wxConfig")
    private Integer id;
    private String appId;
    private String secret;
    private String mchId;
    private String wxKey;
}
