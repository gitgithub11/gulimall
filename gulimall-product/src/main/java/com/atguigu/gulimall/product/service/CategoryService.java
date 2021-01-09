package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author zjc
 * @email zjc@gmail.com
 * @date 2021-01-05 15:49:45
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 返回商品分类树
     */
    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);
}

