var category = (function(){
	function initLoadCategoryList(){
		$.ajax({
			url : "admin/categoryListAC!initLoadCategoryList.action",
			type : "post",
			dataType : "json",
			success : function(rs){
				adminCategoryListView(rs);
			},error:function(){
				alert(1)
			}
		})
	}
	
	function adminCategoryListView(rs){
		var categoryList = rs.categoryList;
		var $tr = "";
		if(categoryList!=null){
			for(var i=0;i<categoryList.length;i++){
				$tr+="<tr><td>"+(i+1)+"</td>"
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
		$("#adminCategoryList").html($tr);
	}
	return {
		initLoadCategoryList : initLoadCategoryList
	}
})();
$(function(){
	category.initLoadCategoryList();
});