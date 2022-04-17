package com.lhrtsx.study.enirty;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Classification {

    @Id
    private Long id;

    @Column(columnDefinition = "name")
    private String name;

    @Column(columnDefinition = "ablout")
    private String about;

    @Column(columnDefinition = "pid")
    private Long pid;

    @Column(columnDefinition = "ancestral")
    private String ancestral;

    @Column(columnDefinition = "create_time")
    private Date createTime;

    @Column(columnDefinition = "update_time")
    private Date updateTime;

    @Column(columnDefinition = "status")
    private String status;
}
