var category = (function(){
	//滚动条加载标志
	var needloading = true;
	var loading = false;
	//初始化加载分类列表数据，默认显示5条数据
	function initLoadCategoryList(){
		$.ajax({
			url : "admin/categoryListAC!initLoadCategoryList.action",
			type : "post",
			dataType : "json",
			data : {
				start : 0,
				limit : 5
			},
			success : function(rs){
				adminCategoryListView(rs);
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
			alert(categoryList.length)
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
		}else{
			//无数据的显示$tr+="";
		}
//		$("#adminCategoryList").html($tr);
		$("#adminCategoryList").prepend($tr);
	}
	//滚动条动态加载请求数据，每次加载5条
	function loadCategoryListByScroll(){
		if(needloading && !loading){
			var getCount = $("#adminCategoryList").children("tr").length;
			if(getCount>=5){
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
	return {
		initLoadCategoryList : initLoadCategoryList,
		loadCategoryListByScroll : loadCategoryListByScroll
	}
})();
$(function(){
	category.initLoadCategoryList();
});