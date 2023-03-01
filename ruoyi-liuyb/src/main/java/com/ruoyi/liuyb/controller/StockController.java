package com.ruoyi.liuyb.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.liuyb.domain.DrugJournalAccount;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.liuyb.domain.Stock;
import com.ruoyi.liuyb.service.IStockService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存Controller
 * 
 * @author liuyb
 * @date 2022-02-23
 */
@RestController
@RequestMapping("/drug/stock")
public class StockController extends BaseController
{
    @Autowired
    private IStockService stockService;

    /**
     * 查询库存列表
     */
    @PreAuthorize("@ss.hasPermi('drug:stock:list')")
    @GetMapping("/list")
    public TableDataInfo list(Stock stock)
    {
        startPage();
        List<Stock> list = stockService.selectStockList(stock);
        return getDataTable(list);
    }
    //库存不足
    @PreAuthorize("@ss.hasPermi('drug:stock:list')")
    @GetMapping("/listnopage")
    public TableDataInfo listNoPage(Stock stock)
    {
        List<Stock> list = stockService.selectStockList1(stock);
        return getDataTable(list);
    }

    /**
     * 药品流水
     * @param drugJournalAccount
     * @return
     */
    @GetMapping("/DrugJournalAccount")
    public TableDataInfo listDrugJournalAccount(DrugJournalAccount drugJournalAccount){
        startPage();
        return getDataTable(stockService.selectDrugdetilInfoByDrugNo(drugJournalAccount.getDrugNo()));
    }

    /**
     * 导出库存列表
     */
    @PreAuthorize("@ss.hasPermi('drug:stock:export')")
    @Log(title = "库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Stock stock)
    {
        List<Stock> list = stockService.selectStockList(stock);
        ExcelUtil<Stock> util = new ExcelUtil<Stock>(Stock.class);
        util.exportExcel(response, list, "库存数据");
    }

    /**
     * 获取库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('drug:stock:query')")
    @GetMapping(value = "/{stockid}")
    public AjaxResult getInfo(@PathVariable("stockid") Long stockid)
    {
        return AjaxResult.success(stockService.selectStockByStockid(stockid));
    }

    /**
     * 新增库存
     */
    @PreAuthorize("@ss.hasPermi('drug:stock:add')")
    @Log(title = "库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Stock stock)
    {
        return toAjax(stockService.insertStock(stock));
    }

    /**
     * 修改库存
     */
    @PreAuthorize("@ss.hasPermi('drug:stock:edit')")
    @Log(title = "库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Stock stock)
    {
        return toAjax(stockService.updateStock(stock));
    }

    /**
     * 删除库存
     */
    @PreAuthorize("@ss.hasPermi('drug:stock:remove')")
    @Log(title = "库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stockids}")
    public AjaxResult remove(@PathVariable Long[] stockids)
    {
        return toAjax(stockService.deleteStockByStockids(stockids));
    }
}
