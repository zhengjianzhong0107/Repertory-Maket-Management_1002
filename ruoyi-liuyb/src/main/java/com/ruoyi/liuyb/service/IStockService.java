package com.ruoyi.liuyb.service;

import java.util.List;

import com.ruoyi.liuyb.domain.DrugJournalAccount;
import com.ruoyi.liuyb.domain.Stock;

/**
 * 库存Service接口
 * 
 * @author liuyb
 * @date 2022-02-23
 */
public interface IStockService 
{
    /**
     * 查询库存
     * 
     * @param stockid 库存主键
     * @return 库存
     */
    public Stock selectStockByStockid(Long stockid);

    /**
     * 查询库存列表
     * 
     * @param stock 库存
     * @return 库存集合
     */
    public List<Stock> selectStockList(Stock stock);
    public List<Stock> selectStockList1(Stock stock);

    /**
     * 药品流水
     * @param DrugNo
     * @return
     */
    List<DrugJournalAccount> selectDrugdetilInfoByDrugNo(Long DrugNo);

    /**
     * 新增库存
     * 
     * @param stock 库存
     * @return 结果
     */
    public int insertStock(Stock stock);

    /**
     * 修改库存
     * 
     * @param stock 库存
     * @return 结果
     */
    public int updateStock(Stock stock);

    /**
     * 批量删除库存
     * 
     * @param stockids 需要删除的库存主键集合
     * @return 结果
     */
    public int deleteStockByStockids(Long[] stockids);

    /**
     * 删除库存信息
     * 
     * @param stockid 库存主键
     * @return 结果
     */
    public int deleteStockByStockid(Long stockid);
}
