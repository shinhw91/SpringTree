package 콜렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 맵테스트 {
	public static void main(String[] args) {		
		HashMap<String, Object> map = new HashMap<>();
		map.put("100", "park");
		map.put("101", "kim");
		map.put("102", "choi");
		
		String name = (String) map.get("101");
		
		// 반복문
		for(String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
		
		List<HashMap<String, Object>> empList = new ArrayList<HashMap<String, Object>>();
		map = new HashMap<>();
		map.put("firstName", "park");
		map.put("lastName", "aaa");
		map.put("salary", 20000);
		empList.add(map);
		
		map = new HashMap<>();
		map.put("firstName", "choi");
		map.put("lastName", "bbb");
		map.put("salary", 10000);
		empList.add(map);
		
		// firstName만 출력
		for(HashMap<String, Object> empAmp : empList) {
			System.out.println(empAmp.get("firstName"));
		}
		
		// filter : 급여가 15000이상인 사람
		System.out.println("급여가 15000이상");
		List<HashMap<String, Object>> filterList = new ArrayList<>();
		for(HashMap<String, Object> empAmp : empList) {
			if((int) empAmp.get("salary") > 15000) {
//				System.out.println(empAmp.get("firstName"));
				filterList.add(empAmp);
			}
		}
		System.out.println(filterList.get(0).get("firstName"));
		
		// stream
		filterList = empList.stream().filter(vo -> (int)vo.get("salary") >= 15000).peek(System.out::println).collect(Collectors.toList());
	}
}
