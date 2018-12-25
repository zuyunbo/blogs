package com.boke.module.controller;

import com.boke.module.common.BaseResponseUtil;
import com.boke.module.param.TitleQueryParam;
import com.boke.module.service.TitleService;
import com.boke.module.entity.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author zu
 */
@RestController
@RequestMapping("/boke/title")
public class TitleController {

    @Autowired
    TitleService titleService;

    @PostMapping(value = "/save")
    public Object save(@RequestBody Title entity) {
        int result = titleService.save(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "保存成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "保存失败", result);
        }
    }

    @GetMapping(value = "/{id}/detail")
    public Object detail(@PathVariable long id) {
        Title entity = titleService.getById(id);
        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", entity);
    }

    @PutMapping(value = "/update")
    public Object update(@RequestBody Title entity) {
        int result = titleService.update(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "修改成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "修改失败");
        }
    }

    @DeleteMapping(value = "/{id}")
    public Object remove(@PathVariable long id) {
        int result = titleService.remove(id);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "删除成功");
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "删除失败");
        }
    }

    @GetMapping(value = "/list")
    public Object list(TitleQueryParam queryParam) {
        List<Title> pageInfo = titleService.listQuery(queryParam);

        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", pageInfo);
    }
}

