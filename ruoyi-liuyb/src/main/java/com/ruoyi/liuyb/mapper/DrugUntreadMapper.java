package com.ruoyi.liuyb.mapper;

import java.util.List;
import com.ruoyi.liuyb.domain.DrugUntread;

/**
 * 药品退回Mapper接口
 * 
 * @author Liuyb
 * @date 2022-03-02
 */
public interface DrugUntreadMapper 
{
    /**
     * 查询药品退回
     * 
     * @param untreadid 药品退回主键
     * @return 药品退回
     */
    public DrugUntread selectDrugUntreadByUntreadid(Long untreadid);

    /**
     * 查询近期30条退货记录
     * @param drugUntread
     * @return
     */
    public List<DrugUntread> selectUntreadChart(DrugUntread drugUntread);

    /**
     * 查询药品退回列表
     * 
     * @param drugUntread 药品退回
     * @return 药品退回集合
     */
    public List<DrugUntread> selectDrugUntreadList(DrugUntread drugUntread);

    /**
     * 新增药品退回
     * 
     * @param drugUntread 药品退回
     * @return 结果
     */
    public int insertDrugUntread(DrugUntread drugUntread);

    /**
     * 药品退货时对库存表的增改
     * @param drugUntread
     * @return
     */
    public int insertStock(DrugUntread drugUntread);

    /**
     * 修改药品退回
     * 
     * @param drugUntread 药品退回
     * @return 结果
     */
    public int updateDrugUntread(DrugUntread drugUntread);

    /**
     * 删除药品退回
     * 
     * @param untreadid 药品退回主键
     * @return 结果
     */
    public int deleteDrugUntreadByUntreadid(Long untreadid);

    /**
     * 批量删除药品退回
     * 
     * @param untreadids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDrugUntreadByUntreadids(Long[] untreadids);
}
