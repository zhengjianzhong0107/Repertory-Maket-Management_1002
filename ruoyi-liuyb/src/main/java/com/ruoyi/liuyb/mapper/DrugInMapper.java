package com.ruoyi.liuyb.mapper;

import java.util.List;
import com.ruoyi.liuyb.domain.DrugIn;

/**
 * 药品入库Mapper接口
 * 
 * @author liuyb
 * @date 2022-02-23
 */
public interface DrugInMapper 
{
    /**
     * 查询药品入库
     * 
     * @param druginid 药品入库主键
     * @return 药品入库
     */
    public DrugIn selectDrugInByDruginid(Long druginid);

    //test
    public List<DrugIn> selectDrugInNoName(DrugIn drugin);

    /**
     * 查询本月的入库信息
     *
     * @param drugin
     * @return 药品入库集合
     */
    public List<DrugIn> selectDrugInNameAndNum(DrugIn drugin);

    /**
     * 按月统计入库数据
     * @param drugin
     * @return
     */
    public List<DrugIn> selectDrugInNumByMonth(DrugIn drugin);

    /**
     * 查询入库批次
     * @return
     */
    public  List<DrugIn> selectDrugInBatch();

    /**
     * 查询药品入库列表
     * 
     * @param drugIn 药品入库
     * @return 药品入库集合
     */
    public List<DrugIn> selectDrugInList(DrugIn drugIn);
    public List<DrugIn> selectDrugInList1(DrugIn drugIn);

    /**
     * 新增药品入库
     * 
     * @param drugIn 药品入库
     * @return 结果
     */
    public int insertDrugIn(DrugIn drugIn);

    /**
     * 新增/更新库存表
     * @param drugIn
     * @return
     */
    public int insertStock(DrugIn drugIn);

    /**
     * 修改药品入库
     * 
     * @param drugIn 药品入库
     * @return 结果
     */
    public int updateDrugIn(DrugIn drugIn);

    /**
     * 删除药品入库
     * 
     * @param druginid 药品入库主键
     * @return 结果
     */
    public int deleteDrugInByDruginid(Long druginid);

    /**
     * 批量删除药品入库
     * 
     * @param druginids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDrugInByDruginids(Long[] druginids);

}
