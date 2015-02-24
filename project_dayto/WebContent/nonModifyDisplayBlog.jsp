<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Day Together</title>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/skel-layers.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/init.js"></script>
		<script src="${pageContext.request.contextPath}/js/dayto_alert.js"></script>
		
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" />
			
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.bpopup.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
		<link href="${pageContext.request.contextPath}/css/login/loginstyle.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/signup/signupstyle.css" rel="stylesheet" type="text/css" />
		
		<link
			href='${pageContext.request.contextPath}/css/fullcalendar/fullcalendar.css'
			rel='stylesheet' />
		<link
			href='${pageContext.request.contextPath}/css/fullcalendar/fullcalendar.print.css'
			rel='stylesheet' media='print' />
		<script src='${pageContext.request.contextPath}/js/moment.min.js'></script>
		<script
			src='${pageContext.request.contextPath}/js/jquery-ui.custom.min.js'></script>
		<script src='${pageContext.request.contextPath}/js/fullcalendar.min.js'></script>
			<script type="text/javascript">
      /** Google Map 객체. **/
         GoogleMap = {
            /* 초기화. */
            initialize : function() {
               var latlngs = [];
               var names = [];
               var tels = [];
               
               var coordinates=[];
               var paths=[];
               
               <c:forEach var="place" items="${placeList}">
	               latlngs.push(new google.maps.LatLng(${place.addressX},${place.addressY}));
	               names.push('${place.placeName}');
	               tels.push('${place.placeTel}');
               </c:forEach>
               
               this.input = document.getElementById("GoogleMap_input");
               this.address = document.getElementById("GoogleMap_addr");
               this.geocoder = new google.maps.Geocoder();
               this.infowindow = new google.maps.InfoWindow();

               var x=37.54857886215574;
               var y=126.95317768942301;
               
               var latlng = new google.maps.LatLng(x,y);
               
               var myOptions = {
                  zoom : 17,
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
                     animation : google.maps.Animation.DROP,
                     icon : "images/number/"+(i+1)+".jpg"
                  });
                  if(i==0){
                  GoogleMap.map.setCenter(latlngs[0]);
                  }
                  coordinates.push(latlngs[i]);
                
         
                  /* var infowindow = new google.maps.InfoWindow(
                	      { content:str,  
                	        size: new google.maps.Size(50,50)
               		});
                  infowindow.open(this.map, this.marker); */
               }
               var path=new google.maps.Polyline({
            	  path:coordinates,
            	  strokeColor: '#000000',
      		    	strokeOpacity: 1.0,
      		    	strokeWeight: 3
               });
               path.setMap(this.map);

            },
            
         },

         window.onload = function() {
            GoogleMap.initialize();
         }
      </script>
		<script>
			$(document).ready(function() {
				$(".login_fail").click(login_fail_alert)
				$("#logout").click(logout_alert)
				
				/* initialize the calendar
	 			-----------------------------------------------------------------*/
	 			$('#calendar').fullCalendar({
	 				header : {
	 					left : 'prev, today',
	 					center : 'title',
	 					right : 'next'
	 				},
	 				height : 400,
	 				now: "${timetableList[0].startTime}",
	 				events : [
	 					<c:forEach var="t" items = "${timetableList}">
	 					{
	 						title : "${t.placeName}",
	 						start : '${t.startTime}',
	 						end : '${t.endTime}'
	 					},
	 					</c:forEach>
	 				]
	 			});
				
			});
			function login_popup() {
				$('#member_popup').bPopup({
				    contentContainer:'.content',
				    loadUrl: '${pageContext.request.contextPath}/login.jsp'
				})
			};
			function mypage_popup() {
				$('#member_popup').bPopup({
				    contentContainer:'.content',
				    loadUrl: '${pageContext.request.contextPath}/mypage.jsp'
				})
			};
		</script>
		<style>
			.Pstyle {
			    opacity: 0;
			    display: none;
			    position: relative;
			    width: auto;
			    border: 5px solid #fff;
			    padding: 20px;
			    background-color: #fff;
			}
			#calendar {
				float: left;
				width: 400px;
			}
		</style>
	</head>
	<body>
		<jsp:include page="top_layer.jsp" />
		
		<!-- <section id="main" class="wrapper style1"> -->
		<br/><br/><br/>
			<header class="major">
				<h2>${blog.postName}</h2>
				<h5 align="center" style="margin-top: 30px">작성자 : ${blog.userEmail} 작성일 : ${blog.postDate}</h5>
			</header>
			
			<p align="center">${blog.postContent}</p>
			<hr size="5px" color="#000000" width="1300" style="margin-left:auto; margin-right:auto;">
			<div class="container" align="center">
				<section>
					<c:forEach items="${blog.pictureList}" var="p">
						<img src="${p.postPic}" width="230px" height="200px"/>
					</c:forEach>
				</section>
			</div>
			<br/>
			<div class="row">
				<div class="6u">
					<section class="special">
						<div id='calendar' style="margin-left:200px;"></div>
					</section>
				</div>
				<div class="6u">
					<section class="special">
					<div id="GoogleMap_map"
						style="width: 400px;margin-left:-40px; height: 400px;"></div>
					</section>
				</div>
			</div>
		<br/><br/><br/><br/><br/>
		<!-- </section> -->
	</body>
</html>
