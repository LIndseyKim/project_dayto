<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Schedule</title>
<jsp:include page="top_layer.jsp" flush="false" />

<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<link href='css/fullcalendar/fullcalendar.css' rel='stylesheet' />
<link href='css/fullcalendar/fullcalendar.print.css' rel='stylesheet'
	media='print' />
<script src='js/moment.min.js'></script>
<script src='js/jquery-ui.custom.min.js'></script>
<script src='js/fullcalendar.min.js'></script>
<script type="text/javascript">
	/** Google Map 객체. **/
	GoogleMap = {
		/* 초기화. */
		initialize : function() {
			var markers = [];
			this.input = document.getElementById("GoogleMap_input");
			this.address = document.getElementById("GoogleMap_addr");
			this.geocoder = new google.maps.Geocoder();
			this.infowindow = new google.maps.InfoWindow();

			//지도 생성.(기본 위치 서울.)  
			var latlng = new google.maps.LatLng(37.56641923090, 126.9778741551);
			var myOptions = {
				zoom : 15,
				center : latlng,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			this.map = new google.maps.Map(document
					.getElementById("GoogleMap_map"), myOptions);

			//마커 생성.  
			this.marker = new google.maps.Marker({
				map : this.map,
				animation : google.maps.Animation.DROP
			});
		},
		/* 주소 검색.(지오코딩) */
		codeAddress : function() {
			var address = this.input.value;
			//콜백 함수 호출.  
			this.geocoder.geocode({
				'address' : address
			}, function(results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					//검색 된 주소 목록.  
					GoogleMap.address.innerHTML = "";
					var ul = document.createElement('ul');
					for (var i = 0; i < results.length; i++) {
						var li = document.createElement('li');
						var a = document.createElement('a');

						a.href = "#";
						a.innerHTML = results[i].formatted_address;
						GoogleMap.clickAddress(a, results[i].geometry.location,
								results[i].formatted_address);

						li.appendChild(a);
						ul.appendChild(li);
					}
					GoogleMap.address.appendChild(ul);
				}
			});
		},
		//주소 클릭 이벤트.  
		clickAddress : function(a, addr, content) {
			a.onmousedown = function() {
				//지도와 마커이동.  
				GoogleMap.map.setCenter(addr);
				GoogleMap.marker.setPosition(addr);
				GoogleMap.marker.setAnimation(google.maps.Animation.DROP);
				GoogleMap.infowindow.setContent(content);
				GoogleMap.infowindow.open(GoogleMap.map, GoogleMap.marker);
			}
		}
	}
	window.onload = function() {
		GoogleMap.initialize();
	}
</script>
<script>


	$(document).ready(function() {
		/* initialize the external events
		-----------------------------------------------------------------*/
		$('#external-events .fc-event').each(function() {

			// store data so the calendar knows to render an event upon drop
			$(this).data('event', {
				title : $.trim($(this).text()), // use the element's text as the event title
				stick : true
			// maintain when user navigates (see docs on the renderEvent method)
			});

			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex : 999,
				revert : true, // will cause the event to go back to its
				revertDuration : 0
			//  original position after the drag
			});

		});

		/* initialize the calendar
		-----------------------------------------------------------------*/
		$('#calendar').fullCalendar({
			header : {
				left : 'prev, today',
				center : 'title',
				right : 'next'
			},
			height : 800,
			editable : true,
			droppable : true, // this allows things to be dropped onto the calendar
		});
	});
</script>

<style>
div#menubar1 {
	float: left;
	padding: 0;
	margin-left: 100px;
	margin-top: 30px;
	border: 0;
}

div#menubar1>a {
	font-family: Malgun Gothic, Gulim, Arial, Helvetica, sans-serif;
	font-size: 14px;
	background: #c8c8c8;
	padding: 12px;
	color: #EBFBFF;
	margin-right: 10px;
	text-decoration: none;
	border-radius: 5px;
}

div#menubar1>a:hover {
	background: #5AD2FF;
	color: #EBFBFF;
}

#schedule-body {
	float: left;
	margin-top: 40px;
	text-align: center;
	font-size: 14px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
}

#wrap {
	width: 1500px;
	margin: 20px 20px;
}

#external-events {
	position: relative;
	left: 30px;
	float: left;
	width: 300px;
	height: 800px;
	margin: 10px;
	padding: 0 10px;
	border: 1px solid #ccc;
	background: #eee;
	text-align: center;
}

#external-events h4 {
	font-size: 16px;
	margin-top: 0;
	padding-top: 1em;
}

#external-events .fc-event {
	margin: 10px 0;
	cursor: pointer;
}

#external-events p {
	margin: 1.5em 0;
	font-size: 11px;
	color: #666;
}

#external-events p input {
	margin: 0;
	vertical-align: middle;
}

#calendar {
	float: left;
	width: 400px;
}

#map_canvas {
	top: 50px;
	width: 800px;
	height: 400px;
	left: 60px;
	boarder: 1px solid #ccc;
	background: #eee;
}

.schedule-image {
	padding-top: 5px;
	display: block;
	width: 200px;
	height: 100px;
}
</style>
</head>
<body id="schedule-body" onload="initialize()">


	<div id='calendar'></div>

	<div id='external-events'>
		<h4>Place</h4>
		<div class='fc-event' align="center">
			<img class="schedule-image" src="images/blog/pic01.jpg" alt="" /> 장소
			1
		</div>
		<div class='fc-event' align="center">
			<img class="schedule-image" src="images/blog/pic02.jpg" alt="" /> 장소
			2
		</div>
		<div class='fc-event' align="center">
			<img class="schedule-image" src="images/blog/pic03.jpg" alt="" /> 장소
			3
		</div>
		<div class='fc-event' align="center">...</div>
	</div>
	<div id="menubar1">
		<a href="#">음식점</a> <a href="#">카페</a> <a href="#">쇼핑</a> <a href="#">지역명소</a>
		<a href="#">영화연극</a>
		<div id="GoogleMap_map"
			style="width: 800px; height: 500px; margin-top:30px;"></div>
		
	</div>
	
	<div style="height: 500px; padding-top: 600px;">
		<div>
			<input id="GoogleMap_input" type="textbox" value=""
				onkeydown="javascript:if(event.keyCode == 13) GoogleMap.codeAddress();">
			<input type="button" value="Enter"
				onclick="javascript:GoogleMap.codeAddress()">
		</div>
		<div id="GoogleMap_addr"></div>
		</div>

		<div style='clear: both'></div>
		<div style="margin-top: 300" id="loginButton" href="${pageContext.request.contextPath}/writingBlog.jsp"
			class="button special">save a schedule</div>
</body>
</html>