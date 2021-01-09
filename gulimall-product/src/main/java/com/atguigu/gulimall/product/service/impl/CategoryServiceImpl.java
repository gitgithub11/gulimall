package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 返回商品分类树
     * 类似用数组存一个树
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        //得到按等级及排序号排序后的,等级和排序号均非空
        List<CategoryEntity> list = baseMapper.getCategoryOrderByCatLevelAndSort();
        int max_level = -1;
        if(list.size()>0)
            max_level = list.get(0).getCatLevel();
        List<CategoryEntity> root = new ArrayList<>();
        for (CategoryEntity node: list) {
            if (node.getCatLevel() == 1)
                root.add(node);
            if (node.getCatLevel() != max_level)
                node.setChildNode(new ArrayList<>());
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
//                if (list.get(i).getParentCid() == list.get(j).getCatId()) {
                if (list.get(i).getParentCid().equals(list.get(j).getCatId())) {
                    list.get(j).getChildNode().add(list.get(i));
                    break;
                }
            }

        }
        return root;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 检查当前的菜单是否被别的地方所引用
        baseMapper.deleteBatchIds(asList);
    }

}