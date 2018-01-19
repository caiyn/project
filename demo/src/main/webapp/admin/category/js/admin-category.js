var category = (function(){
	//滚动条加载标志
	var needloading = true;
	var loading = false;
	var start=0;
	var total;//查询出来的总记录数
	var initCount = 5;
	var PerPagemaxCount = 10;
	/**
	 * 一页最多可显示10条数据，默认先显示(initCount)5条，其余的由滚动条加载。
	 */
	//初始化加载分类列表数据，默认显示5条数据
	function initLoadCategoryList(){
		$.ajax({
			url : "admin/categoryListAC!initLoadCategoryList.action",
			type : "post",
			dataType : "json",
			data : {
				start : 0,
				limit : initCount
			},
			success : function(rs){
				adminCategoryListView(rs);
			},error:function(){
				alert(1)
			}
		})
	}
	/**
	 * 点击分页时，发请求触发，加载新数据
	 * @param {Object} start
	 */
	function initLoadCategoryListPagination(start){
		loading = false;
		$.ajax({
			url : "admin/categoryListAC!initLoadCategoryList.action",
			type : "post",
			dataType : "json",
			data : {
				start : start,
				limit : initCount
			},
			success : function(rs){
				adminCategoryListViewPagination(rs);
				needloading = rs.checkScroll;
			},error:function(){
				alert(1)
			}
		})
	}
	//列表数据的拼接展现
	function adminCategoryListView(rs){
		var categoryList = rs.categoryList;
		var $tr = "";
		if(categoryList!=null){
//			alert(categoryList.length)
			for(var i=categoryList.length-1;i>=0;i--){
				$tr+="<tr><td>"+(categoryList[i].id)+"</td>"
				   +"<td><img height='40px' src='admin/category/img/"+ categoryList[i].categoryImg +".jpg'/></td>"
				   +"<td><span>"+categoryList[i].categoryName+"</span></td>"
				   +"<td><a href='#'><span class='glyphicon glyphicon-th-list'></span></a></td>"
				   +"<td><a href='#'><span class='glyphicon glyphicon-shopping-cart'></span></a></td>"
				   +"<td><a href='#'><span class='glyphicon glyphicon-edit'></span></a></td>"
				   +"<td><a href='#'><span class='glyphicon glyphicon-trash'></span></a></td>"
				   +"</tr>";
			}
			//加载分页；
			loadPagination(rs);
		}else{
			//无数据的显示$tr+="";
		}
		$("#adminCategoryList").prepend($tr);
	}
	//列表数据的拼接展现
	function adminCategoryListViewPagination(rs){
		var categoryList = rs.categoryList;
		var $tr = "";
		if(categoryList!=null){
//			alert(categoryList.length)
			for(var i=categoryList.length-1;i>=0;i--){
				$tr+="<tr><td>"+(categoryList[i].id)+"</td>"
				   +"<td><img height='40px' src='admin/category/img/"+ categoryList[i].categoryImg +".jpg'/></td>"
				   +"<td><span>"+categoryList[i].categoryName+"</span></td>"
				   +"<td><a href='#'><span class='glyphicon glyphicon-th-list'></span></a></td>"
				   +"<td><a href='#'><span class='glyphicon glyphicon-shopping-cart'></span></a></td>"
				   +"<td><a href='#'><span class='glyphicon glyphicon-edit'></span></a></td>"
				   +"<td><a href='#'><span class='glyphicon glyphicon-trash'></span></a></td>"
				   +"</tr>";
			}
			//加载分页；
			loadPagination(rs);
		}else{
			//无数据的显示$tr+="";
		}
		$("#adminCategoryList").html($tr);
	}
	//滚动条动态加载请求数据，每次加载5条
	function loadCategoryListByScroll(){
		if(needloading && !loading){
//			var getCount = $("#adminCategoryList").children("tr").length;
			var getCount = $("#adminCategoryList").children("tr:first-child").find("td:first-child").text();
//			alert(getCount)
			var getNum = $("#adminCategoryList").children("tr").length;
			//2018.1.18有问题，需要改动。判断问题。
			//2018.1.19已经改完了。滚动条+分页共存已经完成。
			if(getNum>=initCount&&getNum<PerPagemaxCount&&getCount<total){
				loading = true;
				$.ajax({
					url : "admin/categoryListAC!initLoadCategoryList.action",
					type : "post",
					dataType : "json",
					data : {
						start : getCount,
						limit : 5
					},
					success : function(rs){
						adminCategoryListView(rs);
						needloading = rs.checkScroll;
						setTimeout(function(){loading = false;},300);	
					},error:function(){
						alert(1)
					}
				})
			}
		}
	}
	//加载分页的页面展现
	function loadPagination(rs){
		total = rs.totalCount;
//		alert(Math.ceil(total/5));
		var $pageSize = Math.ceil(total/PerPagemaxCount);
		var $liContent = '';
		for(var i=1;i<=$pageSize;i++){
			$liContent+='<li><a href="javascript:void(0);" onclick="category.initLoadCategoryListPagination('+(i-1)*PerPagemaxCount+');">'+i+'</a></li>';
		}
		var $liPrev = '<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'
		var $liAfter = '<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
		var $li = $liPrev + $liContent + $liAfter;
		$(".pageDiv nav ul.pagination").html($li);
	}
	return {
		initLoadCategoryList : initLoadCategoryList,
		loadCategoryListByScroll : loadCategoryListByScroll,
		initLoadCategoryListPagination : initLoadCategoryListPagination
	}
})();
$(function(){
	category.initLoadCategoryList();
});