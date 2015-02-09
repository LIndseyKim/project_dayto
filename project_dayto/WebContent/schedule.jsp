<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Schedule</title>
		<jsp:include page="top_layer.jsp" flush="false"/>
				
		<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
		<link href='css/fullcalendar/fullcalendar.css' rel='stylesheet' />
		<link href='css/fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
		<script src='js/moment.min.js'></script>
		<script src='js/jquery-ui.custom.min.js'></script>
		<script src='js/fullcalendar.min.js'></script>
		
		<script>
			function initialize() {
			    var myLatlng = new google.maps.LatLng(37.5647,
			  		  126.9769);
			    var mapOptions = {
			       zoom : 15,
			       center : myLatlng,
			       mapTypeId : google.maps.MapTypeId.ROADMAP
			    }
			    var map = new google.maps.Map(document.getElementById('map_canvas'),
			          mapOptions);
		  	            
			    var marker = new google.maps.Marker({ 
		            position: myLatlng, 
		            map: map, 
		            title: "서울시청" 
				}); 
			}
			
			$(document).ready(function() {
				/* initialize the external events
				-----------------------------------------------------------------*/
				$('#external-events .fc-event').each(function() {
		
					// store data so the calendar knows to render an event upon drop
					$(this).data('event', {
						title: $.trim($(this).text()), // use the element's text as the event title
						stick: true // maintain when user navigates (see docs on the renderEvent method)
					});
		
					// make the event draggable using jQuery UI
					$(this).draggable({
						zIndex: 999,
						revert: true,      // will cause the event to go back to its
						revertDuration: 0  //  original position after the drag
					});
		
				});
				/* initialize the calendar
				-----------------------------------------------------------------*/
				$('#calendar').fullCalendar({
					header: {
						left: 'prev, today',
						center: 'title',
						right: 'next'
					},
					height : 800,
					editable: true,
					droppable: true, // this allows things to be dropped onto the calendar
				});
			});
		</script>
		
		<style>
			div#menubar1 {
			   float:left;
			   padding: 0;
			   margin-left:100px;
			   margin-top:30px;
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
			   margin:10px;
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
			   width: 500px;
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
	<body id = "schedule-body" onload="initialize()">
		<div id='wrap'>
	
			<div id='calendar'></div>
			
			<div id='wrap'>

      <div id='calendar'></div>

      <div id='external-events'>
	         <h4>Place</h4>
	         <div class='fc-event' align="center">
	            <img class="schedule-image" src="images/blog/pic01.jpg" alt="" />
	            장소 1
	         </div>
	         <div class='fc-event' align="center">
	            <img class="schedule-image" src="images/blog/pic02.jpg" alt="" />
	            장소 2
	         </div>
	         <div class='fc-event' align="center">
	            <img class="schedule-image" src="images/blog/pic03.jpg" alt="" />
	            장소 3
	         </div>
	         <div class='fc-event' align="center">...</div>
	      </div>
	      <div id="menubar1" fla>
	         <a href="#">음식점</a> <a href="#">카페</a> <a href="#">쇼핑</a> <a
	            href="#">지역명소</a> <a href="#">영화연극</a>
	      </div>
	      <div id="map_canvas"></div>
	
	      <div style='clear: both'></div>
	   </div>
	</body>
</html>