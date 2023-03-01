package com.ruoyi.liuyb.service;

import java.util.List;
import com.ruoyi.liuyb.domain.Drug;
import org.springframework.web.multipart.MultipartFile;

/**
 * 药品信息管理Service接口
 * 
 * @author liuyb
 * @date 2022-02-23
 */
public interface IDrugService 
{
    /**
     * 查询药品信息管理
     * 
     * @param drugid 药品信息管理主键
     * @return 药品信息管理
     */
    public Drug selectDrugByDrugid(Long drugid);

    /**
     * 查询药品信息管理列表
     * 
     * @param drug 药品信息管理
     * @return 药品信息管理集合
     */
    public List<Drug> selectDrugList(Drug drug);

    /**
     * 查询药品信息的药品编号
     *
     * @param drug
     */
    public List<Drug> selectDrugListNo(Drug drug);

    //下拉选择
    public  List<Drug> selectDrugNoName(Drug drug);

    /**
     * 新增药品信息管理
     * 
     * @param drug 药品信息管理
     * @return 结果
     */
    public int insertDrug(Drug drug);

    //查询存放地点
//    public Drug selectDrugPlace(Drug drug);

    /**
     * 修改药品信息管理
     * 
     * @param drug 药品信息管理
     * @return 结果
     */
    public int updateDrug(Drug drug);

    /**
     * 批量删除药品信息管理
     * 
     * @param drugids 需要删除的药品信息管理主键集合
     * @return 结果
     */
    public int deleteDrugByDrugids(Long[] drugids);

    /**
     * 删除药品信息管理信息
     * 
     * @param drugid 药品信息管理主键
     * @return 结果
     */
    public int deleteDrugByDrugid(Long drugid);

    public String importDrug(List<Drug> drugList,boolean updateSupport);
}
