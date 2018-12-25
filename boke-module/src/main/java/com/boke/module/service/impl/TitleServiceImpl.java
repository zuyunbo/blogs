package com.boke.module.service.impl;

import com.boke.module.exception.IllegalParameterException;
import com.boke.module.mapper.TitleMapper;
import com.boke.module.entity.Title;
import com.boke.module.param.TitleQueryParam;
import com.boke.module.service.TitleService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author zu
 */
@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    TitleMapper titleMapper;

    @Override
    public int save(Title entity) {
        return titleMapper.insert(entity);
    }

    @Override
    public int update(Title entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            throw new IllegalParameterException("更新内容id不能为空");
        }

        return titleMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            throw new IllegalParameterException("删除操作id不能为空");
        }

        return titleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Title getById(Long id) {
        if (id == null || id == 0L) {
            throw new IllegalParameterException("详情id不能为空");
        }

        Title title = titleMapper.selectByPrimaryKey(id);
        return title;
    }


    @Override
    public List<Title> listQuery(TitleQueryParam queryParam) {
        List<Title> titles = titleMapper.listQuery(queryParam);
        return titles;
    }
}

