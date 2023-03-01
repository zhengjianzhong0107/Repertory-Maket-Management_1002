package com.ruoyi.liuyb.service.impl;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.liuyb.mapper.DrugMapper;
import com.ruoyi.liuyb.domain.Drug;
import com.ruoyi.liuyb.service.IDrugService;

/**
 * 药品信息管理Service业务层处理
 * 
 * @author liuyb
 * @date 2022-02-23
 */
@Service
public class DrugServiceImpl implements IDrugService 
{
    @Autowired
    private DrugMapper drugMapper;

    /**
     * 查询药品信息管理
     * 
     * @param drugid 药品信息管理主键
     * @return 药品信息管理
     */
    @Override
    public Drug selectDrugByDrugid(Long drugid)
    {
        return drugMapper.selectDrugByDrugid(drugid);
    }

    /**
     * 查询药品信息管理列表
     * 
     * @param drug 药品信息管理
     * @return 药品信息管理
     */
    @Override
    public List<Drug> selectDrugList(Drug drug)
    {
        return drugMapper.selectDrugList(drug);
    }

    @Override
    public List<Drug> selectDrugListNo(Drug drug) {
        return drugMapper.selectDrugListNo(drug);
    }

    /**
     * 查询药品名和编号
     * @param drug
     * @return
     */
    @Override
    public List<Drug> selectDrugNoName(Drug drug) {
        return drugMapper.selectDrugNoName(drug);
    }

    /**
     * 新增药品信息管理
     * 
     * @param drug 药品信息管理
     * @return 结果
     */
    @Override
    public int insertDrug(Drug drug)
    {
        try {
            return drugMapper.insertDrug(drug);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加失败");
        }
    }

    /**
     * 查询存放地点
     * @param drug
     * @return
     */
//    @Override
//    public Drug selectDrugPlace(Drug drug) {
//        return drugMapper.selectDrugPlace(drug);
//    }

    /**
     * 修改药品信息管理
     * 
     * @param drug 药品信息管理
     * @return 结果
     */
    @Override
    public int updateDrug(Drug drug)
    {
        return drugMapper.updateDrug(drug);
    }

    public int updateDrugBydrugno(Drug drug){
        return drugMapper.updateDrugBydrugno(drug);
    }

    /**
     * 批量删除药品信息管理
     * 
     * @param drugids 需要删除的药品信息管理主键
     * @return 结果
     */
    @Override
    public int deleteDrugByDrugids(Long[] drugids)
    {
        return drugMapper.deleteDrugByDrugids(drugids);
    }

    /**
     * 删除药品信息管理信息
     * 
     * @param drugid 药品信息管理主键
     * @return 结果
     */
    @Override
    public int deleteDrugByDrugid(Long drugid)
    {
        return drugMapper.deleteDrugByDrugid(drugid);
    }

    /**
     * 导入
     * @param drugList
     * @param updateSupport
     * @return
     */
    @Override
    public String importDrug(List<Drug> drugList, boolean updateSupport) {
        if(StringUtils.isNull(drugList) || drugList.size() == 0){
            throw new RuntimeException("导入数据不能为空");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (Drug drug:drugList) {
            try {
                if (drugMapper.selectDrugByDrugno(drug.getDrugno())== null){
                    this.insertDrug(drug);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、 " + drug.getDrugname() + " 导入成功");
                } else if(updateSupport){
                    this.updateDrugBydrugno(drug);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、 " + drug.getDrugname() + " 更新成功");
                }else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、 " + drug.getDrugname() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、 " + drug.getDrugname() + " 导入失败：";
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
