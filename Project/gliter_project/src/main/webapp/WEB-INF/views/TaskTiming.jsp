<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard | Gliters Lab V. Pvt Ltd</title>
</head>
<body>

<%@include file="aheader.jsp" %>
<%@include file="arside.jsp" %>
<%@include file="aside.jsp" %>
<div class="wrapper">
<div class="content-wrapper"><div class="col-md-12">
   
      <!doctype html>
<html>
	<head>
	 	<script src="${pageContext.request.contextPath}/resources/adminLte/bower_components/chart.js/Chart.js"></script>
	</head>
	<body>
	<div class="box box-success box-solid">
	<div class="box-header">
<span class="box-title">Line Chart</span>
	</div>
	<div class=" box-body">
		<div style="width:100%">
			<div class="col-md-12">
				<canvas id="canvas" height="600" width="1200"></canvas>
			</div>
		</div>

	</div>

	</div>


	<script>
		var randomScalingFactor = function(){ return Math.round(Math.random()*60)};
		var lineChartData = {
			labels : ["dashboard","loginPage","functionality","designing","implementation","Database","Configuration"],
			datasets : [
				 
				{
					label: "My Second dataset",
					fillColor : "rgba(151,187,205,0.2)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(151,187,205,1)",
					data : [40,35,45,50,40,55,49]
				}
			]

		}

	window.onload = function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}


	</script>
	</body>
</html>
      
   
    <!-- Content Header (Page header) -->
   
   </div>
   
 
</div>
<!-- ./wrapper -->

</body>
</html>
      
      
          </div>

 
 
         </div>
 
 
        
        
   
<%@include file="afooter.jsp" %>



</body>
</html>