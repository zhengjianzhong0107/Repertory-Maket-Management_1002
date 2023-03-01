package com.ruoyi.liuyb.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.liuyb.domain.DrugIn;
import com.ruoyi.liuyb.service.IDrugInService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品入库Controller
 * 
 * @author liuyb
 * @date 2022-02-23
 */
@RestController
@RequestMapping("/drug/drugin")
public class DrugInController extends BaseController
{
    @Autowired
    private IDrugInService drugInService;

    /**
     * 查询药品入库列表
     */
    @PreAuthorize("@ss.hasPermi('drug:drugin:list')")
    @GetMapping("/list")
    public TableDataInfo list(DrugIn drugIn)
    {
        startPage();
        List<DrugIn> list = drugInService.selectDrugInList(drugIn);
        return getDataTable(list);
    }
    //查距离过保90天的
    @PreAuthorize("@ss.hasPermi('drug:drugin:list')")
    @GetMapping("/list1")
    public TableDataInfo list1(DrugIn drugIn)
    {
        return getDataTable(drugInService.selectDrugInList1(drugIn));
    }

    //test
    @GetMapping("/getname")
    public AjaxResult getnameno(DrugIn drugIn){
        return AjaxResult.success(drugInService.selectDrugInNoName(drugIn));
    }

    /**
     * 查询本月的入库信息
     *
     * @param drugIn
     * @return 药品入库集合
     */
    @PreAuthorize("@ss.hasAnyPermi('drug:drugin:query')")
    @GetMapping("/getdata")
    public AjaxResult getdata(DrugIn drugIn){
      return AjaxResult.success(drugInService.selectDrugInNameAndNum(drugIn));
    }

    @PreAuthorize("@ss.hasAnyPermi('drug:drugin:query')")
    @GetMapping("/getmonthdata")
    public AjaxResult GetMonthData(DrugIn drugIn) {
        return AjaxResult.success(drugInService.selectDrugInNumByMonth(drugIn));
    }

    /**
     * 查询入库批次
     * @return
     */
    @PreAuthorize("@ss.hasAnyPermi('drug:drugin:query')")
    @GetMapping("/drunginbatch")
    public AjaxResult GetBatch(){
        return AjaxResult.success(drugInService.selectDrugInBatch());
    }

    /**
     * 导出药品入库列表
     */
    @PreAuthorize("@ss.hasPermi('drug:drugin:export')")
    @Log(title = "药品入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DrugIn drugIn)
    {
        List<DrugIn> list = drugInService.selectDrugInList(drugIn);
        ExcelUtil<DrugIn> util = new ExcelUtil<DrugIn>(DrugIn.class);
        util.exportExcel(response, list, "药品入库数据");
    }

    /**
     * 获取药品入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('drug:drugin:query')")
    @GetMapping(value = "/{druginid}")
    public AjaxResult getInfo(@PathVariable("druginid") Long druginid)
    {
        return AjaxResult.success(drugInService.selectDrugInByDruginid(druginid));
    }

    /**
     * 新增药品入库
     */
    @PreAuthorize("@ss.hasPermi('drug:drugin:add')")
    @Log(title = "药品入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DrugIn drugIn)
    {
        return toAjax(drugInService.insertDrugIn(drugIn));
    }

    /**
     * 修改药品入库
     */
    @PreAuthorize("@ss.hasPermi('drug:drugin:edit')")
    @Log(title = "药品入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DrugIn drugIn)
    {
        return toAjax(drugInService.updateDrugIn(drugIn));
    }

    /**
     * 删除药品入库
     */
    @PreAuthorize("@ss.hasPermi('drug:drugin:remove')")
    @Log(title = "药品入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{druginids}")
    public AjaxResult remove(@PathVariable Long[] druginids)
    {
        return toAjax(drugInService.deleteDrugInByDruginids(druginids));
    }
}
