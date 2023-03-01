package com.ruoyi.liuyb.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.liuyb.domain.Drug;
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
import com.ruoyi.liuyb.domain.DrugSupplier;
import com.ruoyi.liuyb.service.IDrugSupplierService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 供应商信息Controller
 * 
 * @author Liuyb
 * @date 2022-03-02
 */
@RestController
@RequestMapping("/drug/supplier")
public class DrugSupplierController extends BaseController
{
    @Autowired
    private IDrugSupplierService drugSupplierService;

    /**
     * 查询供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('drug:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(DrugSupplier drugSupplier)
    {
        startPage();
        List<DrugSupplier> list = drugSupplierService.selectDrugSupplierList(drugSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('drug:supplier:export')")
    @Log(title = "供应商信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DrugSupplier drugSupplier)
    {
        List<DrugSupplier> list = drugSupplierService.selectDrugSupplierList(drugSupplier);
        ExcelUtil<DrugSupplier> util = new ExcelUtil<DrugSupplier>(DrugSupplier.class);
        util.exportExcel(response, list, "供应商信息数据");
    }

    /**
     * 获取供应商信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('drug:supplier:query')")
    @GetMapping(value = "/{supplierid}")
    public AjaxResult getInfo(@PathVariable("supplierid") Long supplierid)
    {
        return AjaxResult.success(drugSupplierService.selectDrugSupplierBySupplierid(supplierid));
    }

    /**
     * 新增供应商信息
     */
    @PreAuthorize("@ss.hasPermi('drug:supplier:add')")
    @Log(title = "供应商信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DrugSupplier drugSupplier)
    {
        return toAjax(drugSupplierService.insertDrugSupplier(drugSupplier));
    }

    /**
     * 下拉查询数据  查询供应商名称...
     *
     */
    @PreAuthorize("@ss.hasAnyPermi('drug:supplier:query')")
    @GetMapping("/getname")
    public AjaxResult getname(DrugSupplier drugSupplier){
        return AjaxResult.success(drugSupplierService.selectSupplierName(drugSupplier));
    }

    /**
     * 修改供应商信息
     */
    @PreAuthorize("@ss.hasPermi('drug:supplier:edit')")
    @Log(title = "供应商信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DrugSupplier drugSupplier)
    {
        return toAjax(drugSupplierService.updateDrugSupplier(drugSupplier));
    }

    /**
     * 删除供应商信息
     */
    @PreAuthorize("@ss.hasPermi('drug:supplier:remove')")
    @Log(title = "供应商信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{supplierids}")
    public AjaxResult remove(@PathVariable Long[] supplierids)
    {
        return toAjax(drugSupplierService.deleteDrugSupplierBySupplierids(supplierids));
    }

    /**
     * 导入模板
     * @param response
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response){
        ExcelUtil<DrugSupplier> util = new ExcelUtil<>(DrugSupplier.class);
        util.importTemplateExcel(response,"供应商数据模板");
    }

    /**
     * 导入数据
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @PostMapping("/importDrugSupplier")
    public AjaxResult importDrugSupplier(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DrugSupplier> util = new ExcelUtil<>(DrugSupplier.class);
        List<DrugSupplier> drugList = util.importExcel(file.getInputStream());
        String message = drugSupplierService.importDrugSupplier(drugList,updateSupport);
        return AjaxResult.success(message);
    }
}
