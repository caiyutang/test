package com.ruoyi.project.zazl.service.impl.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.bean.PageData;
import com.ruoyi.project.zazl.mapper.BaseMapper;
import com.ruoyi.project.zazl.service.base.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<D extends BaseMapper<T>, T> implements BaseService<T> {
    protected static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    protected D mapper;

    /**
     * 保存对象
     *
     * @param t
     * @throws Exception
     */
    @Override
    public void save(T t) throws Exception {
        mapper.insert(t);
    }

    @Override
    public void saveSelective(T t) throws Exception {
        mapper.insertSelective(t);
    }
    /**
     * 更新对象
     *
     * @param t
     * @throws Exception
     */
    @Override
    public void update(T t) throws Exception {
        mapper.updateByPrimaryKey(t);
    }

    /**
     * 删除对象
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteById(String id) throws Exception {
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public T getById(String id) throws Exception {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 获取所有数据
     *
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public List<T> getListAll(String order) throws Exception {
        return mapper.getListAll(order);
    }

    /**
     * 分页查询
     *
     * @param condition
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<T> getPageInfo(Map<String, Object> condition, PageData pageData) throws Exception {
        PageHelper.startPage(pageData.getPage(), pageData.getLimit());
        return new PageInfo<T>(mapper.getListForPager(condition));
    }
}
