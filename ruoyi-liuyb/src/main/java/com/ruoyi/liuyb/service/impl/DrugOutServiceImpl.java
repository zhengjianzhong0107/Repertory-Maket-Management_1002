package com.ruoyi.liuyb.service.impl;

import java.util.List;

import com.ruoyi.liuyb.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.liuyb.mapper.DrugOutMapper;
import com.ruoyi.liuyb.domain.DrugOut;
import com.ruoyi.liuyb.service.IDrugOutService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 出库Service业务层处理
 *
 * @author liuyb
 * @date 2022-02-24
 */
@Service
public class DrugOutServiceImpl implements IDrugOutService
{
    @Autowired
    private DrugOutMapper drugOutMapper;

    @Autowired
    private StockMapper stockMapper;

    /**
     * 查询出库
     *
     * @param drugoutid 出库主键
     * @return 出库
     */
    @Override
    public DrugOut selectDrugOutByDrugoutid(Long drugoutid)
    {
        return drugOutMapper.selectDrugOutByDrugoutid(drugoutid);
    }

    /**
     * 查询出库列表
     *
     * @param drugOut 出库
     * @return 出库
     */
    @Override
    public List<DrugOut> selectDrugOutList(DrugOut drugOut)
    {
        return drugOutMapper.selectDrugOutList(drugOut);
    }

    /**
     * 新增出库
     *
     * @param drugOut 出库
     * @return 结果
     */
    @Override
    @Transactional
    public int insertDrugOut(DrugOut drugOut)
    {
        if(stockMapper.selectStockByStockDrugNO(drugOut.getDrugoutno()).getStocknum() >= drugOut.getDrugoutnum()){
           drugOutMapper.insertDrugOut(drugOut);
           return drugOutMapper.insertStock(drugOut);
        }else {
            throw new RuntimeException("出库失败！");
        }
    }

    /**
     * 新增/修改库存
     * @param drugOut
     * @return
     */
    @Override
    public int insertStock(DrugOut drugOut) {
        return drugOutMapper.insertStock(drugOut);
    }

    /**
     * 当月出库记录
     * @param drugOut
     */
    @Override
    public List<DrugOut> selectDrugOutNoAndName(DrugOut drugOut) {
        return drugOutMapper.selectDrugOutNoAndName(drugOut);
    }

    /**
     * 查询按月统计出库数量
     * @param drugOut
     * @return
     */
    @Override
    public List<DrugOut> selectDrugOutNumByMonth(DrugOut drugOut) {
        return drugOutMapper.selectDrugOutNumByMonth(drugOut);
    }

    /**
     * 修改出库
     *
     * @param drugOut 出库
     * @return 结果
     */
    @Override
    public int updateDrugOut(DrugOut drugOut)
    {
        return drugOutMapper.updateDrugOut(drugOut);
    }

    /**
     * 批量删除出库
     *
     * @param drugoutids 需要删除的出库主键
     * @return 结果
     */
    @Override
    public int deleteDrugOutByDrugoutids(Long[] drugoutids)
    {
        return drugOutMapper.deleteDrugOutByDrugoutids(drugoutids);
    }

    /**
     * 删除出库信息
     *
     * @param drugoutid 出库主键
     * @return 结果
     */
    @Override
    public int deleteDrugOutByDrugoutid(Long drugoutid)
    {
        return drugOutMapper.deleteDrugOutByDrugoutid(drugoutid);
    }
}
