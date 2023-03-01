package com.ruoyi.liuyb.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.liuyb.domain.DrugOut;
import com.ruoyi.liuyb.service.IDrugOutService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出库Controller
 *
 * @author liuyb
 * @date 2022-02-24
 */
@RestController
@RequestMapping("/drug/out")
public class DrugOutController extends BaseController
{
    @Autowired
    private IDrugOutService drugOutService;

    /**
     * 查询出库列表
     */
    @PreAuthorize("@ss.hasPermi('drug:out:list')")
    @GetMapping("/list")
    public TableDataInfo list(DrugOut drugOut)
    {
        startPage();
        List<DrugOut> list = drugOutService.selectDrugOutList(drugOut);
        return getDataTable(list);
    }

    /**
     * 导出出库列表
     */
    @PreAuthorize("@ss.hasPermi('drug:out:export')")
    @Log(title = "出库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DrugOut drugOut)
    {
        List<DrugOut> list = drugOutService.selectDrugOutList(drugOut);
        ExcelUtil<DrugOut> util = new ExcelUtil<DrugOut>(DrugOut.class);
        util.exportExcel(response, list, "出库数据");
    }

    /**
     * 获取出库详细信息
     */
    @PreAuthorize("@ss.hasPermi('drug:out:query')")
    @GetMapping(value = "/{drugoutid}")
    public AjaxResult getInfo(@PathVariable("drugoutid") Long drugoutid)
    {
        return AjaxResult.success(drugOutService.selectDrugOutByDrugoutid(drugoutid));
    }

    /**
     * 当月出库记录 -图表
     * @param drugOut
     * @return
     */
    @PreAuthorize("@ss.hasAnyPermi('drug:out:query')")
    @GetMapping("/listdataout")
    public AjaxResult getdata(DrugOut drugOut){
        return AjaxResult.success(drugOutService.selectDrugOutNoAndName(drugOut));
    }

    /**
     * 按月统计出库数量 -图表
     * @param drugOut
     * @return
     */
    @PreAuthorize("@ss.hasAnyPermi('drug:out:query')")
    @GetMapping("/getmonthdata")
    public AjaxResult GetMonthData(DrugOut drugOut) {
        return AjaxResult.success(drugOutService.selectDrugOutNumByMonth(drugOut));
    }


    /**
     * 新增出库
     */
    @PreAuthorize("@ss.hasPermi('drug:out:add')")
    @Log(title = "出库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DrugOut drugOut)
    {
           return toAjax(drugOutService.insertDrugOut(drugOut));
    }

    /**
     * 修改出库
     */
    @PreAuthorize("@ss.hasPermi('drug:out:edit')")
    @Log(title = "出库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DrugOut drugOut)
    {
        return toAjax(drugOutService.updateDrugOut(drugOut));
    }

    /**
     * 删除出库
     */
    @PreAuthorize("@ss.hasPermi('drug:out:remove')")
    @Log(title = "出库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{drugoutids}")
    public AjaxResult remove(@PathVariable Long[] drugoutids)
    {
        return toAjax(drugOutService.deleteDrugOutByDrugoutids(drugoutids));
    }
}
