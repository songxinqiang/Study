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
 * 创建时间：2015年11月30日--下午2:50:15
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.mybatis.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import cn.songxinqiang.study.mybatis.model.Order;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年11月30日
 *
 */
public interface OrderMapper {

    @Select("select * from orders where order_id=#{id}")
    @Results(value = {
            @Result(id = true, property = "id", column = "order_id", javaType = Integer.class,
                    jdbcType = JdbcType.INTEGER),
            @Result(property = "orderNo", column = "order_no", javaType = String.class,
                    jdbcType = JdbcType.VARCHAR),
            @Result(property = "price", column = "order_price", javaType = Float.class,
                    jdbcType = JdbcType.FLOAT) })
    public Order getById(int id);

}
