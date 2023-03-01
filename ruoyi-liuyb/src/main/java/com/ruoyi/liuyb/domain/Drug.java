package com.ruoyi.liuyb.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 药品信息管理对象 drug
 * 
 * @author liuyb
 * @date 2022-02-23
 */
public class Drug extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long drugid;

    /** 药品编号 */
    @Excel(name = "药品编号")
    private Long drugno;

    /** 药品名 */
    @Excel(name = "药品名")
    private String drugname;

    /** 保质期/月 */
    @Excel(name = "保质期/月")
    private Long drugexpirydata;

    /** 厂商 */
    @Excel(name = "厂商")
    private String drugvendor;

    /** 规格 */
    @Excel(name = "规格")
    private String drugspec;

    /** 存放地点 */
    @Excel(name = "存放地点")
    private String drugplace;

    /** 用法用量 */
    @Excel(name = "用法用量")
    private String drugused;

    /** 库存预警 */
    @Excel(name = "库存预警")
    private Long drugwarning;

    /**
     * 卖价
     */
    @Excel(name = "出库价格")
    private BigDecimal drugoutprice;

    /** 备注 */
    @Excel(name = "备注")
    private String drugremark;

    public void setDrugid(Long drugid) 
    {
        this.drugid = drugid;
    }

    public Long getDrugid() 
    {
        return drugid;
    }
    public void setDrugno(Long drugno) 
    {
        this.drugno = drugno;
    }

    public Long getDrugno() 
    {
        return drugno;
    }
    public void setDrugname(String drugname) 
    {
        this.drugname = drugname;
    }

    public String getDrugname() 
    {
        return drugname;
    }
    public void setDrugexpirydata(Long drugexpirydata) 
    {
        this.drugexpirydata = drugexpirydata;
    }

    public Long getDrugexpirydata() 
    {
        return drugexpirydata;
    }
    public void setDrugvendor(String drugvendor) 
    {
        this.drugvendor = drugvendor;
    }

    public String getDrugvendor() 
    {
        return drugvendor;
    }
    public void setDrugspec(String drugspec) 
    {
        this.drugspec = drugspec;
    }

    public String getDrugspec() 
    {
        return drugspec;
    }
    public void setDrugplace(String drugplace) 
    {
        this.drugplace = drugplace;
    }

    public String getDrugplace() 
    {
        return drugplace;
    }
    public void setDrugused(String drugused) 
    {
        this.drugused = drugused;
    }

    public String getDrugused() 
    {
        return drugused;
    }
    public void setDrugwarning(Long drugwarning) 
    {
        this.drugwarning = drugwarning;
    }

    public Long getDrugwarning() 
    {
        return drugwarning;
    }
    public void setDrugremark(String drugremark) 
    {
        this.drugremark = drugremark;
    }

    public String getDrugremark() 
    {
        return drugremark;
    }

    public BigDecimal getDrugoutprice() {
        return drugoutprice;
    }

    public void setDrugoutprice(BigDecimal drugoutprice) {
        this.drugoutprice = drugoutprice;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugid=" + drugid +
                ", drugno=" + drugno +
                ", drugname='" + drugname + '\'' +
                ", drugexpirydata=" + drugexpirydata +
                ", drugvendor='" + drugvendor + '\'' +
                ", drugspec='" + drugspec + '\'' +
                ", drugplace='" + drugplace + '\'' +
                ", drugused='" + drugused + '\'' +
                ", drugwarning=" + drugwarning +
                ", drugoutprice=" + drugoutprice +
                ", drugremark='" + drugremark + '\'' +
                '}';
    }
}
