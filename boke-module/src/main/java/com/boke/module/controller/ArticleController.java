package com.boke.module.controller;

import com.boke.module.common.BaseResponseUtil;
import com.boke.module.param.ArticleQueryParam;
import com.boke.module.service.ArticleService;
import com.boke.module.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author zu
 */
@RestController
@RequestMapping("/boke/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping(value = "/save")
    public Object save(@RequestBody Article entity) {
        int result = articleService.save(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "保存成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "保存失败", result);
        }
    }

    @GetMapping(value = "/{id}/detail")
    public Object detail(@PathVariable long id) {
        Article entity = articleService.getById(id);
        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", entity);
    }

    @PutMapping(value = "/update")
    public Object update(@RequestBody Article entity) {
        int result = articleService.update(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "修改成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "修改失败");
        }
    }

    @DeleteMapping(value = "/{id}")
    public Object remove(@PathVariable long id) {
        int result = articleService.remove(id);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "删除成功");
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "删除失败");
        }
    }

    @GetMapping(value = "/list")
    public Object list(ArticleQueryParam queryParam) {
        List<Article> pageInfo = articleService.listQuery(queryParam);

        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", pageInfo);
    }
}

