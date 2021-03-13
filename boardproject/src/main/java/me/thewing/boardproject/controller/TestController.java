package me.thewing.boardproject.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.thewing.boardproject.domain.TestDto;
import me.thewing.boardproject.service.TestService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/test")
public class TestController {
	private final TestService testService;

	private Double x;
	// private Double x = 126.716316;
	private Double y;
	// private Double y = 37.599191;

	private String ApiUrl;

	private static String APIKey = "KakaoAK 109569371036c4d6f2f7a904ae262661";

	HashMap<String, Object> map = new HashMap<>();

	@PostMapping("test")
	public ResponseEntity<?> checkApi(TestDto testDto) {
		System.out.println(testDto.toString());
		x = testDto.getX();
		y = testDto.getY();
		String addr = "";
		ApiUrl = "https://dapi.kakao.com/v2/local/geo/coord2address.json?input_coord=WGS84&y=" + y + "&x=" + x;
		try {
			addr = getRegionAddress(getJSONData(ApiUrl));
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return new ResponseEntity<>(addr, HttpStatus.OK);
	}

	private static String getJSONData(String apiUrl) throws Exception {
		StringBuilder jsonString = new StringBuilder(new String());
		String buf;
		URL url = new URL(apiUrl);
		HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("X-Requested-With", "curl");
		conn.setRequestProperty("Authorization", APIKey);

		BufferedReader br = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		while ((buf = br.readLine()) != null) {
			jsonString.append(buf);
		}
		return jsonString.toString();
	}

	private static String getRegionAddress(String jsonString) throws Exception {
		String value = "";
		JSONObject jObj = (JSONObject)JSONValue.parse(jsonString);
		JSONObject meta = (JSONObject)jObj.get("meta");
		long size = (long)meta.get("total_count");
		if (size > 0) {
			JSONArray jArray = (JSONArray)jObj.get("documents");
			JSONObject subJobj = (JSONObject)jArray.get(0);
			JSONObject roadAddress = (JSONObject)subJobj.get("road_address");
			if (roadAddress == null) {
				JSONObject subsubJobj = (JSONObject)subJobj.get("address");
				value = (String)subsubJobj.get("address_name");
			} else {
				value = (String)roadAddress.get("address_name");
			}
			if (value.equals("")) {
				subJobj = (JSONObject)jArray.get(1);
				subJobj = (JSONObject)subJobj.get("address");
				value = (String)subJobj.get("address_name");
			}
		}
		return value;
	}

}
