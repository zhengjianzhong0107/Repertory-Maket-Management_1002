package com.ruoyi.liuyb.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 供应商信息对象 drug_supplier
 * 
 * @author Liuyb
 * @date 2022-03-02
 */
public class DrugSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long supplierid;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String suppliername;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String supplieraddress;

    /** 负责人 */
    @Excel(name = "负责人")
    private String supplieruser;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String supplierphone;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createtime;

    /** 备注 */
    @Excel(name = "备注")
    private String supplierremark;

    public void setSupplierid(Long supplierid) 
    {
        this.supplierid = supplierid;
    }

    public Long getSupplierid() 
    {
        return supplierid;
    }
    public void setSuppliername(String suppliername) 
    {
        this.suppliername = suppliername;
    }

    public String getSuppliername() 
    {
        return suppliername;
    }
    public void setSupplieraddress(String supplieraddress) 
    {
        this.supplieraddress = supplieraddress;
    }

    public String getSupplieraddress() 
    {
        return supplieraddress;
    }
    public void setSupplieruser(String supplieruser) 
    {
        this.supplieruser = supplieruser;
    }

    public String getSupplieruser() 
    {
        return supplieruser;
    }
    public void setSupplierphone(String supplierphone)
    {
        this.supplierphone = supplierphone;
    }

    public String getSupplierphone()
    {
        return supplierphone;
    }
    public void setSupplierremark(String supplierremark) 
    {
        this.supplierremark = supplierremark;
    }

    public String getSupplierremark() 
    {
        return supplierremark;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplierid", getSupplierid())
            .append("suppliername", getSuppliername())
            .append("supplieraddress", getSupplieraddress())
            .append("supplieruser", getSupplieruser())
            .append("supplierphone", getSupplierphone())
            .append("createtime", getCreatetime())
            .append("supplierremark", getSupplierremark())
            .toString();
    }

}
