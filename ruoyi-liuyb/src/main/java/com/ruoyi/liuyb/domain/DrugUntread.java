package com.ruoyi.liuyb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药品退回对象 drug_untread
 * 
 * @author Liuyb
 * @date 2022-03-02
 */
public class DrugUntread extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long untreadid;

    /** 药品编号 */
    @Excel(name = "药品编号")
    private Long untreadno;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String untreaddrugname;

    /** 供应商 */
    @Excel(name = "供应商")
    private String untreadsuppliername;

    /** 厂商 */
    @Excel(name = "厂商")
    private String untreaddrugvendor;

    /** 退回数量 */
    @Excel(name = "退回数量")
    private Long untreadnum;

    /** 退货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date untreadtime;

    /** 退货原因 */
    @Excel(name = "退货原因")
    private String untreadreason;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUntreadid(Long untreadid) 
    {
        this.untreadid = untreadid;
    }

    public Long getUntreadid() 
    {
        return untreadid;
    }
    public void setUntreadno(Long untreadno) 
    {
        this.untreadno = untreadno;
    }

    public Long getUntreadno() 
    {
        return untreadno;
    }
    public void setUntreaddrugname(String untreaddrugname) 
    {
        this.untreaddrugname = untreaddrugname;
    }

    public String getUntreaddrugname() 
    {
        return untreaddrugname;
    }
    public void setUntreadsuppliername(String untreadsuppliername) 
    {
        this.untreadsuppliername = untreadsuppliername;
    }

    public String getUntreadsuppliername() 
    {
        return untreadsuppliername;
    }
    public void setUntreaddrugvendor(String untreaddrugvendor) 
    {
        this.untreaddrugvendor = untreaddrugvendor;
    }

    public String getUntreaddrugvendor() 
    {
        return untreaddrugvendor;
    }
    public void setUntreadnum(Long untreadnum) 
    {
        this.untreadnum = untreadnum;
    }

    public Long getUntreadnum() 
    {
        return untreadnum;
    }
    public void setUntreadtime(Date untreadtime) 
    {
        this.untreadtime = untreadtime;
    }

    public Date getUntreadtime() 
    {
        return untreadtime;
    }
    public void setUntreadreason(String untreadreason) 
    {
        this.untreadreason = untreadreason;
    }

    public String getUntreadreason() 
    {
        return untreadreason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("untreadid", getUntreadid())
            .append("untreadno", getUntreadno())
            .append("untreaddrugname", getUntreaddrugname())
            .append("untreadsuppliername", getUntreadsuppliername())
            .append("untreaddrugvendor", getUntreaddrugvendor())
            .append("untreadnum", getUntreadnum())
            .append("untreadtime", getUntreadtime())
            .append("untreadreason", getUntreadreason())
            .toString();
    }
}
