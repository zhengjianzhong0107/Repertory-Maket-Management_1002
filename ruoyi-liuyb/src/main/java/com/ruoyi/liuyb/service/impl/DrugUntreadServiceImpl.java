package com.ruoyi.liuyb.service.impl;

import java.util.List;

import com.ruoyi.liuyb.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.liuyb.mapper.DrugUntreadMapper;
import com.ruoyi.liuyb.domain.DrugUntread;
import com.ruoyi.liuyb.service.IDrugUntreadService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 药品退回Service业务层处理
 * 
 * @author Liuyb
 * @date 2022-03-02
 */
@Service
public class DrugUntreadServiceImpl implements IDrugUntreadService 
{
    @Autowired
    private DrugUntreadMapper drugUntreadMapper;

    @Autowired
    private StockMapper stockMapper;

    /**
     * 查询药品退回
     * 
     * @param untreadid 药品退回主键
     * @return 药品退回
     */
    @Override
    public DrugUntread selectDrugUntreadByUntreadid(Long untreadid)
    {
        return drugUntreadMapper.selectDrugUntreadByUntreadid(untreadid);
    }


    /**
     * 查询近期30条退货记录
     * @param drugUntread
     * @return
     */
    @Override
    public List<DrugUntread> selectUntreadChart(DrugUntread drugUntread) {
        return drugUntreadMapper.selectUntreadChart(drugUntread);
    }

    /**
     * 查询药品退回列表
     * 
     * @param drugUntread 药品退回
     * @return 药品退回
     */
    @Override
    public List<DrugUntread> selectDrugUntreadList(DrugUntread drugUntread)
    {
        return drugUntreadMapper.selectDrugUntreadList(drugUntread);
    }

    /**
     * 新增药品退回
     * 
     * @param drugUntread 药品退回
     * @return 结果
     */
    @Override
    @Transactional
    public int insertDrugUntread(DrugUntread drugUntread)
    {
        if (stockMapper.selectStockByStockDrugNO(drugUntread.getUntreadno()).getStocknum() >= drugUntread.getUntreadnum()){
            drugUntreadMapper.insertDrugUntread(drugUntread);
            return drugUntreadMapper.insertStock(drugUntread);
        }else {
            throw new RuntimeException("新增失败");
        }
    }

    /**
     * 药品退货时对库存表的增改
     * @param drugUntread
     * @return
     */
    @Override
    public int insertStock(DrugUntread drugUntread) {
        return drugUntreadMapper.insertStock(drugUntread);
    }

    /**
     * 修改药品退回
     * 
     * @param drugUntread 药品退回
     * @return 结果
     */
    @Override
    public int updateDrugUntread(DrugUntread drugUntread)
    {
        return drugUntreadMapper.updateDrugUntread(drugUntread);
    }

    /**
     * 批量删除药品退回
     * 
     * @param untreadids 需要删除的药品退回主键
     * @return 结果
     */
    @Override
    public int deleteDrugUntreadByUntreadids(Long[] untreadids)
    {
        return drugUntreadMapper.deleteDrugUntreadByUntreadids(untreadids);
    }

    /**
     * 删除药品退回信息
     * 
     * @param untreadid 药品退回主键
     * @return 结果
     */
    @Override
    public int deleteDrugUntreadByUntreadid(Long untreadid)
    {
        return drugUntreadMapper.deleteDrugUntreadByUntreadid(untreadid);
    }
}
