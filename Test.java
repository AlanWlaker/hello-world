package com.WZT.test;

import com.WZT.bean.LspPort;
import com.WZT.controller.LspPortGet;
import com.WZT.controller.LspPortUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

 
public class Test {

    public static void main(String[] args) throws Exception {
        String lsppath ="C:\\Users\\Administrator\\Desktop\\统计LSP业务的跳数及端口(1).xls";

        // columns i,j,k
        List<LspPort> lspPorts = LspPortGet.ReadExcelLSP(lsppath);
        System.out.println(lspPorts);
        Map<String,List<LspPort>> map = lspPorts.stream().collect(Collectors.groupingBy(LspPort::getA3,Collectors.toList()));
        
    //    System.out.println(map);
        
        
        for (String key : map.keySet()) {
            System.out.println("key is "+ key);

            // 从excel中读取的数据是double类型格式,int会出错
            // 从小到大排序          
            List<Double> a1List = map.get(key).stream().map(r -> Double.valueOf(r.getA1())).sorted().collect(Collectors.toList());
            List<Double> a2List = map.get(key).stream().map(r -> Double.valueOf(r.getA2())).sorted().collect(Collectors.toList());           
//            System.out.println(a1List.stream().map(r -> String.valueOf(r.intValue())).collect(Collectors.joining(",")));
//            System.out.println(a2List.stream().map(r -> String.valueOf(r.intValue())).collect(Collectors.joining(",")));
            
            //double -> int
            int[] a1 = a1List.stream().map(r -> r.intValue()).mapToInt(Integer::valueOf).toArray();
          
            int med1 = LspPortUtils.median(a1);
            System.out.println("median value is "+med1);

            int[] a2 = a2List.stream().map(r -> r.intValue()).mapToInt(Integer::valueOf).toArray();
            int med2 = LspPortUtils.median(a2);
            System.out.println("median2 value is "+med2);

        }

    }


}
