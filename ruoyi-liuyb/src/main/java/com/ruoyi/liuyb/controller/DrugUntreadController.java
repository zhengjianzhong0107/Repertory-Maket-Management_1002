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
import com.ruoyi.liuyb.domain.DrugUntread;
import com.ruoyi.liuyb.service.IDrugUntreadService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品退回Controller
 * 
 * @author Liuyb
 * @date 2022-03-02
 */
@RestController
@RequestMapping("/drug/untread")
public class DrugUntreadController extends BaseController
{
    @Autowired
    private IDrugUntreadService drugUntreadService;

    /**
     * 查询药品退回列表
     */
    @PreAuthorize("@ss.hasPermi('drug:untread:list')")
    @GetMapping("/list")
    public TableDataInfo list(DrugUntread drugUntread)
    {
        startPage();
        List<DrugUntread> list = drugUntreadService.selectDrugUntreadList(drugUntread);
        return getDataTable(list);
    }

    /**
     * 导出药品退回列表
     */
    @PreAuthorize("@ss.hasPermi('drug:untread:export')")
    @Log(title = "药品退回", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DrugUntread drugUntread)
    {
        List<DrugUntread> list = drugUntreadService.selectDrugUntreadList(drugUntread);
        ExcelUtil<DrugUntread> util = new ExcelUtil<DrugUntread>(DrugUntread.class);
        util.exportExcel(response, list, "药品退回数据");
    }

    @PreAuthorize("@ss.hasAnyPermi('drug:untread:query')")
    @GetMapping("/getchartdata")
    public AjaxResult getChartList(DrugUntread drugUntread){
        return AjaxResult.success(drugUntreadService.selectUntreadChart(drugUntread));
    }

    /**
     * 获取药品退回详细信息
     */
    @PreAuthorize("@ss.hasPermi('drug:untread:query')")
    @GetMapping(value = "/{untreadid}")
    public AjaxResult getInfo(@PathVariable("untreadid") Long untreadid)
    {
        return AjaxResult.success(drugUntreadService.selectDrugUntreadByUntreadid(untreadid));
    }

    /**
     * 新增药品退回
     */
    @PreAuthorize("@ss.hasPermi('drug:untread:add')")
    @Log(title = "药品退回", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DrugUntread drugUntread)
    {
       return toAjax(drugUntreadService.insertDrugUntread(drugUntread));
    }

    /**
     * 修改药品退回
     */
    @PreAuthorize("@ss.hasPermi('drug:untread:edit')")
    @Log(title = "药品退回", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DrugUntread drugUntread)
    {
        return toAjax(drugUntreadService.updateDrugUntread(drugUntread));
    }

    /**
     * 删除药品退回
     */
    @PreAuthorize("@ss.hasPermi('drug:untread:remove')")
    @Log(title = "药品退回", businessType = BusinessType.DELETE)
	@DeleteMapping("/{untreadids}")
    public AjaxResult remove(@PathVariable Long[] untreadids)
    {
        return toAjax(drugUntreadService.deleteDrugUntreadByUntreadids(untreadids));
    }
}
