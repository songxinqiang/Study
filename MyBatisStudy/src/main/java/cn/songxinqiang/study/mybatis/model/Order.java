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
 * 创建时间：2015年11月30日--下午1:46:21
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.mybatis.model;

import java.io.Serializable;

/**
 * <pre>
 * CREATE TABLE orders(
 *     order_id    INT     PRIMARY KEY     AUTO_INCREMENT,
 *     order_no    VARCHAR(20), 
 *     order_price FLOAT
 * );
 * </pre>
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年11月30日
 *
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -5573562282215751721L;

    // Order实体类中属性名和orders表中的字段名是不一样的
    // id===>order_id
    private int id;
    // orderNo===>order_no
    private String orderNo;
    // price===>order_price
    private float price;

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderNo=" + orderNo + ", price=" + price + "]";
    }

    public int getId() {
        return id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
