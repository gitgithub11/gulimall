package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品三级分类
 * 
 * @author zjc
 * @email zjc@gmail.com
 * @date 2021-01-05 15:49:45
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
   List<CategoryEntity> getCategoryOrderByCatLevelAndSort();
}
