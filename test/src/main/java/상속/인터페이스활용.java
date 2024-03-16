package 상속;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.test.EmpVO;

public class 인터페이스활용 {
	public static void main(String[] args) {
		List<EmpVO> list = new ArrayList<>();
		list.add(new EmpVO("kim", "ccc", 20000));
		list.add(new EmpVO("park", "bbb", 10000));
		list.add(new EmpVO("choi", "aaa", 14000));
		
		// sort
		Collections.sort(list, (EmpVO o1, EmpVO o2) -> 
								o2.getFirstName().compareTo(o1.getFirstName())
		);
		System.out.println("이름순");
		for(EmpVO vo : list) {
			System.out.println(vo.getFirstName() + ":" + vo.getLastName());
		}
		
		// 급여비교
		Collections.sort(list, (EmpVO o1, EmpVO o2) -> 
								o1.getSalary() - o2.getSalary()
		);
		System.out.println("급여순");
		for(EmpVO vo : list) {
			System.out.println(vo.getFirstName() + ":" + vo.getSalary());
		}
	}
}


