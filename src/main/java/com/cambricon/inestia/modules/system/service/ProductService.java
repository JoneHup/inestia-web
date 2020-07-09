package com.cambricon.inestia.modules.system.service;

import com.cambricon.inestia.modules.system.po.Product;
import com.cambricon.inestia.modules.system.query.ProductQuery;

public interface ProductService {

    Product findById(ProductQuery productQuery);
}
