package 콜렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.test.EmpVO;

/*
 * List, Set, Map
 * List :			, index		 -> 순차적 목록
 * Set : 			, index		-> 중복값허용 X
 * Map : <key, value>, key		-> 검색
 */

public class CollectionTest {
	public static void main(String[] args) {
		// 중복값 제거
		List<Integer> list = Arrays.asList(3, 3, 10, 11, 14, 3);
		System.out.println(list);
		
		// list -> set
		HashSet set = new HashSet<>(list);
		System.out.println(set);
		
		// List<EmpVO>
		List<EmpVO> empList = new ArrayList<>();
		empList.add(new EmpVO("kim", "ccc", 20000));
		empList.add(new EmpVO("park", "bbb", 10000));
		empList.add(new EmpVO("choi", "aaa", 14000));
		empList.add(new EmpVO("kim", "ccc", 20000));
		
		HashSet<EmpVO> empSet = new HashSet<>(empList);
		System.out.println(empSet.size());
		for(EmpVO vo : empSet) {
			System.out.println(vo.getFirstName());
			
		}
		
		// 필터링 : 급여가 15000이상인 사원만 검색
		List<EmpVO> filterList = new ArrayList<>();
		for(EmpVO vo : empList) {
			if(vo.getSalary() >= 15000) {
				filterList.add(vo);
			}
		}
		System.out.println(filterList.size());
		
		// => stream
		filterList = empSet.stream().filter(vo -> vo.getLastName().contains("b"))	// startwith, endwith
							.collect(Collectors.toList());
		System.out.println(filterList.get(0).getLastName());
		
		
		
	}
	
}
