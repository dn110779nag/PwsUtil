/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pwsutil;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author user
 */
public class ConvertToJson {
    
    public Map<String, ?> convert(Properties p){
        Map<String, Object> map = new HashMap<>();
        p.forEach((k,v)->{
            parseBranch(map, (String)k, v);
        });
        return map;
    }
    
    private void parseBranch(Map<String, Object> map, String k, Object v){
        String[] ks = k.split("[.]");
        
        for(int i=0; i<ks.length;i++ ){
            if(i==ks.length-1){
                map.put(ks[i], v);
            } else {
                Map<String, Object> cmap = (Map<String, Object>) map.get(ks[i]);
                if(cmap==null){
                    cmap = new HashMap<>();
                    map.put(ks[i], cmap);
                }
                map = cmap;
            }
        }
    }
    
}
