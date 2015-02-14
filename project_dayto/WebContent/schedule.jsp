<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Schedule</title>
      
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="description" content="" />
      <meta name="keywords" content="" />
      <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/skel-layers.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/init.js"></script>
      <script src="${pageContext.request.contextPath}/js/dayto_alert.js"></script>
      <!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script> -->
      
      <link rel="stylesheet"
         href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" />
      
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
               var latlngs = [];
               var names = [];
               var tels = [];
               <c:forEach var="place" items="${placeList}">
               
               latlngs.push(new google.maps.LatLng(${place.addressX},${place.addressY}));
               names.push('${place.placeName}');
               tels.push('${place.placeTel}');
               </c:forEach>
               
               this.input = document.getElementById("GoogleMap_input");
               this.address = document.getElementById("GoogleMap_addr");
               this.geocoder = new google.maps.Geocoder();
               this.infowindow = new google.maps.InfoWindow();
               //var temp=${place.addressX};
               var x=37.54857886215574;
               var y=126.95317768942301;
               //if(37.54857886215574+temp>40){
               //   x=${place.addressX};
               //   y=${place.addressY};
               //}
               
               var latlng = new google.maps.LatLng(x,y);
               
               var myOptions = {
                  zoom : 15,
                  center : latlng, 
                  mapTypeId : google.maps.MapTypeId.ROADMAP
               };
               this.map = new google.maps.Map(document
                     .getElementById("GoogleMap_map"), myOptions);
   
   
               
               for(var i=0 ; i< latlngs.length; ++i){
                  var str= names[i];
                  this.marker = new google.maps.Marker({
                     
                     position:latlngs[i],
                     map : this.map,
                     title: str,
                     animation : google.maps.Animation.DROP
                  });
                  GoogleMap.map.setCenter(latlngs[i]);
               }               
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
                        console.log('test');
                        var str = '${pageContext.request.contextPath}/getPlaceListByAddr.do?str=' + address;
                        
                        a.href = str;
                        
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
        	$(".login_fail").click(login_fail_alert);
 			$("#logout").click(logout_alert);
 			
 			var place = null;
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
 					revertDuration : 0,
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
 				drop : function() {
 					place = $.trim($(this).text());
 					alert("Dropped on " + place);
 				}
 			});
 			
 			$('.fc-content').each(function() {
 				$(this).drop( function() {
 					place = $.trim($(this).text());
 					console.log(place);
 				});
 			});
 		});
      
         function personController($scope) {
            $scope.firstName = "John", $scope.lastName = "Doe"
            $scope.myVar = true;
            $scope.toggle = function() {
               $scope.myVar = !$scope.myVar;
            };
         }
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
            width: 310px;
            height: 800px;
            margin: 10px;
            padding: 0 10px;
            border: 1px solid #ccc;
            background: #fff;
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
   <body id="schedule-body" ">
      <jsp:include page="top_layer.jsp" />
   
      <div id='calendar'></div>
   
      <div id='external-events' style="overflow: scroll">
		<h4>Place</h4>
		<c:forEach var="p" items="${placeList}">
			<div id="${p.placeId}"class='fc-event' align="center">
				<img class="schedule-image" src="images/base_cover.jpg" alt="" />
				${p.placeName}
			</div>
		</c:forEach>
	</div>
      <div id="menubar1">
         <a href="#">음식점</a> <a href="#">카페</a> <a href="#">쇼핑</a>
          <a href="#">지역명소</a> <a href="#">영화연극</a>
         <div id="GoogleMap_map"
            style="width: 500px; height: 500px; margin-top: 30px;"></div>
   
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
      <div style="margin-top: 300" class="button special">
         <a href="${pageContext.request.contextPath}/writingBlog.jsp">save a schedule</a>
      </div>
   </body>
</html>