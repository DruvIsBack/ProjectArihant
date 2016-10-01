$(document).ready(function(e){
	var boolValidName;
	var boolValidPhoto;
	
	$("#user_logout").hide();
	$("#user_photo").hide();
	$("#country").on("change",function(e){
		var selectedcountry = $("#country").val();			
			$.ajax({
				type: "get",
				data: "countryid="+selectedcountry,
				url: "getStatesByCountry",
				success : function(data) {
					$("#state").empty();
					if(data.length >0){
						$("#country").css("background-color","lightgreen");
						$('#state').append(new Option("--SELECT--", "-1"));
						$.each(data,function(index,state){
							$('#state').append(new Option(state.name, state.id));
						});
					}else{
						$("#state").css("background-color","red");
						$("#country").css("background-color","red");
						$('#state').append(new Option("None", "-1"));
						if($('#city').val()>0){
							$('#city').empty().append(new Option("None", "-1")).css("background-color","red");
						}
					}
				},
				error : function(e) {
					alert("ERROR: Fetch states data...");
				}
			});
	});
	$("#state").on("change",function(e){
		var selectedstate = $("#state").val();			
		$.ajax({
			type: "get",
			data: "stateid="+selectedstate,
			url: "getCitiesByState",
			success : function(data) {
				$("#city").empty();
				if(data.length >0){
					$("#state").css("background-color","lightgreen");
					$('#city').append(new Option("--SELECT--", "-1"));
					$.each(data,function(index,city){
						$('#city').append(new Option(city.name, city.id));
					});
				}else{
					$("#state").css("background-color","red");
					$("#city").append(new Option("None", "-1")).css("background-color","red");
				}
			},
			error : function(e) {
				alert("ERROR: Fetch cities data...");
				alert(e);
			}
		});
	});
	$("#photoupload").change(function(e){
		var ext = $('#photoupload').val().split('.').pop().toLowerCase();
		if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
			$("#photoupload").css("background-color","red");
			$("#photopreview").attr("src","");
			boolValidPhoto = false;
		}else{
			$("#photoupload").css("background-color","lightgreen");
			boolValidPhoto = true;
			var reader = new FileReader();
		    reader.onload = function (e) {
		    	$("#photopreview").attr("src",e.target.result);
		    };
		    reader.readAsDataURL(this.files[0]);
		}
	});
	$("#city").change(function(e){
		if($("#city").val()>0){
			$("#city").css("background-color","lightgreen");
		}else{
			$("#city").css("background-color","red");
		}
	});
	$("#dob").change(function(e){
		dob = new Date($("#dob").val());
		var today = new Date();
		var age = Math.floor((today-dob) / (365.25 * 24 * 60 * 60 * 1000));
		if(age>=18){
			$("#dob").css("background-color","lightgreen");
			$("#showage").html(age+" Years Old");
		}else{
			$("#dob").css("background-color","red");
			$("#showage").html(age+" Years old (Must be atleast 18 Years for valid)");
		}
	});
	$("#name").keyup(function(e){
		var name = $("#name").val();
        var pattern = new RegExp('^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$');
        if (pattern.test(name)) {
        	boolValidName = true;
        	$("#name").css("background-color","lightgreen");
        }else{
        	boolValidName = false;
        	$("#name").css("background-color","red");
        }
	});
	$("#username").keyup(function(e){
		$.ajax({
			type: "get",
			data: "username="+$("#username").val(),
			url: "validUsername",
			success : function(data) {
				if(data==true){
					$("#username").css("background-color","red");
				}else{
					$("#username").css("background-color","lightgreen");
				}
				console.log("Valid Username :- "+data);
			},
			error : function(e){
				alert("ERROR: Fetch username data...");
			}
		});
	});
	$("#submit").click(function(e){
		if(boolValidName && boolValidPhoto){
			var oMyForm = new FormData();
			oMyForm.append("file", photoupload.files[0]);
			
			$.ajax({
				url:"submitRegForm",
				data: oMyForm,
				type: "post",
				dataType: 'text',
			    processData: false,
			    contentType: false,
				success: function(data){
					$("html").html("Form Uploaded Successfully...");
				},
				error: function(){
					alert("Can't submitted");
				}
			});
		}else{
			alert("Sorry can't Submit !!! Correct your form first...");
		}
	});
});
