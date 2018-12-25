package com.boke.module.mapper;

import com.boke.module.param.ArticleQueryParam;
import com.boke.module.entity.Article;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zu
 */
@Component
public interface ArticleMapper extends Mapper<Article> {

    List<Article> listQuery(ArticleQueryParam queryParam);

}

