package com.boke.module.service.impl;

import com.boke.module.exception.IllegalParameterException;
import com.boke.module.mapper.ArticleMapper;
import com.boke.module.entity.Article;
import com.boke.module.param.ArticleQueryParam;
import com.boke.module.service.ArticleService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zu
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int save(Article entity) {
        return articleMapper.insert(entity);
    }

    @Override
    public int update(Article entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            throw new IllegalParameterException("更新内容id不能为空");
        }

        return articleMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            throw new IllegalParameterException("删除操作id不能为空");
        }

        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Article getById(Long id) {
        if (id == null || id == 0L) {
            throw new IllegalParameterException("详情id不能为空");
        }

        return articleMapper.selectByPrimaryKey(id);
    }



    @Override
    public List<Article> listQuery(ArticleQueryParam queryParam) {
        List<Article> articles = articleMapper.listQuery(queryParam);

        return articles;
    }
}

