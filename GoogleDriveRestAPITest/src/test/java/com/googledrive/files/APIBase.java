package com.googledrive.files;
/**/
import static io.restassured.RestAssured.*;

import io.restassured.specification.RequestSpecification;

public class APIBase {
	
	private static final String accessToken="Bearer "+"ya29.Il-vB44TlO9P3LvJ7VTmGalhhXQv85cHVfNqSccknglARo6k6bvvj2K8LSD4hMLl-Tvpla8jyiv1ejsfEbM6rnRP66DKkoXEgjPgT4hyPUz4s49qxCTVdCtuKqaMEOhvbQ";
	
	protected RequestSpecification request;
	
	public APIBase() {
		request=given()
		.baseUri("https://www.googleapis.com")
		.header("Authorization", accessToken);
		
	}

}
