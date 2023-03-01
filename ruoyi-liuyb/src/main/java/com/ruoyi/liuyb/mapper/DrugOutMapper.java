package com.ruoyi.liuyb.mapper;

import java.util.List;
import com.ruoyi.liuyb.domain.DrugOut;

/**
 * 出库Mapper接口
 *
 * @author liuyb
 * @date 2022-02-24
 */
public interface DrugOutMapper
{
    /**
     * 查询出库
     *
     * @param drugoutid 出库主键
     * @return 出库
     */
    public DrugOut selectDrugOutByDrugoutid(Long drugoutid);

    /**
     * 查询出库列表
     *
     * @param drugOut 出库
     * @return 出库集合
     */
    public List<DrugOut> selectDrugOutList(DrugOut drugOut);

    /**
     * 当月出库记录查询
     * @param drugOut
     * @return
     */
    public List<DrugOut> selectDrugOutNoAndName(DrugOut drugOut);

    /**
     * 查询按月统计出库数量
     * @param drugOut
     * @return
     */
    public List<DrugOut> selectDrugOutNumByMonth(DrugOut drugOut);

    /**
     * 新增出库
     *
     * @param drugOut 出库
     * @return 结果
     */
    public int insertDrugOut(DrugOut drugOut);

    /**
     * 新增/修改库存
     * @param drugOut
     * @return
     */
    public int insertStock(DrugOut drugOut);
    /**
     * 修改出库
     *
     * @param drugOut 出库
     * @return 结果
     */
    public int updateDrugOut(DrugOut drugOut);

    /**
     * 删除出库
     *
     * @param drugoutid 出库主键
     * @return 结果
     */
    public int deleteDrugOutByDrugoutid(Long drugoutid);

    /**
     * 批量删除出库
     *
     * @param drugoutids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDrugOutByDrugoutids(Long[] drugoutids);
}
