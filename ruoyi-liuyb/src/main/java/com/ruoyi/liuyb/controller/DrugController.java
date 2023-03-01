package com.ruoyi.liuyb.controller;

import java.io.IOException;
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
import com.ruoyi.liuyb.domain.Drug;
import com.ruoyi.liuyb.service.IDrugService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 药品信息管理Controller
 * 
 * @author liuyb
 * @date 2022-02-23
 */
@RestController
@RequestMapping("/drug/info")
public class DrugController extends BaseController
{
    @Autowired
    private IDrugService drugService;

    /**
     * 查询药品信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('drug:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(Drug drug)
    {
        startPage();
        List<Drug> list = drugService.selectDrugList(drug);
        return getDataTable(list);
    }
    /**
     * 导出药品信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('drug:info:export')")
    @Log(title = "药品信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Drug drug)
    {
        List<Drug> list = drugService.selectDrugList(drug);
        ExcelUtil<Drug> util = new ExcelUtil<Drug>(Drug.class);
        util.exportExcel(response, list, "药品信息管理数据");
    }

    /**
     * 下拉选择
     *
     */
    @GetMapping("/getname")
    public AjaxResult getname(Drug drug){
        return  AjaxResult.success(drugService.selectDrugNoName(drug));
    }
    /**
     * 获取药品信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('drug:info:query')")
    @GetMapping(value = "/{drugid}")
    public AjaxResult getInfo(@PathVariable("drugid") Long drugid)
    {
        return AjaxResult.success(drugService.selectDrugByDrugid(drugid));
    }

    /**
     * 新增药品信息管理
     */
    @PreAuthorize("@ss.hasPermi('drug:info:add')")
    @Log(title = "药品信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Drug drug)
    {
           return toAjax(drugService.insertDrug(drug));
    }

    /**
     * 修改药品信息管理
     */
    @PreAuthorize("@ss.hasPermi('drug:info:edit')")
    @Log(title = "药品信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Drug drug)
    {
        return toAjax(drugService.updateDrug(drug));
    }

    /**
     * 删除药品信息管理
     */
    @PreAuthorize("@ss.hasPermi('drug:info:remove')")
    @Log(title = "药品信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{drugids}")
    public AjaxResult remove(@PathVariable Long[] drugids)
    {
        return toAjax(drugService.deleteDrugByDrugids(drugids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response){
    ExcelUtil<Drug> util = new ExcelUtil<>(Drug.class);
    util.importTemplateExcel(response,"药品数据模板");
    }

    @PostMapping("/importDrug")
    public AjaxResult importDrug(MultipartFile file,boolean updateSupport) throws Exception {
        ExcelUtil<Drug> util = new ExcelUtil<>(Drug.class);
        List<Drug> drugList = util.importExcel(file.getInputStream());
        String message = drugService.importDrug(drugList,updateSupport);
        return AjaxResult.success(message);
    }
}
