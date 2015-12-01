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
 * 创建时间：2015年11月30日--下午5:24:19
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.mybatis.sqlprovider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年11月30日
 *
 */
public class OrderSQLProvider {

    private static final String TABLE_NAME = "orders";

    public String getSql(Map<String, Object> parameters) {
        Integer uid = (Integer) parameters.get("id");
        SQL sql = new SQL().SELECT("order_id, order_no, order_price").FROM(TABLE_NAME);
        if (uid != null) {
            sql = sql.WHERE("order_id = #{id}");
        }
        return sql.toString();
    }

    public String getAllSql() {
        SQL sql = new SQL().SELECT("order_id, order_no, order_price").FROM(TABLE_NAME);
        return sql.toString();
    }

}