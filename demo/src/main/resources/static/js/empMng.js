// var empService = {infoReq, saveReq, listReq}
var empService = (function(){

function dateFormat(dt) {
	// 날짜포맷
	const date = new Date(dt);
	const year = date.getFullYear();
	const month = ('0' + (date.getMonth() + 1)).slice(-2);
	const day = ('0' + date.getDate()).slice(-2);
	const dateStr = `${year}-${month}-${day}`;
	return dateStr;
}

// 등록 요청
//등록 요청 (3가지 방식)
//1.첫번째방법: queryString 직접 만들기
/* function saveReq() {
	const lastName = frm.lastName.value;
	const email = frm.email.value;
	const hireDate = frm.hireDate.value;
	const jobId = frm.jobId.value;
	
	let param = `lastName=${lastName}&email=${email}&hireDate=${hireDate}&jobId=${jobId}`
	fetch("/ajax/emp", { //데이터 있으면 fetch("url", option) -- 데이터는 body에 실어서
		method : "post",
		headers: {
		      "Content-Type": "application/x-www-form-urlencoded",
		    },
		body : param
		
	})
	.then(res => res.json())
	.then(res => saveRes(res))
} */

//2.두번째방법: formData 첨부파일도 가능
/* function saveReq() {
	let param = new FormData(document.frm);
	fetch("/ajax/emp", {
		method : "post",
		body : param	
	})
	.then(res => res.json())
	.then(res => saveRes(res))
} */

//3.세번째방법: json
function saveReq() {
	const lastName = frm.lastName.value;
	const email = frm.email.value;
	const hireDate = frm.hireDate.value;
	const jobId = frm.jobId.value;
	
	let param = {lastName, email, jobId, hireDate }
	/* fetch("/ajax/emp", { 
		method : "post",
		headers: {
			"Content-Type": "application/json",
		    },
		body : JSON.stringify(param)
		
	})
	.then(res => res.json())
	.then(res => saveRes(res)) */
	axios.post('/ajax/emp', param)
	.then(res => saveRes(res.data))
}
	
// 상세조회 요청
function infoReq(employeeId) {
	fetch("/ajax/emp/"+employeeId)
	.then(res => res.json())
	.then(res => infoRes(res))
}

// 상세조회 응답
function infoRes(res) {
	// input tag에 표시
	frm.email.value = res.email
	frm.lastName.value = res.lastName
	frm.hireDate.value = res.hireDate
	frm.jobId.value = res.jobId
}

// 등록 응답
function saveRes(res) {
	listReq(1);
}

// 리스트 요청
async function listReq(p) {
	const param = "?page=" + p
/*	fetch("/ajax/empList" + param)
	.then(res => res.json())
	.then(res => listRes(res))	*/
	
	// 비동기식
//	axios.get("/ajax/empList" + param)
//	.then(res => listRes(res.data))
	
	// 동기식
	const res = await axios.get("/ajax/empList" + param);
	listRes(res.data)
}
	
// 리스트 응답
	function listRes(res) {
	let i = 0;
	// 목록출력
	empList.innerHTML = '';
	
		for(obj of res.data) {
		 		empList.innerHTML += makeTr(++i, obj);
		}
	// 페이징처리
	nav.innerHTML = makePage(res.paging);
	
	}
	
	function makePage(paging) {
		let tag = `<nav aria-label="...">
		
		  <ul class="pagination">`
		// 이전버튼
		if(paging.startPage > 1) {
			tag += `<li class="page-item">
				 <a class="page-link" href="javascript:gopage(${paging.startPage-1})">Previous</a></li>`
		}
		// 페이지번호
		for(i=paging.startPage; i<=paging.endPage; i++) {
			tag += `<li class="page-item">
				<a class="page-link" href="javascript:gopage(${i})">${i}</a></li>`
		}
		// 다음버튼
		if(paging.endPage <= paging.lastPage)
			tag += `<li class="page-item">
				<a class="page-link" href="javascript:gopage(${paging.endPage+1})">Next</a></li>`
			
			tag += `</ul></nav>`	
				
		return tag;
	}
	
	function makeTr(i, obj) {
		let bonusBtn = '<button>신청</button>'
			if(obj.salary > 10000) {
				bonusBtn = '<button>미신청</button>'
			}
			let newTag = `<tr>
		 		<td>${i}</td>
		 		<td onclick="infoReq(${obj.employeeId})">${obj.employeeId}</td>
		 		<td>${obj.firstName} ${obj.lastName}</td>
		 		<td>${dateFormat(obj.hireDate)}</td>
		 		<td>${obj.salary}</td>
		 		<td>${bonusBtn}</td>
		 		<td><button type="button" onclick="move(${obj.employeeId})">조회</button></td>
		 		</tr>`
		 return newTag;
	}
	
return {infoReq, saveReq, listReq}
})();