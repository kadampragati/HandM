
/**
 * JS for resource related operations
 */

$(document).ready( function(){
	
	
$("#show-btn").click(function(){
		
		alert("show all");
		$.ajax({
			type : "POST",
			cache : false,
			url :"showData",
			beforeSend : function(){
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("Error in ajax call with textStatus: "+textStatus+" and error: "+errorThrown);
			},
			success: function(response){
				$("#main-page-div").html(response);
				alert("success");
			},
			complete : function(){
			}
			
		});
	});
	

$("#save-btn").click(function(){
	
	alert("save-btn");
	$.ajax({
		type : "POST",
		cache : false,
		url :"showData",
		
		error: function(jqXHR, textStatus, errorThrown) {
			console.log("Error in ajax call with textStatus: "+textStatus+" and error: "+errorThrown);
		},
		success: function(response){
			$("#sort-data-div").html(response);
			alert("success");
		},
	});
});

$("#back-btn").click(function(){
	
	alert("backBtn");
	$.ajax({
		type : "POST",
		cache : false,
		url :"backBtn",
		beforeSend : function(){
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log("Error in ajax call with textStatus: "+textStatus+" and error: "+errorThrown);
		},
		success: function(response){
			$("#sort-input-div").html(response);
		},
		complete : function(){
		}
		
	});
});


	$("#sort-btn").click(function(){
		
		alert($("#sort_num_entry").val());
		var valNums = $("#sort_num_entry").val(); 
		$.ajax({
			type : "POST",
			cache : false,
			url :"sortData?inputData="+valNums,
			
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("Error in ajax call with textStatus: "+textStatus+" and error: "+errorThrown);
			},
			success: function(response){
				console.log(response);
				$("#sort-data-div").html(response);
				alert("success");
			}
			
		});
	});

});

