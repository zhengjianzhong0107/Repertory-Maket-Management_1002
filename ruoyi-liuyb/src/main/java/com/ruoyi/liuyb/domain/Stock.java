package com.ruoyi.liuyb.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存对象 stock
 * 
 * @author liuyb
 * @date 2022-02-23
 */
public class Stock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long stockid;

    /** 药品编号 */
    @Excel(name = "药品编号")
    private Long stockdrugno;

    /** 药品名 */
    @Excel(name = "药品名")
    private String stockdrugname;

    /** 库存 */
    @Excel(name = "库存")
    private Long stocknum;

    /** 厂商 */
    @Excel(name = "厂商")
    private String drugvendor;

    /** 存放地点 */
    @Excel(name = "存放地点")
    private String drugplace;

    /** 库存预警数值 */
    private Long drugwarning;

    /** 药品用法用量 */
    @Excel(name = "药品用法用量")
    private String drugused;

    /** 库存报警 --中间量 */
    private Long num;

    public void setStockid(Long stockid) 
    {
        this.stockid = stockid;
    }

    public Long getStockid() 
    {
        return stockid;
    }
    public void setStockdrugno(Long stockdrugno) 
    {
        this.stockdrugno = stockdrugno;
    }

    public Long getStockdrugno() 
    {
        return stockdrugno;
    }
    public void setStockdrugname(String stockdrugname) 
    {
        this.stockdrugname = stockdrugname;
    }

    public String getStockdrugname() 
    {
        return stockdrugname;
    }
    public void setStocknum(Long stocknum) 
    {
        this.stocknum = stocknum;
    }

    public Long getStocknum() 
    {
        return stocknum;
    }

    public String getDrugvendor() {
        return drugvendor;
    }

    public void setDrugvendor(String drugvendor) {
        this.drugvendor = drugvendor;
    }

    public String getDrugplace() {
        return drugplace;
    }

    public void setDrugplace(String drugplace) {
        this.drugplace = drugplace;
    }

    public Long getDrugwarning() {
        return drugwarning;
    }

    public void setDrugwarning(Long drugwarning) {
        this.drugwarning = drugwarning;
    }

    public String getDrugused() {
        return drugused;
    }

    public void setDrugused(String drugused) {
        this.drugused = drugused;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stockid", getStockid())
            .append("stockdrugno", getStockdrugno())
            .append("stockdrugname", getStockdrugname())
            .append("stocknum", getStocknum())
            .append("drugvendor",getDrugvendor())
            .append("drugplace",getDrugplace())
            .append("drugwarning",getDrugwarning())
            .append("drugused",getDrugused())
            .toString();
    }
}
