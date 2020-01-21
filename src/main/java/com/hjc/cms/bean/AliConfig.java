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
public class AliConfig implements Serializable {
    @Id
    @TableGenerator(name = "aliConfig")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "aliConfig")
    private Integer id;

    private String partnerId;
    private String aliAppId;
    private String aliShaRsaKey;
    private String aliPublicKey;
    private String aliRsa;
}
