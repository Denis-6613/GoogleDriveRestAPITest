package com.googledrive.files;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FilesTestCases extends APIBase {

//	private static final String accessToken="Bearer ya29.Il-vB-vSqt-NREJC8DXAvinT3G_tVNbqJGTotuTrbB1VFAJXPWLEZQWCqgxrPYGFFmE-dAcfe2CIxypCQ2WCIjlJAp-A-7UbMjSrdTkknaxC7A84Jr5B6uyFDoy_S8kTaQ";

	@Test
	public void getAllFiles() {
		// construct request

		/*
		 * String responseAsString= given() .baseUri("https://www.googleapis.com")
		 * .header("Authorization",
		 * "Bearer ya29.Il-vB-vSqt-NREJC8DXAvinT3G_tVNbqJGTotuTrbB1VFAJXPWLEZQWCqgxrPYGFFmE-dAcfe2CIxypCQ2WCIjlJAp-A-7UbMjSrdTkknaxC7A84Jr5B6uyFDoy_S8kTaQ"
		 * ) .get() .body().asString();
		 */

		String responseAsString = request.get("/drive/v3/files").body().asString();

		System.err.println(responseAsString);

	}

//	@Test
	public void getAllFiles_verify_status_code() {
		// construct request
//		given()
//			.baseUri("https://www.googleapis.com")
//			.header("Authorization", accessToken)
//			
//		.get("/drive/v3/files")
//		
//		.then().statusCode(200);

		request

				.get("/drive/v3/files")

				.then().statusCode(200);

	}

//	@Test
	public void getAllFiles_verify_json_data() {

		request

				.get("/drive/v3/files")

				.then().body("files[0].name", equalTo("My_File--33"));

	}

//	@Test
	public void getAllFiles_verify_has_json_data() {

		request

				.get("/drive/v3/files")

				.then().body("files.name", hasItems("My_File--33", "new name"));

	}

	public void getSingleFile(String fileId) {
		String response=request.get("/drive/v3/files/"+fileId).body().asString();
		System.err.println("File id retrieved: \n "+response);
	}
	
	@Test
	public void getAllFiles_get_files_and_then_get_first_file() {

		String fileId = request.get("/drive/v3/files").path("files[0].id");
		String name = request.get("/drive/v3/files").path("files[0].name");
		System.out.println("Retrieving file = "+name+", id = "+fileId);
		getSingleFile(fileId);
	}

//	@Test
	public void deleteAFile() {
		String fileId = "";
		// construct request
//		int responseStatusCode=given()
//			.baseUri("https://www.googleapis.com")
//			.header("Authorization", accessToken)
//			
//		.delete("/drive/v3/files/"+fileId)
//		
//		.statusCode();
//		
//		System.err.println(responseStatusCode);

	}

}
