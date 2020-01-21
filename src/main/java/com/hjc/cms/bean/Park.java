package com.hjc.cms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

import static com.hjc.cms.IConst.DEFAULT_TIME_PATTERN;


/**
 * Created by xd on 2017/5/18.
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "t_park")
public class Park implements Serializable {
    @Id
    private String   parkId;
    private String parkName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wx_config")
    private WxConfig wxConfig;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ali_config")
    private AliConfig aliConfig;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "yl_config")
    private YlConfig ylConfig;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn()
    private ParkConfig parkConfig;

    private Short proxyState;
    private Integer freeCount;
    private Integer proxyVersion;
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN)
    private Timestamp lastUpdate;
}
