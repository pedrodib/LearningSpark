package com.schoolofnet.LearningSpark;

import spark.Spark;

public class Config {
	public static void setConfig() {
		Spark.port(8080);
		Spark.ipAddress("127.0.0.1");

	}
}
