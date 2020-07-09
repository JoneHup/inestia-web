package com.cambricon.inestia.modules.system.service.impl;

import com.cambricon.inestia.modules.system.mapper.ProductMapper;
import com.cambricon.inestia.modules.system.po.Product;
import com.cambricon.inestia.modules.system.query.ProductQuery;
import com.cambricon.inestia.modules.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/6/16 19:28
 * @Version: 1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product findById(ProductQuery productQuery) {
        return productMapper.selectByPrimaryKey(productQuery.getId());
    }
}
