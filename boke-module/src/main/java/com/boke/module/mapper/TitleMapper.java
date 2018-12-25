package com.boke.module.mapper;

import com.boke.module.param.TitleQueryParam;
import com.boke.module.entity.Title;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zu
 */
@Component
public interface TitleMapper extends Mapper<Title> {

    List<Title> listQuery(TitleQueryParam queryParam);

}

