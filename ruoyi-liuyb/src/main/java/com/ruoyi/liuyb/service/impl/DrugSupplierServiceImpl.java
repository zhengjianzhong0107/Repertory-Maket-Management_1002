package com.ruoyi.liuyb.service.impl;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.liuyb.mapper.DrugSupplierMapper;
import com.ruoyi.liuyb.domain.DrugSupplier;
import com.ruoyi.liuyb.service.IDrugSupplierService;

/**
 * 供应商信息Service业务层处理
 * 
 * @author Liuyb
 * @date 2022-03-02
 */
@Service
public class DrugSupplierServiceImpl implements IDrugSupplierService 
{
    @Autowired
    private DrugSupplierMapper drugSupplierMapper;

    /**
     * 查询供应商信息
     * 
     * @param supplierid 供应商信息主键
     * @return 供应商信息
     */
    @Override
    public DrugSupplier selectDrugSupplierBySupplierid(Long supplierid)
    {
        return drugSupplierMapper.selectDrugSupplierBySupplierid(supplierid);
    }

    /**
     * 下拉查询数据  查询供应商名称...
     * @param drugSupplier
     * @return
     */
    @Override
    public List<DrugSupplier> selectSupplierName(DrugSupplier drugSupplier) {
        return drugSupplierMapper.selectSupplierName(drugSupplier);
    }

    /**
     * 查询供应商信息列表
     * 
     * @param drugSupplier 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<DrugSupplier> selectDrugSupplierList(DrugSupplier drugSupplier)
    {
        return drugSupplierMapper.selectDrugSupplierList(drugSupplier);
    }

    /**
     * 新增供应商信息
     * 
     * @param drugSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int insertDrugSupplier(DrugSupplier drugSupplier)
    {
        return drugSupplierMapper.insertDrugSupplier(drugSupplier);
    }

    /**
     * 修改供应商信息
     * 
     * @param drugSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int updateDrugSupplier(DrugSupplier drugSupplier)
    {
        return drugSupplierMapper.updateDrugSupplier(drugSupplier);
    }

    /**
     * 批量删除供应商信息
     * 
     * @param supplierids 需要删除的供应商信息主键
     * @return 结果
     */
    @Override
    public int deleteDrugSupplierBySupplierids(Long[] supplierids)
    {
        return drugSupplierMapper.deleteDrugSupplierBySupplierids(supplierids);
    }

    /**
     * 删除供应商信息信息
     * 
     * @param supplierid 供应商信息主键
     * @return 结果
     */
    @Override
    public int deleteDrugSupplierBySupplierid(Long supplierid)
    {
        return drugSupplierMapper.deleteDrugSupplierBySupplierid(supplierid);
    }

    /**
     * 导入
     * @param list
     * @param updateSupport
     * @return
     */
    @Override
    public String importDrugSupplier(List<DrugSupplier> list, boolean updateSupport) {
        if (StringUtils.isNull(list) || list.size() == 0){
            throw new RuntimeException("导入数据不能为空");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (DrugSupplier drugSupplier: list) {
            try {
                if (drugSupplierMapper.selectDrugSupplierByName(drugSupplier.getSuppliername()) == null ){
                    this.insertDrugSupplier(drugSupplier);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、 " + drugSupplier.getSuppliername() + " 导入成功");
                } else if(updateSupport){
                    drugSupplierMapper.updateDrugSupplierBysupplierName(drugSupplier);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、 " + drugSupplier.getSuppliername() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、 " + drugSupplier.getSuppliername() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、 " + drugSupplier.getSuppliername() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new RuntimeException(failureMsg.toString());
        } else {
            successMsg.insert(0, "数据已全部导入成功！共 " + successNum + " 条，数据如下：");
            return successMsg.toString();
        }
    }
}
