package com.ruoyi.liuyb.service.impl;

import java.util.List;

import com.ruoyi.liuyb.domain.DrugJournalAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.liuyb.mapper.StockMapper;
import com.ruoyi.liuyb.domain.Stock;
import com.ruoyi.liuyb.service.IStockService;

/**
 * 库存Service业务层处理
 * 
 * @author liuyb
 * @date 2022-02-23
 */
@Service
public class StockServiceImpl implements IStockService 
{
    @Autowired
    private StockMapper stockMapper;

    /**
     * 查询库存
     * 
     * @param stockid 库存主键
     * @return 库存
     */
    @Override
    public Stock selectStockByStockid(Long stockid)
    {
        return stockMapper.selectStockByStockid(stockid);
    }

    /**
     * 查询库存列表
     * 
     * @param stock 库存
     * @return 库存
     */
    @Override
    public List<Stock> selectStockList(Stock stock)
    {
        return stockMapper.selectStockList(stock);
    }

    @Override
    public List<Stock> selectStockList1(Stock stock)
    {
        return stockMapper.selectStockList1(stock);
    }

    /**
     * 药品流水记录
     * @param DrugNo
     * @return
     */
    @Override
    public List<DrugJournalAccount> selectDrugdetilInfoByDrugNo(Long DrugNo) {
        return stockMapper.selectDrugdetilInfoByDrugNo(DrugNo);
    }

    /**
     * 新增库存
     * 
     * @param stock 库存
     * @return 结果
     */
    @Override
    public int insertStock(Stock stock)
    {
        return stockMapper.insertStock(stock);
    }

    /**
     * 修改库存
     * 
     * @param stock 库存
     * @return 结果
     */
    @Override
    public int updateStock(Stock stock)
    {
        return stockMapper.updateStock(stock);
    }

    /**
     * 批量删除库存
     * 
     * @param stockids 需要删除的库存主键
     * @return 结果
     */
    @Override
    public int deleteStockByStockids(Long[] stockids)
    {
        return stockMapper.deleteStockByStockids(stockids);
    }

    /**
     * 删除库存信息
     * 
     * @param stockid 库存主键
     * @return 结果
     */
    @Override
    public int deleteStockByStockid(Long stockid)
    {
        return stockMapper.deleteStockByStockid(stockid);
    }
}
