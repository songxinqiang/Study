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
 * 创建时间：2015年11月9日--上午9:44:41
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.velocity.model;

import java.io.Serializable;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年11月9日
 *
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -8067228713252553573L;

    private String name;
    private float height;
    private int age;

    public String getName(String arg) {
        return arg.toUpperCase();
    }

    @Override
    public String toString() {
        return "name:" + name + ", age:" + age + ", height:" + height;
    }

    public String getName() {
        return name;
    }

    public float getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
