package com.yinhai.ibatis.utils;

import java.util.HashMap;

/**
 * Created by zuoyao on 2018/9/14.
 */
public class ParameterMap extends HashMap<Object,Object> {
    private static final long serialVersionUID=1L;
    public ParameterMap(Object... parameters){
        for(int i=0;i<parameters.length-1;i+=2){
            super.put(parameters[i],parameters[i+1]);
        }
    }
}
