package com.ruoyi.liuyb.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.liuyb.mapper.DrugInMapper;
import com.ruoyi.liuyb.domain.DrugIn;
import com.ruoyi.liuyb.service.IDrugInService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 药品入库Service业务层处理
 * 
 * @author liuyb
 * @date 2022-02-23
 */
@Service
public class DrugInServiceImpl implements IDrugInService 
{
    @Autowired
    private DrugInMapper drugInMapper;

    /**
     * 查询药品入库
     * 
     * @param druginid 药品入库主键
     * @return 药品入库
     */
    @Override
    public DrugIn selectDrugInByDruginid(Long druginid)
    {
        return drugInMapper.selectDrugInByDruginid(druginid);
    }


    //test
    @Override
    public List<DrugIn> selectDrugInNoName(DrugIn drugin) {
        return drugInMapper.selectDrugInNoName(drugin);
    }


    /**
     * 查询本月的入库信息
     *
     * @param drugin
     * @return 药品入库集合
     */
    @Override
    public List<DrugIn> selectDrugInNameAndNum(DrugIn drugin){
        return drugInMapper.selectDrugInNameAndNum(drugin);
    }

    /**
     * 按月统计入库数据
     * @param drugin
     * @return
     */
    @Override
    public List<DrugIn> selectDrugInNumByMonth(DrugIn drugin){
        return drugInMapper.selectDrugInNumByMonth(drugin);
    }


    /**
     * 查询药品入库列表
     * 
     * @param drugIn 药品入库
     * @return 药品入库
     */
    @Override
    public List<DrugIn> selectDrugInList(DrugIn drugIn)
    {
        return drugInMapper.selectDrugInList(drugIn);
    }

    @Override
    public List<DrugIn> selectDrugInList1(DrugIn drugIn)
    {
        return drugInMapper.selectDrugInList1(drugIn);
    }

    /**
     * 查询入库批次
     * @return
     */
    @Override
    public List<DrugIn> selectDrugInBatch() {
        return drugInMapper.selectDrugInBatch();
    }

    /**
     * 新增药品入库
     * 
     * @param drugIn 药品入库
     * @return 结果
     */
    @Override
    @Transactional
    public int insertDrugIn(DrugIn drugIn)
    {
        if (drugIn.getDruginnum() > 0 ){
            drugInMapper.insertDrugIn(drugIn);
            return drugInMapper.insertStock(drugIn);
        }else {
            throw new RuntimeException("新增失败");
        }
    }

    /**
     * 新增/更新库存表
     * @param drugIn
     * @return
     */
    @Override
    public int insertStock(DrugIn drugIn) {
        return drugInMapper.insertStock(drugIn);
    }

    /**
     * 修改药品入库
     * 
     * @param drugIn 药品入库
     * @return 结果
     */
    @Override
    public int updateDrugIn(DrugIn drugIn)
    {
        return drugInMapper.updateDrugIn(drugIn);
    }

    /**
     * 批量删除药品入库
     * 
     * @param druginids 需要删除的药品入库主键
     * @return 结果
     */
    @Override
    public int deleteDrugInByDruginids(Long[] druginids)
    {
        return drugInMapper.deleteDrugInByDruginids(druginids);
    }

    /**
     * 删除药品入库信息
     * 
     * @param druginid 药品入库主键
     * @return 结果
     */
    @Override
    public int deleteDrugInByDruginid(Long druginid)
    {
        return drugInMapper.deleteDrugInByDruginid(druginid);
    }
}
