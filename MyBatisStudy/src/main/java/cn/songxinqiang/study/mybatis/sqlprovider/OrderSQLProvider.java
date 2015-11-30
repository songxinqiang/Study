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
        String uid = (String) parameters.get("id");
        SQL sql = new SQL().SELECT("test_id, test_text").FROM(TABLE_NAME);
        if (uid != null) {
            sql = sql.WHERE("test_id = #{id,javaType=string,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }

    public String getAllSql() {
        SQL sql = new SQL().SELECT("test_id, test_text").FROM(TABLE_NAME);
        return sql.toString();
    }

    public String getByTestTextSql(Map<String, Object> parameters) {
        String tText = (String) parameters.get("testText");
        SQL sql = new SQL().SELECT("test_id, test_text").FROM(TABLE_NAME);
        if (tText != null) {
            sql = sql.WHERE("test_text like #{testText,javaType=string,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }

    public String insertSql() {
        SQL sql = new SQL().INSERT_INTO(TABLE_NAME)
                .VALUES("test_id", "#{testBean.id,javaType=string,jdbcType=VARCHAR}")
                .VALUES("test_text", "#{testBean.testText,javaType=string,jdbcType=VARCHAR}");
        return sql.toString();
    }

    public String updateSql() {
        SQL sql = new SQL().UPDATE(TABLE_NAME)
                .SET("test_text = #{testBean.testText,javaType=string,jdbcType=VARCHAR}")
                .WHERE("test_id = #{testBean.id,javaType=string,jdbcType=VARCHAR}");
        return sql.toString();
    }

    public String deleteSql() {
        SQL sql = new SQL().DELETE_FROM(TABLE_NAME).WHERE(
                "test_id = #{id,javaType=string,jdbcType=VARCHAR}");
        return sql.toString();
    }
}
