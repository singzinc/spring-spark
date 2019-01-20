package com.singplayground.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	@RequestMapping(value = "example", method = RequestMethod.GET)
	public @ResponseBody HashMap example2Controller() throws Exception {
		HashMap hm = new HashMap();
		hm.put("name", "john");
		return hm;
	}
	
	
	@RequestMapping(value = "spark-word-count", method = RequestMethod.GET)
	public @ResponseBody HashMap sparkWordCountController() throws Exception {
		
		
		

		System.out.println("this is my first app");
		// Create a SparkContext to initialize
		// Create a SparkContext to initialize
		SparkConf conf = new SparkConf().setMaster("local").setAppName("Word Count");

		// Create a Java version of the Spark Context
		JavaSparkContext sc = new JavaSparkContext(conf);

		// Load the text into a Spark RDD, which is a distributed representation
		// of each line of text
		JavaRDD<String> textFile = sc.textFile("src/main/resources/data/text.txt");
		
		
		wordCountMethod1(textFile);
	    
		System.out.println("end of the application ");
		
		
		HashMap hm = new HashMap();
		hm.put("name", "john");
		return hm;
	}

	
	
	

	public static void wordCountMethod1(JavaRDD<String> textFile){
		

		JavaRDD<String> obj1 = textFile.flatMap(l -> {
			ArrayList<String> al = new ArrayList();
			String[] str = l.split(" ");
			for (int i = 0; i < str.length; i++) {
				al.add(str[i]);
			}
			return al.iterator();
		});
		System.out.println(obj1.count());

		obj1.foreach(p -> System.out.println(p));
		
		
		// save as function 
		//obj1.saveAsTextFile("src/main/resources/counts.txt");
	
		
	}
	
	
}
