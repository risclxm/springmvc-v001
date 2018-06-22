<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>此时管理后台</title>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=lYq5FYI20e9Le47UtvtAudWbSSPdfVed"></script>
<jsp:include page="../common/head.jsp"></jsp:include>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/bootstrap3-typeahead.min.js"></script>
<script type="text/javascript">

	//根据经纬度显示地区
	function loadPlace(longitude, latitude, level,pos) {
		if (parseFloat(longitude) > 0 || parseFloat(latitude) > 0) {
			level = level || 13;
			//绘制地图
			var map = new BMap.Map("map"); // 创建Map实例  
			var point = new BMap.Point(longitude, latitude); //地图中心点 
			map.centerAndZoom(point, level); // 初始化地图,设置中心点坐标和地图级别。 
			//描点
			$.each(pos,function(i,n){
				var newPoint = new BMap.Point(n.longitude, n.latitude);
				var marker = new BMap.Marker(newPoint);  // 创建标注
				
				marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
				//绘制覆盖物
				//var myIcon = new BMap.Icon(n.iconurl, new BMap.Size(300,300));
				//var marker2 = new BMap.Marker(newPoint,{icon:myIcon});  // 创建标注
				map.addOverlay(marker);               // 将标注添加到地图中
				var str="活动名称:"+n.activename+"<br/> 开始时间:"+dateFormat(n.startdate,'yyyy-MM-dd HH:mm')+"<br/> 结束时间:"+dateFormat(n.enddate,'yyyy-MM-dd HH:mm')+"<br/> 地点:"+n.addr;
				addClickHandler(map,str,marker);
			});
			map.enableScrollWheelZoom(true); //启用滚轮放大缩小  
			//向地图中添加缩放控件  
			var ctrlNav = new window.BMap.NavigationControl({
				anchor : BMAP_ANCHOR_TOP_LEFT,
				type : BMAP_NAVIGATION_CONTROL_LARGE
			});
			map.addControl(ctrlNav);

			//向地图中添加缩略图控件  
			var ctrlOve = new window.BMap.OverviewMapControl({
				anchor : BMAP_ANCHOR_BOTTOM_RIGHT,
				isOpen : 1
			});
			map.addControl(ctrlOve);

			//向地图中添加比例尺控件  
			var ctrlSca = new window.BMap.ScaleControl({
				anchor : BMAP_ANCHOR_BOTTOM_LEFT
			});
			map.addControl(ctrlSca);

		}
	}
	
	function addClickHandler(map,content,marker){
		marker.addEventListener("click",function(e){
			openInfo(map,content,e)}
		);
	}
	function openInfo(map,content,e){
	    var opts = {
				width : 250,     // 信息窗口宽度
				height: 80,     // 信息窗口高度
				title : "活动详情" , // 信息窗口标题
				enableMessage:true//设置允许信息窗发送短息
	    };
		var p = e.target;
		var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
		var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	}
	
	function mapSearch() {
		//异步发送请求获得经纬度
		$.ajax({
			url : 'city/mapcity.action',
			type : 'POST', // GET
			async : true, // 或false,是否异步
			data : 'cityName=' + $("#activeCity").val(),
			timeout : 5000, // 超时时间
			dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
			success : function(data, textStatus, jqXHR) {
				
					//定位地图
				loadPlace(data.city.longitude,data.city.latitude,10,data.actives);
				
			},
			error : function(data, textStatus) {
				bootbox.alert({
					buttons : {
						ok : {
							label : '确定',
							className : 'btn-myStyle'
						}
					},
					message : '请检查输入的城市名称',
					title : "操作消息",
				});
			}
		});
	}
	
	$(function(){
		$.ajax({
			url : 'city/mapcity.action',
			type : 'POST', // GET
			async : true, // 或false,是否异步
			data : 'cityName=北京市',
			timeout : 5000, // 超时时间
			dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
			success : function(data, textStatus, jqXHR) {
				//alert(data.status);
				//将焦点定在北京市
				//if(data.status==0){
					//定位地图
					loadPlace(data.city.longitude,data.city.latitude,10,data.actives);
				
			},
			error : function(data, textStatus) {
				bootbox.alert({
					buttons : {
						ok : {
							label : '确定',
							className : 'btn-myStyle'
						}
					},
					message : '请检查输入的城市名称',
					title : "操作消息",
				});
			}
		});
	})
</script>
</head>
<body>
	<jsp:include page="../common/common_header.jsp"></jsp:include>
	<div class="ch-container">
		<div class="row">
			<jsp:include page="../common/common_left.jsp"></jsp:include>
			<div id="content" class="col-lg-10 col-sm-10">
				<!-- content starts -->
				<div>
					<ul class="breadcrumb">
						<li><a href="pages/home/index.jsp">首页</a></li>
					</ul>
				</div>
				<div>
					<table class="table table-bordered">
						<tr>
							<td class="active">今日新增用户数</td>
							<td id="dayUserCount">22</td>
							<td class="active">今日新增活动数</td>
							<td id="adayActiveCount">22</td>
						</tr>
						<tr>
							<td class="active">本月新增用户数</td>
							<td id="a3">22</td>
							<td class="active">本月新总活动数</td>
							<td id="a4">22</td>
						</tr>
						<tr>
							<td class="active">总用户数</td>
							<td id="a5">22</td>
							<td class="active">总活动数</td>
							<td id="a6">22</td>
						</tr>
					</table>
				</div>
				<div class="row">
					<div style="text-align: right" class="box col-md-12">
						<form class="form-inline">
							<div class="form-group">
								<label for="activeCity">活动城市</label> <input type="text"
									class="form-control" id="activeCity" name="activeCity"
									placeholder="请输入活动城市" autocomplete="off"
									data-provide="typeahead" />
							</div>
							<button type="button" class="btn btn-primary"
								onclick="mapSearch()">
								<span class="glyphicon glyphicon-search"></span>查询
							</button>
						</form>
					</div>
				</div>
				<div class="row">
					<div class="box col-md-12"
						style="min-height: 450px; margin-top: 5px; width: 100%;" id="map">
					</div>
					<!--/span-->
				</div>
				<!--/row-->
				<!-- content ends -->
			</div>
			<!--/#content.col-md-0-->
		</div>
		<!--/fluid-row-->
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
					//初始化页面信息
					$.ajax({
						url : 'homepage/count.action',
						type : 'GET', // GET
						async : true, // 或false,是否异步
						data : '',
						timeout : 5000, // 超时时间
						dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
						success : function(data, textStatus, jqXHR) {
							$("#dayUserCount").html(data.dayUserCount);
							$("#dayActiveCount").html(data.dayActiveCount);
							$("#a3").html(data.monthUserCount);
							$("#a4").html(data.monthActiveCount);
							$("#a5").html(data.AllUserCount);
							$("#a6").html(data.allActiveCount);
							
						},
						error: function(data, textStatus, jqXHR) {
							alert("error");
							
							
						}
					});
					//初始化所有城市  补全提示
					$('#activeCity').typeahead(
							{
								source : function(query, process) {
									$.ajax({
										url : 'active/citys',
										type : 'post',
										data : {
											topicName : query
										},
										dataType : 'json',
										success : function(data) {
											// 这里的数据解析根据后台传入格式的不同而不同  
											process(data);
										}
									});
								},

								highlighter : function(item) {
									var query = this.query.replace(
											/[\-\[\]{}()*+?.,\\\^$|#\s]/g,
											'\\$&')
									return item.replace(new RegExp('(' + query
											+ ')', 'ig'), function($1, match) {
										return '<strong>' + match + '</strong>'
									})
								},

								updater : function(item) {
									return item;
								}

							});
				});
	</script>
	<jsp:include page="../common/common_footer.jsp"></jsp:include>
</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
</html>
