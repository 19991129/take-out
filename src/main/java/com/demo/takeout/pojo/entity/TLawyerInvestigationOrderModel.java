package com.demo.takeout.pojo.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.*;
import com.demo.takeout.constant.TakeOutConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import java.util.Date;
import java.util.List;


/**
 * 律师调查令
 *
 * @author wj
 * @program: tellhowcloud
 * @create 2024-05-06 16:55:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@TableName("t_lawyer_investigation_order")
public class TLawyerInvestigationOrderModel {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    // 逻辑删除标识
    @TableLogic
    private boolean deleteFlag;

    /**
     * 当事人(申请执行人)
     */
    @TableField(value = "client")
    private String client;

    /**
     * 经办法院
     */
    @TableField(value = "delegated_court")
    private String delegatedCourt;

    /**
     * 案号
     */
    @TableField(value = "ah")
    private String ah;

    /**
     * 原告名称
     */
    @TableField(value = "ygmc")
    private String ygmc;

    /**
     * 被告名称
     */
    @TableField(value = "bgmc")
    private String bgmc;

    /**
     * 案由
     */
    @TableField(value = "ay")
    private String ay;

    /**
     * 协助调查人
     */
    @TableField(value = "assist_investigator")
    private String assistInvestigator;

    /**
     * 申请人
     */
    @TableField(value = "applicant")
    private String applicant;

    /**
     * 申请人id
     */
    @TableField(value = "applicant_id")
    private Long applicantId;

    /**
     * 申请人所在单位
     */
    @TableField(value = "application_unit")
    private String applicationUnit;

    /**
     * 承办人(法官)
     */
    @TableField(value = "cbr")
    private String cbr;

    /**
     * 状态
     */
    @TableField(value = "status")
//    @EnumFiled(type = TakeOutConstant.StatusEnum.class, targetProperty = "status")
    private String status;

    /**
     * 第三人
     */
    @TableField(value = "dsr")
    private String dsr;

    /**
     * 处理意见
     */
    @TableField(value = "handling_opinions")
    private String handlingOpinions;

    /**
     * 操作时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "operate_time")
    private Date operateTime;

    /**
     * 申请时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    /**
    * 审批时间
    */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date approveTime;

    /**
     * 律师调查令文件
     */
    @TableField(exist = false)
    private List<User> materialModels;

    /**
     * 模板类型
     */
    @TableField(exist = false)
    private String templateType;
}
