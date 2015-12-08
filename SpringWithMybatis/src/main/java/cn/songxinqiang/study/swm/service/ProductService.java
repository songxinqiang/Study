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
 * 创建时间：2015年12月8日--下午2:18:40
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.service;

import java.util.List;

import cn.songxinqiang.study.swm.model.Product;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月8日
 *
 */
public interface ProductService {

    int count();

    List<Product> list();

    List<Product> list(int start, int size);

    Product find(int id);

    void add(Product product);

    void edit(Product product);
}
