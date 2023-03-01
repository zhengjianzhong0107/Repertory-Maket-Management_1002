package com.ruoyi.liuyb.mapper;

import java.util.List;
import com.ruoyi.liuyb.domain.DrugSupplier;

/**
 * 供应商信息Mapper接口
 * 
 * @author Liuyb
 * @date 2022-03-02
 */
public interface DrugSupplierMapper 
{
    /**
     * 查询供应商信息
     * 
     * @param supplierid 供应商信息主键
     * @return 供应商信息
     */
    public DrugSupplier selectDrugSupplierBySupplierid(Long supplierid);


    /**
     * 下拉查询数据  查询供应商名称...
     * @param drugSupplier
     * @return
     */
    public List<DrugSupplier> selectSupplierName(DrugSupplier drugSupplier);

    /**
     * 查询供应商信息列表
     * 
     * @param drugSupplier 供应商信息
     * @return 供应商信息集合
     */
    public List<DrugSupplier> selectDrugSupplierList(DrugSupplier drugSupplier);

    public DrugSupplier selectDrugSupplierByName(String supplierName);

    /**
     * 新增供应商信息
     * 
     * @param drugSupplier 供应商信息
     * @return 结果
     */
    public int insertDrugSupplier(DrugSupplier drugSupplier);

    /**
     * 修改供应商信息
     * 
     * @param drugSupplier 供应商信息
     * @return 结果
     */
    public int updateDrugSupplier(DrugSupplier drugSupplier);

    public int updateDrugSupplierBysupplierName(DrugSupplier drugSupplier);

    /**
     * 删除供应商信息
     * 
     * @param supplierid 供应商信息主键
     * @return 结果
     */
    public int deleteDrugSupplierBySupplierid(Long supplierid);

    /**
     * 批量删除供应商信息
     * 
     * @param supplierids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDrugSupplierBySupplierids(Long[] supplierids);
}
