/**
 * <pre>
 * Copyright 2014,2015 阿信sxq(songxinqiang@vip.qq.com).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
/*
 * 创建时间：2015年12月8日--下午3:54:27
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.songxinqiang.study.swm.mapper.ProductMapper;
import cn.songxinqiang.study.swm.model.Product;
import cn.songxinqiang.study.swm.service.ProductService;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月8日
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductMapper productDao;

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public int count() {
        return productDao.count();
    }

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public List<Product> list() {
        return productDao.listAll();
    }

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public List<Product> list(int start, int size) {
        return productDao.listByPage(start, size);
    }

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public Product find(int id) {
        return productDao.find(id);
    }

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public void add(Product product) {
        productDao.insert(product);
    }

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public void edit(Product product) {
        productDao.update(product);
    }

    @Resource
    public void setProductDao(ProductMapper productDao) {
        this.productDao = productDao;
    }

}
