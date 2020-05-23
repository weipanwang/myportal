package script;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BankScript {
	
	public static Log log = LogFactory.getLog(BankScript.class);

	public static void main(String[] args) {

        String username =  "lixue1981";
        String password = "lixue1981";
        
		//BankScript.BankBusiness(username, password);//银从   	
        BankScript.FundBusiness(username, password);//基金    
        
        log.info("账号="+username);
        log.error("密码="+password);
        }
	//基金从业
	@SuppressWarnings({ "rawtypes", "unchecked", "unused"})
	public static void FundBusiness(String username,String password){
		
		//登录url
		String url1 = "http://peixun.amac.org.cn/index.php?a=login&m=User";
		
		Map<String, String> map = new HashMap<>();
		map.put("email", username);
		map.put("psw", password);
		map.put("remember", "0");
		map.put("verify", "");
		
		
		
		
		
		//每页查询几条数据
		int number = 1;
		//课程休息时间(毫秒)
		int time1=1000;
		//答题休息时间(毫秒)
		int time2=5000;
		//课程ucid
        List listUcid = new ArrayList();
        //课程cid
        List listCid = new ArrayList();
        
        List list = new ArrayList<>();
		//list.add("reatedate");//未学习
		//list.add("last_op_date");//学习中
        list.add("2");//学习中
        list.add("1");//未学习
		//课程详细url
		String url3 = "";
		 //课程详细id
        List listId1 = new ArrayList();
        //课程详细fid
        List listFid1 = new ArrayList();
        //视频json
	    JSONObject object7=new JSONObject();
	    //视频map
	    Map<String,String> map1 = new HashMap<>();
		//完成视频url
	    String url4 = "";
	    //Referer
	    String Referer = null;
		//答题详细
	    String url5 = "";
	    //答题cid
        List listCid1 = new ArrayList();
        //答题artid
        List listArtid1 = new ArrayList();
        //获取答案map
	    Map<String,String> map2 = new HashMap<>();
	    //提交答案map
	    Map<String,String> map3 = new HashMap<>();
	    //获取答案url
	    String url6 = "";
	    //提交答案url
	    String url7 = "";
        //获取cookie
      	String cookie = BankScript.getCookie(url1, map);
		//遍历所有的未完成的课程
		for(int i = 0;i<2;i++) {
			
			String col = (String)list.get(i);
			System.out.println("col="+col);
			log.info("col="+col);
			//课程ulr
			String url2 = "http://peixun.amac.org.cn/index.php?m=Api&agency=3&userclass_list&act=userclass_list&pn="+number+"&pg=1&col=last_op_date&order=desc&grouping_id=&grouping_id1=0&grouping_id2=0&complete=0&status=1&type=1&last_op_date=&is_start="+col+"&no_package=1";
			//已完成的课程
			//String url2 = "https://peixun.amac.org.cn/index.php?m=Api&agency=3&userclass_list&act=userclass_list&pn=9&pg=1&col=createdate&order=desc&grouping_id=&grouping_id1=0&grouping_id2=0&complete=1&status=1&type=1&complete_date=2020&no_package=1";
			String doGet = BankScript.doGet(url2, cookie);
			System.out.println("doGet="+doGet);
			
			JSONObject object = JSON.parseObject(doGet);
			String message = (String)object.get("message");
			System.out.println("message="+message);
			//判断是否存在未完成的课程
			if(message!=null) {
				if(i==0) {
					System.out.println("学习中没有未完成的课程！");
				}else {
					System.out.println("未学习没有未完成的课程！");
				}
			}else{
				JSONArray ja = object.getJSONArray("list");
				int number1 = Integer.parseInt(object.getString("total"));//共有多少个课程
				System.out.println("共有"+number1+"门未完成的课程！");
				//获取ucid和cid
				for(int j=0;j<ja.size();j++) {
	                JSONObject jo = ja.getJSONObject(j);
	                listUcid.add(jo.getString("id"));
	            	listCid.add(jo.getString("cid"));
	            }
	            System.out.println("listUcid:"+listUcid);
	            System.out.println("listCid:"+listCid);
				
	            //课程详细get请求
	            for(int k = 0; k<listCid.size();k++) {
	            	url3="http://peixun.amac.org.cn//index.php?m=Api&agency=3&act=class_catalog&act=class_catalog&cid="+listCid.get(k);
	            	String doGet2 = BankScript.doGet(url3, cookie);
	            	System.out.println("课程详细："+doGet2);
	            	//获取id&fid
	            	JSONObject object2 = JSON.parseObject(doGet2);
	            	JSONObject object3 = (JSONObject)object2.get("list");
	            	Set<Map.Entry<String, Object>> objs = object3.entrySet();
	    	    	System.out.println("共有"+objs.size()+"个单元。");
	            	
	    	    	Object ucid = listUcid.get(k);
	    			Object cid = listCid.get(k);
	    			
	    			for (Map.Entry<String, Object> item : objs) {
	    	    		
	    	    		JSONObject jsonObject4 = (JSONObject)item.getValue();
	    	    		JSONObject jsonObject5 = jsonObject4.getJSONObject("sub_art");
	    	    		
	    	    		Set<String> set = jsonObject5.keySet();
	    	    		for(String a : set) {
	    	    			JSONObject jsonObject6 = jsonObject5.getJSONObject(a);
	    	    			listId1.add(jsonObject6.get("id"));
	    	    			listFid1.add(jsonObject6.get("fid"));
	    	    	    	
	    	    			}
	    	    		
	    	    		}
	    	    	System.out.println("id:"+listId1);
	        		System.out.println("fid:"+listFid1);
	    	    	
	        		//完成视频psotform请求
	        		for(int o=0;o<listId1.size();o++) {
	        			
	        			Object artid = listId1.get(o);
	        			Object fid = listFid1.get(o);
	        			
	        			object7.put("cid",cid);
	        			object7.put("ucid",ucid);
	        			object7.put("artid", artid);
	        			object7.put("type", "1");
	        			object7.put("data", "2");
	        			object7.put("datetime", "");
	        			object7.put("studytime", "3568");
	        			String param = "["+object7.toString()+"]";
	        			
	        			map1.put("act", "log_update");
	        	        map1.put("log_list",param);
	        	        
	        	        System.out.println("map1:"+map1);
	        	        
	        	        
	        	        url4 = "http://peixun.amac.org.cn/index.php?m=Api&agency=3&log_update";
	        	        Referer = "https://peixun.amac.org.cn/index.php?a=studyDetail&m=Index&cid="+cid+"&ucid="+ucid+"&artid="+artid+"&fid="+fid;
	        	        //完成视频，太快了，需要停留一些时间
	        	        String doPostForm = BankScript.doPostForm(url4, map1, cookie, Referer);
	        	        System.out.println("完成视频doPostForm:"+doPostForm);
	        	        
	        	        int times = (int)(Math.random()*time1+10000);
	        	        System.out.println("视频随机时间="+times/1000+"s");
	        	        try {
        				    Thread.sleep(times); // 停顿1千毫秒,即一秒
        				} catch (InterruptedException ex) {
        				   
        				}
	        		}
	        		//答题详细get请求
	        		url5 = "http://peixun.amac.org.cn/index.php?m=Api&agency=3&act=progress_list&act=progress_list&cid="+cid+"&ucid="+ucid;;
	        		String requestbody = BankScript.doGet(url5, cookie);
	        		System.out.println("答题详细:"+requestbody);
	        		
	        		JSONObject jsonObject4 = JSON.parseObject(requestbody);
	        		JSONObject jsonObject5 = jsonObject4.getJSONObject("list");
	        		
	        		
	        		Set<Map.Entry<String, Object>> objs1 = jsonObject5.entrySet();
	    	    	System.out.println("共有"+objs1.size()+"个单元。");
	        		
	    	    	for (Map.Entry<String, Object> item : objs1) {
	    	    		
	    	    		JSONObject jsonObject6 = (JSONObject)item.getValue();
	    	    		listCid1.add(jsonObject6.get("cid"));
	    	        	listArtid1.add(jsonObject6.get("artid"));
	    	    		
	    	    		}
	    	    	
	        		//获取答案提交答案
	        		for(int m=0;m<listCid1.size();m++) {
	        			Object object0 = listCid1.get(m);
	        			Object object20 = listArtid1.get(m);
	        			Object object30 = listFid1.get(m);
	        			String string = object0.toString();
	        			String string2 = object20.toString();
	        			String fid1 = object30.toString();
	        			//Referer
	        			String Referer1 = "http://peixun.amac.org.cn/index.php?a=studyDetail&m=Index&type=1&cid="+cid+"&ucid="+ucid+"&fid="+fid1;
	        			//获取答案
	        			url6 = "http://peixun.amac.org.cn/index.php?m=Api&agency=3&test_show";
	        			map2.put("act", "test_show");
	        			map2.put("cid", string);
	        			map2.put("artid", string2);
	        			String doPostForm = BankScript.doPostForm(url6, map2, cookie,Referer1);
	        			System.out.println("答案："+doPostForm);
	        			
	        			JSONObject parseObject = JSON.parseObject(doPostForm);
	        			JSONArray object4 = parseObject.getJSONArray("list");
	        			
	        			Object object5 = parseObject.get("total");
	        			int parseInt = Integer.parseInt(object5.toString());//total
	        			System.out.println("共有"+parseInt+"道题。");
	        			
	        			Object object8 = parseObject.get("test_id");
	        			String string3 = object8.toString();//test_id
	        			
	        			int type;
	        			for(int x=0;x<parseInt;x++) {
	        				
	        				if(parseInt==1) {
	        					type = 3;
	        				}else {
	        					if(x==0) {
	            					type = 1;
	            				}else if(x==parseInt-1) {
	            					type=3;
	            				}else {
	            					type=2;
	            				}
	        				}
	        				String valueOf = String.valueOf(type);
	        				JSONObject object6 = (JSONObject)object4.get(x);
	        				Object object12 = object6.get("id");
	        				String q_id = object12.toString();//q_id
	        				
	        				/*Object object11 = object6.get("answer");
	        				String string5 = object11.toString();*/
	        				
	        				JSONArray ja3 = object6.getJSONArray("answer");
	        				List list1 = new ArrayList<>();
	        				for(int y=0;y<ja3.size();y++) {
	        					list1.add(ja3.get(y));
	        				}
	        				String answer="";
	        				String temp ;
	        				for(int z=0;z<list1.size();z++) {
	        					temp = (String)list1.get(z);
	        					answer=answer+temp+",";
	        					System.out.println("z="+z+";answer="+answer);
	        				}
	        				System.out.println(answer);
	        				Object object9 = object6.get("type");//q_type
	        				String qtype = object9.toString();
	        				Object object10 = object6.get("unit_id");
	        				String artid = object10.toString();//artid
	        				Object object13 = listUcid.get(k);//ucid
	        				String string4 = object13.toString();
	        				object6.get("cid");//cid
	        			
	        				url7="http://peixun.amac.org.cn/index.php?m=Api&agency=3&testlog_update";
	        				String Referer2 = "http://peixun.amac.org.cn/index.php?a=studyDetail&m=Index&type=1&cid="+(listCid.get(k)).toString()+"&ucid="+string3+"&fid="+fid1;
	        				int times1 = (int)(Math.random()*time2+1000);
	        				int cost = times1/1000;
	        				String cost1 = Integer.toString(cost);
	        				System.out.println("答案随机时间="+cost+"s");
	        				map3.put("cost",cost1);
	        				map3.put("qtype", qtype);
	        				map3.put("right", "1");
	        				map3.put("type",valueOf );
	        				map3.put("artid", artid);
	        				map3.put("total", object5.toString());
	        				map3.put("act","testlog_update");
	        				map3.put("answer", answer);
	        				map3.put("q_id", q_id);
	        				map3.put("cid", (listCid.get(k)).toString());
	        				map3.put("ucid",string4 );
	        				map3.put("test_id", string3);
	        				String doPostForm2 = BankScript.doPostForm(url6, map3, cookie, Referer2);
	        				//String doPostForm2 = BankScript.doPostForm(url6, map3, cookie, Referer2);
	        				System.out.println("提交答案doPostForm2:"+doPostForm2);
	        				
	        				try {
	        				    Thread.sleep(times1); // 停顿1千毫秒,即一秒
	        				} catch (InterruptedException ex) {
	        				   
	        				}
	        				
	        			}
	        			
	        			
	        			
	        			}
	        		
	        		 	System.out.println("cid1:"+listCid1);
	        		    System.out.println("artid1:"+listArtid1);
	        		    listCid1.clear();
	        		    listArtid1.clear();
	        		    listId1.clear();
	            		listFid1.clear();
	            		
	            		
	            		String doget5 = BankScript.doGet("http://peixun.amac.org.cn/index.php?m=Api&agency=3&userclass_list&act=userclass_list&pn=9&pg=1&col=last_op_date&order=desc&grouping_id=&grouping_id1=0&grouping_id2=0&complete=0&status=1&type=1&last_op_date=&is_start=2&no_package=1", cookie);
	            		System.out.println("学习中的课程："+doget5);
	            		String url = "https://peixun.amac.org.cn/index.php?m=Api&agency=3&progress_count&act=progress_count&cid="+cid+"&ucid="+ucid;
	            		String doGet4 = BankScript.doGet(url, cookie);
	            		System.out.println("是否申报成功："+doGet4);
	     	    		String doGet3 = BankScript.doGet("http://peixun.amac.org.cn/index.php?m=Api&agency=3&userclass_list&act=userclass_list&pn=9&pg=1&col=last_op_date&order=desc&grouping_id=&grouping_id1=0&grouping_id2=0&complete=0&status=1&type=1&last_op_date=&is_start=1&no_package=1", cookie);
	     	    		System.out.println("已完成的课程"+doGet3);
	     	    	
	            		
	            		
	            }
				
	           
			}
			
		}
		
		
		
	}
	//银行从业
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public static void BankBusiness(String username,String password) {
		
		//每页查询数量
        int pn = 9;
        //0=未完成的课程，空=全部课程
        int complete = 0;
        //课程详细url
	    String url2=null;
	    //视频详细url
	    String url3 = null;
	    //答题详细
	    String url4 = null;
	    //获取答案
	    String url5 = null;
	    //提交答案
	    String url6 = null;
	    //课程ucid
        List listUcid = new ArrayList();
        //课程cid
        List listCid = new ArrayList();
        //课程详细id
        List listId1 = new ArrayList();
        //课程详细fid
        List listFid1 = new ArrayList();
        //答题cid
        List listCid1 = new ArrayList();
        //答题artid
        List listArtid1 = new ArrayList();
	    //课程详细返回值
	    String getResult2 = null;
	    //课程详细返回值json对象
	    JSONObject jsonObject1 = null;
	    //视频map
	    Map<String,String> map1 = new HashMap<>();
	    //视频json
	    JSONObject object7=new JSONObject();
	    //获取答案map
	    Map<String,String> map2 = new HashMap<>();
	    //提交答案map
	    Map<String,String> map3 = new HashMap<>();
	    
	    //Referer
	    String Referer = null;
        //requestHeaders
	    String Connection = "keep-alive";
	    String ContentType = "application/x-www-form-urlencoded; charset=UTF-8";
	    String UserAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko Core/1.70.3702.400 SLBrowser/10.0.3833.400";
	    String AcceptLanguage = "zh-CN,zh;q=0.9";
	    String AcceptEncoding = "gzip, deflate";
	    String Accept = "text/html, application/xhtml+xml, image/jxr, */*";
	    String XRequestedWith = "XMLHttpRequest";
	    String Host = "ucollege.china-cbi.net";
	    String Origin = "http://ucollege.china-cbi.net";
	    String AcceptLanguage1 = "zh-CN,zh;q=0.9,en;q=0.8";
	    
	    
	    
	    
		//post请求json格式传参
	    /*url = "http://localhost:8082/api/core/login";
	    JSONObject json = new JSONObject();
	    json.put("key", "value");
	    String postResult = BankScript.doPost(url, json.toJSONString());
	    System.out.println(postResult);*/		
		
		//post请求form表单提交
        String url = "http://ucollege.china-cbi.net/index.php?a=login&m=User";
        Map<String,String> map = new HashMap<>();
        map.put("email", username);
        map.put("password", password);
        map.put("remember", "0");
        map.put("verify", "");
        
        List listurl1 = new ArrayList<>();
        listurl1.add("");
        listurl1.add("0");
        listurl1.add("0");
        List listurl2 = new ArrayList<>();
        listurl2.add("0");
        listurl2.add("");
        listurl2.add("0");
        
        //获取cookie
        final String cookie =getCookie(url, map);
        
        for(int u=0;u<3;u++) {
        	
        	String grouping_id = (String)listurl1.get(u);
        	String grouping_id1 = (String)listurl2.get(u);
        	//银行业务专业知识已购买的课程
            String url1 = "http://ucollege.china-cbi.net/index.php?m=Api&agency=3&userclass_list&act=userclass_list&pn="+pn+"&pg=1&col=createdate&order=desc&grouping_id="+grouping_id+"&grouping_id1="+grouping_id1+"&grouping_id2=0&complete="+complete+"&status=&type=1&createdate=&no_package=1";
            String getResult1 = BankScript.doGet(url1,cookie);
    	    System.out.println("未完成详细："+getResult1);
    	    
    	    //使用json对象取值
            JSONObject jsonObject = JSON.parseObject(getResult1);
            JSONArray ja = jsonObject.getJSONArray("list");
            int number = Integer.parseInt(jsonObject.getString("total"));
            System.out.println("共有"+number+"门课程未完成。");
            //获取ucid和cid
            for(int i=0;i<ja.size();i++) {
                JSONObject jo = ja.getJSONObject(i);
                listUcid.add(jo.getString("id"));
            	listCid.add(jo.getString("cid"));
            }
            System.out.println("listUcid:"+listUcid);
            System.out.println("listCid:"+listCid);
            
          
            
    		//课程详细get请求
    	    for(int i = 0; i<number;i++) {
    	    	url2 = "http://ucollege.china-cbi.net/index.php?m=Api&agency=3&act=class_catalog&act=class_catalog&cid="+listCid.get(i);
    	    	//System.out.println("课程详情url:"+url2);
    	    	getResult2 = BankScript.doGet(url2, cookie);
    	    	System.out.println("课程详细："+getResult2);
    	    	//获取id&fid
    	    	JSONObject jsonObject2 = JSON.parseObject(getResult2);
    	    	JSONObject jsonObject3 = (JSONObject)jsonObject2.get("list");
    	    	Set<Map.Entry<String, Object>> objs = jsonObject3.entrySet();
    	    	System.out.println("共有"+objs.size()+"个单元。");
    	    	
    	    	Object ucid = listUcid.get(i);
    			Object cid = listCid.get(i);
    	    	
    	    	for (Map.Entry<String, Object> item : objs) {
    	    		
    	    		JSONObject jsonObject4 = (JSONObject)item.getValue();
    	    		JSONObject jsonObject5 = jsonObject4.getJSONObject("sub_art");
    	    		
    	    		Set<String> set = jsonObject5.keySet();
    	    		for(String a : set) {
    	    			JSONObject jsonObject6 = jsonObject5.getJSONObject(a);
    	    			listId1.add(jsonObject6.get("id"));
    	    			listFid1.add(jsonObject6.get("fid"));
    	    	    	
    	    			}
    	    		
    	    		}
    	    	System.out.println("id:"+listId1);
        		System.out.println("fid:"+listFid1);
        		
        		//完成视频psotform请求
        		for(int k=0;k<listId1.size();k++) {
        			
        			/*Object ucid = listUcid.get(i);
        			Object cid = listCid.get(i);*/
        			Object artid = listId1.get(k);
        			Object fid = listFid1.get(k);
        			
        			object7.put("cid",cid);
        			object7.put("ucid",ucid);
        			object7.put("artid", artid);
        			object7.put("type", "1");
        			object7.put("data", "2");
        			object7.put("datetime", "");
        			object7.put("studytime", "3568");
        			String param = "["+object7.toString()+"]";
        			
        	        map1.put("act", "log_update");
        	        map1.put("log_list",param);
        	        
        	        System.out.println("map1:"+map1);
        	        
        	        url3 = "http://ucollege.china-cbi.net/index.php?m=Api&agency=3&log_update";
        	        
        	        Referer = "http://ucollege.china-cbi.net/index.php?a=studyDetail&m=Index&cid="+cid+"&ucid="+ucid+"&artid="+artid+"&fid="+fid;
        	        String doPostForm = BankScript.doPostForm(url3, map1, cookie, Referer, Connection, ContentType, UserAgent, AcceptLanguage, AcceptEncoding, Accept, XRequestedWith, Host,Origin);
        	        //System.out.println("doPostForm:"+doPostForm);
        		}
    	    	
        		//答题详细get请求
        		url4 = "http://ucollege.china-cbi.net/index.php?m=Api&agency=3&act=progress_list&act=progress_list&cid="+cid+"&ucid="+ucid;
        		String requestbody = BankScript.doGet(url4, cookie);
        		System.out.println("答题详细:"+requestbody);
        		
        		JSONObject jsonObject4 = JSON.parseObject(requestbody);
        		JSONObject jsonObject5 = jsonObject4.getJSONObject("list");
        		
        		
        		Set<Map.Entry<String, Object>> objs1 = jsonObject5.entrySet();
    	    	System.out.println("共有"+objs1.size()+"个单元。");
        		
    	    	for (Map.Entry<String, Object> item : objs1) {
    	    		
    	    		JSONObject jsonObject6 = (JSONObject)item.getValue();
    	    		listCid1.add(jsonObject6.get("cid"));
    	        	listArtid1.add(jsonObject6.get("artid"));
    	    		
    	    		}
    	    	
        		//获取答案提交答案
        		for(int k=0;k<listCid1.size();k++) {
        			Object object = listCid1.get(k);
        			Object object2 = listArtid1.get(k);
        			Object object3 = listFid1.get(k);
        			String string = object.toString();
        			String string2 = object2.toString();
        			String fid1 = object3.toString();
        			//Referer
        			String Referer1 = "http://ucollege.china-cbi.net/index.php?a=studyDetail&m=Index&type=1&cid="+cid+"&ucid="+ucid+"&fid="+fid1;
        			//获取答案
        			url5 = "http://ucollege.china-cbi.net/index.php?m=Api&agency=3&test_show";
        			map2.put("act", "test_show");
        			map2.put("cid", string);
        			map2.put("artid", string2);
        			String doPostForm = BankScript.doPostForm(url5, map2, cookie, Referer1);
        			System.out.println("答案："+doPostForm);
        			
        			JSONObject parseObject = JSON.parseObject(doPostForm);
        			JSONArray object4 = parseObject.getJSONArray("list");
        			
        			Object object5 = parseObject.get("total");
        			int parseInt = Integer.parseInt(object5.toString());//total
        			System.out.println("共有"+parseInt+"道题。");
        			
        			Object object8 = parseObject.get("test_id");
        			String string3 = object8.toString();//test_id
        			int type;
        			for(int x=0;x<parseInt;x++) {
        				
        				if(parseInt==1) {
        					type = 3;
        				}else {
        					if(x==0) {
            					type = 1;
            				}else if(x==parseInt-1) {
            					type=3;
            				}else {
            					type=2;
            				}
        				}
        				
        				String valueOf = String.valueOf(type);
        				JSONObject object6 = (JSONObject)object4.get(x);
        				Object object12 = object6.get("id");
        				String q_id = object12.toString();//q_id
        				
        				/*Object object11 = object6.get("answer");
        				String string5 = object11.toString();*/
        				
        				JSONArray ja3 = object6.getJSONArray("answer");
        				List list = new ArrayList<>();
        				for(int y=0;y<ja3.size();y++) {
        					list.add(ja3.get(y));
        				}
        				String answer="";
        				String temp ;
        				for(int z=0;z<list.size();z++) {
        					temp = (String)list.get(z);
        					answer=answer+temp+",";
        				}
        				System.out.println(answer);
        				Object object9 = object6.get("type");//q_type
        				String qtype = object9.toString();
        				Object object10 = object6.get("unit_id");
        				String artid = object10.toString();//artid
        				Object object13 = listUcid.get(i);//ucid
        				String string4 = object13.toString();
        				object6.get("cid");//cid
        			
        				url6="http://ucollege.china-cbi.net/index.php?m=Api&agency=3&testlog_update";
        				String Referer2 = "http://ucollege.china-cbi.net/index.php?a=studyDetail&m=Index&type=1&cid="+(listCid.get(i)).toString()+"&ucid="+string3+"&fid="+fid1;
        				map3.put("cost", "30");
        				map3.put("qtype", qtype);
        				map3.put("right", "1");
        				map3.put("type",valueOf );
        				map3.put("artid", artid);
        				map3.put("total", object5.toString());
        				map3.put("act","testlog_update");
        				map3.put("answer", answer);
        				map3.put("q_id", q_id);
        				map3.put("cid", (listCid.get(i)).toString());
        				map3.put("ucid",string4 );
        				map3.put("test_id", string3);
        				String doPostForm2 = BankScript.doPostForm(url6, map3, cookie, Referer2, Connection, ContentType, UserAgent, AcceptLanguage, AcceptEncoding, AcceptLanguage1, XRequestedWith, Host,Origin);
        				//String doPostForm2 = BankScript.doPostForm(url6, map3, cookie, Referer2);
        				System.out.println("doPostForm2:"+doPostForm2);
        				
        				
        			}
        			
        			
        			
        			}
        		
        		 	System.out.println("cid1:"+listCid1);
        		    System.out.println("artid1:"+listArtid1);
        		    listCid1.clear();
        		    listArtid1.clear();
        		    listId1.clear();
            		listFid1.clear();
    	        }
		
        }
		
		
	}
	
	
	    
	/**
	 * 登录后获取cookie
	 */
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public static String getCookie(String httpUrl, Map param) {
		 HttpURLConnection connection = null;
	       InputStream is = null;
	       OutputStream os = null;
	       BufferedReader br = null;
	       String result = null;
	       
	       String sessionId = "";
           String cookieVal = "";
           String key = null;
	       
	       try {
	           URL url = new URL(httpUrl);
	           // 通过远程url连接对象打开连接
	           connection = (HttpURLConnection) url.openConnection();
	           // 设置连接请求方式
	           connection.setRequestMethod("POST");
	           // 设置连接主机服务器超时时间：15000毫秒
	           connection.setConnectTimeout(15000);
	           // 设置读取主机服务器返回数据超时时间：60000毫秒
	           connection.setReadTimeout(60000);

	           // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
	           connection.setDoOutput(true);
	           // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
	           connection.setDoInput(true);
	           // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
	           connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	           // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
	           //connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
	           // 通过连接对象获取一个输出流
	           os = connection.getOutputStream();
	           // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的(form表单形式的参数实质也是key,value值的拼接，类似于get请求参数的拼接)
	           os.write(createLinkString(param).getBytes());
	           // 通过连接对象获取一个输入流，向远程读取
	           if (connection.getResponseCode() == 200) {

	               is = connection.getInputStream();
	               // 对输入流对象进行包装:charset根据工作项目组的要求来设置
	               br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

	               StringBuffer sbf = new StringBuffer();
	               String temp = null;
	               // 循环遍历一行一行读取数据
	               while ((temp = br.readLine()) != null) {
	                   sbf.append(temp);
	                   sbf.append("\r\n");
	               }
	               result = sbf.toString();
	               
	               //取cookie
	               for(int i = 1; (key = connection.getHeaderFieldKey(i)) != null; i++){
	                   if(key.equalsIgnoreCase("set-cookie")){
	                       cookieVal = connection.getHeaderField(i);
//	                       cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
	                       sessionId = sessionId + cookieVal + ";";
	                   }
	               }
	               System.out.println("cookie:"+sessionId);
	           }
	       } catch (MalformedURLException e) {
	           e.printStackTrace();
	       } catch (IOException e) {
	           e.printStackTrace();
	       } finally {
	           // 关闭资源
	           if (null != br) {
	               try {
	                   br.close();
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	           if (null != os) {
	               try {
	                   os.close();
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	           if (null != is) {
	               try {
	                   is.close();
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	           // 断开与远程地址url的连接
	           connection.disconnect();
	       }
	       return sessionId;
	}
	
	 /**
     * 向指定URL发送GET方法的请求
     *
     * @param httpurl
     * 请求参数用?拼接在url后边，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return result 所代表远程资源的响应结果
     */
    public static String doGet(String httpurl,String cookie) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            //添加cookie
            //connection.setRequestProperty("cookie",cookie );
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            
            //设置cookie
            connection.setRequestProperty("Cookie", cookie);
            
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }

        return result;
    }

	
    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param httpUrl
     *            发送请求的 URL
     * @param param
     *            请求参数应该是{"key":"value"}
     */
    public static String doPost(String httpUrl, String param) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/json");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            //connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        return result;
    }

	
	
   /**
    *
    * @param httpUrl  请求的url
    * @param param  form表单的参数（key,value形式）
    * @return
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static String doPostForm(String httpUrl, Map param,String cookie,String Referer,
			String Connection,String  ContentType,String UserAgent,String AcceptLanguage,
			String AcceptEncoding,String Accept,String  XRequestedWith,String Host,String Origin) {

       HttpURLConnection connection = null;
       InputStream is = null;
       OutputStream os = null;
       BufferedReader br = null;
       String result = null;
       try {
           URL url = new URL(httpUrl);
           // 通过远程url连接对象打开连接
           connection = (HttpURLConnection) url.openConnection();
           // 设置连接请求方式
           connection.setRequestMethod("POST");
           // 设置连接主机服务器超时时间：15000毫秒
           connection.setConnectTimeout(15000);
           // 设置读取主机服务器返回数据超时时间：60000毫秒
           connection.setReadTimeout(60000);

           // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
           connection.setDoOutput(true);
           // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
           connection.setDoInput(true);
           // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
           connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
           // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
           //connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
           
           //设置cookie
           connection.setRequestProperty("Cookie", cookie);
           //设置Referer
           connection.setRequestProperty("Referer", Referer);
           connection.setRequestProperty("Connection",Connection);
           connection.setRequestProperty("Content-Type",ContentType);
           connection.setRequestProperty("User-Agent",UserAgent);
           connection.setRequestProperty("Accept-Language",AcceptLanguage);
           connection.setRequestProperty("Accept-Encoding",AcceptEncoding);
           connection.setRequestProperty("Accept",Accept);
           connection.setRequestProperty("X-Requested-With",XRequestedWith);
           connection.setRequestProperty("Host",Host);
           connection.setRequestProperty("Origin",Origin);
           //connection.setRequestProperty("Content-Length",Content-Length);
           
           
           
           // 通过连接对象获取一个输出流
           os = connection.getOutputStream();
           // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的(form表单形式的参数实质也是key,value值的拼接，类似于get请求参数的拼接)
           os.write(createLinkString(param).getBytes());
           // 通过连接对象获取一个输入流，向远程读取
           if (connection.getResponseCode() == 200) {

               is = connection.getInputStream();
               // 对输入流对象进行包装:charset根据工作项目组的要求来设置
               br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

               StringBuffer sbf = new StringBuffer();
               String temp = null;
               // 循环遍历一行一行读取数据
               while ((temp = br.readLine()) != null) {
                   sbf.append(temp);
                   sbf.append("\r\n");
               }
               result = sbf.toString();
               
              /* //获取Set-Cookie
               //System.out.println("Cookie:"+connection.getHeaderField("Set-Cookie"));
               String sessionId = "";
               String cookieVal = "";
               String key = null;
               //取cookie
               for(int i = 1; (key = connection.getHeaderFieldKey(i)) != null; i++){
                   if(key.equalsIgnoreCase("set-cookie")){
                       cookieVal = connection.getHeaderField(i);
//                       cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
                       sessionId = sessionId + cookieVal + ";";
                   }
               }
               System.out.println("cookie:"+sessionId);*/
           }
       } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           // 关闭资源
           if (null != br) {
               try {
                   br.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (null != os) {
               try {
                   os.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (null != is) {
               try {
                   is.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           // 断开与远程地址url的连接
           connection.disconnect();
       }
       return result;
   }
	
    
    /**
    *
    * @param httpUrl  请求的url
    * @param param  form表单的参数（key,value形式）
    * @return
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static String doPostForm(String httpUrl, Map param,String cookie,String Referer) {

       HttpURLConnection connection = null;
       InputStream is = null;
       OutputStream os = null;
       BufferedReader br = null;
       String result = null;
       try {
           URL url = new URL(httpUrl);
           // 通过远程url连接对象打开连接
           connection = (HttpURLConnection) url.openConnection();
           // 设置连接请求方式
           connection.setRequestMethod("POST");
           // 设置连接主机服务器超时时间：15000毫秒
           connection.setConnectTimeout(15000);
           // 设置读取主机服务器返回数据超时时间：60000毫秒
           connection.setReadTimeout(60000);

           // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
           connection.setDoOutput(true);
           // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
           connection.setDoInput(true);
           // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
           connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
           // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
           //connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
           
           //设置cookie
           connection.setRequestProperty("Cookie", cookie);
           //设置Referer
           connection.setRequestProperty("Referer", Referer);
           
           
           // 通过连接对象获取一个输出流
           os = connection.getOutputStream();
           // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的(form表单形式的参数实质也是key,value值的拼接，类似于get请求参数的拼接)
           os.write(createLinkString(param).getBytes());
           // 通过连接对象获取一个输入流，向远程读取
           if (connection.getResponseCode() == 200) {

               is = connection.getInputStream();
               // 对输入流对象进行包装:charset根据工作项目组的要求来设置
               br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

               StringBuffer sbf = new StringBuffer();
               String temp = null;
               // 循环遍历一行一行读取数据
               while ((temp = br.readLine()) != null) {
                   sbf.append(temp);
                   sbf.append("\r\n");
               }
               result = sbf.toString();
               
              /* //获取Set-Cookie
               //System.out.println("Cookie:"+connection.getHeaderField("Set-Cookie"));
               String sessionId = "";
               String cookieVal = "";
               String key = null;
               //取cookie
               for(int i = 1; (key = connection.getHeaderFieldKey(i)) != null; i++){
                   if(key.equalsIgnoreCase("set-cookie")){
                       cookieVal = connection.getHeaderField(i);
//                       cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
                       sessionId = sessionId + cookieVal + ";";
                   }
               }
               System.out.println("cookie:"+sessionId);*/
           }
       } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           // 关闭资源
           if (null != br) {
               try {
                   br.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (null != os) {
               try {
                   os.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (null != is) {
               try {
                   is.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           // 断开与远程地址url的连接
           connection.disconnect();
       }
       return result;
   }
    
   /**
    * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
    * @param params 需要排序并参与字符拼接的参数组
    * @return 拼接后字符串
    */
    public static String createLinkString(Map<String, String> params) {

       List<String> keys = new ArrayList<String>(params.keySet());
       Collections.sort(keys);

       StringBuilder prestr = new StringBuilder();
       for (int i = 0; i < keys.size(); i++) {
           String key = keys.get(i);
           String value = params.get(key);
           if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
               prestr.append(key).append("=").append(value);
           } else {
               prestr.append(key).append("=").append(value).append("&");
           }
       }
       System.out.println("request bady："+prestr.toString());
       return prestr.toString();
   }


	
}
