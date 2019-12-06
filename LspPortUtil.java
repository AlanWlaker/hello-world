package com.WZT.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.WZT.bean.LspPort;

public class LspPortUtils {	
	//求中位数
	public static int median(int a[]){
		int s=0;
		for(int i=0;i<a.length;i++){
			if(a.length % 2 ==0){				
				s=a[(a.length/2)-1];				 
			}else{
				s=a[a.length/2];			 
			}
		}
		return s;	
	}
	//快速排序 nlogn	
	public static void quick_Sort(int a[],int l,int r){		
	   if(l<r){
		   
		   int i=l,j=r,x=a[l];
		   
		   while(i<j){				  	   
			   while(i<j && a[j]>=x)
				   j--;	
			   
			   if(i<j)
				   a[i++]=a[j];		
			   
			   while(i<j && a[i]<x)
				   i++;	
			   
			   if(i<j)
				   a[j--]=a[i];
			  			   
		   }
		   a[i]=x;
		   quick_Sort(a, l, i-1);
		   quick_Sort(a, i+1, r);
	   }
	   	
	}
	
//	public static int [] func(List<LspPort> lspport){
//		int A[]=new int[lspport.size()+1];
//		int j=0;
//		for(int i=0;i<lspport.size();i++){
//			String a=lspport.get(i).getA1();
//		    List<Integer> index =getIndex(a,".");
//		    String b=a.substring(0,index.get(0));
//		    int a1=Integer.parseInt(b);
//		    A[j++]=a1;		
//		}
//		return A;
//	}

	
	//从取出的是String类型，需要将它转换为int类型，直接转换会报错
	 public static int func(String s){
		 List<Integer> index=getIndex(s,".");
		 String b=s.substring(0, index.get(0));
		 int a=Integer.parseInt(b);
		 return a;
	 }
//	//提取相同网源 的下标，封装到一个list集合中去	
//	public static List<Map<String,Object>> func1(List<LspPort> lspport){
//		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
//		Map<String,Object> map =new HashMap<String,Object>();
//		int B[]=new int[lspport.size()+1];
//		int i=0,j=0;
//		int x=0,y=0; // x为参考值的下标索引，y为数组下标 
//		for(i=x;i<lspport.size();i++){			
//			String a=lspport.get(x).getA3();
//			System.out.println("参考值a"+x+"是 : "+a);
//			System.out.println("外循环");
//			for(j=i+1;j<lspport.size()+1;j++){
////		        		
//			   String b=lspport.get(j).getA3();
//			   System.out.println("相同的b"+j+"是: "+b);
//			   System.out.println("内循环");
//			   if(a.equals(b)){
//				  B[y]=func(lspport.get(j).getA1());
//				  y++;
//				//  System.out.println("相同的b"+j+"是: "+b);
//			   }
//			   else{
//				  x=j;
//				  y=0;
//				//  System.out.println("不同的b"+j+"是:  "+b);
//				  break;
//			   }
//			   
//			}
//	//
//			map.put(lspport.get(x).getA3(), B);
//			list.add(map);		 
//		}
//		return list;	
//	}	 
		//提取相同网源 的下标，封装到一个list集合中去	
		public static List<Map<String,List<Integer>>> func1(List<LspPort> lspport){
			List<Map<String,List<Integer>>> list=new ArrayList<Map<String,List<Integer>>>();
			Map<String,List<Integer>> map =new HashMap<String,List<Integer>>();
			List<Integer> list1=new ArrayList<Integer>();
			int x=0; // x为参考值的下标索引，y为数组下标 
			for(int i=x;i<lspport.size();i+=(x-i)){			
				String a=lspport.get(x).getA3();
				for(int j=x;j<lspport.size();j++){			        		
				   String b=lspport.get(j).getA3();
				   if(a.equals(b)){					  
					//  System.out.println(func(lspport.get(j).getA1()));
					  list1.add(func(lspport.get(j).getA1()));				  
				   }   
				   else{
					  x=j;
				      System.out.println("第"+(j)+"行"+lspport.get(j).getA1()+"/"+lspport.get(j).getA3());
					  map.put(lspport.get(x-1).getA3(), list1);
//					  System.out.println(map);
					  list1.clear();					  
					  break;
				   }			   
				}				 
				list.add(map);		 
			}
			return list;	
		}
		
	//将list集合中的每一个数组进行排序，然后取中位数	
	public static int[] Sort_Median(List<int []> list){
		int s[]=new int[list.size()+1],j=0;
		for(int i=0;i<list.size();i++,j++){
			quick_Sort(list.get(i), 0, list.get(i).length-1);
			s[j]=median(list.get(i));
		}
		return s;		
	}
	
	public static List<Integer> getIndex(String strings,String str){
		List<Integer> list = new ArrayList<>();
		int flag = 0;
		while(strings.indexOf(str)!=-1) {
			String aa = strings.substring(0,strings.indexOf(str)+str.length());
			flag = flag+aa.length();
			list.add(flag-str.length());
			strings = strings.substring(strings.indexOf(str)+str.length());
		}
		return list;
	}
	
 
}
