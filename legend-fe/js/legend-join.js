$(document).ready(function(){
	alert('f');
	//member Join
	$('#btnJoin').click(function(e){
		e.preventDefault();
		
		joinValidation();
		
		// Get form
        var form = $('#joinForm')[0];

		// Create an FormData object
        var data = new FormData(form);

		// If you want to add an extra field for the FormData
        data.append("CustomField", "This is some extra data, testing");

		// disabled the submit button
        $("#btnJoin").prop("disabled", true);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/legend/registMember.jyb",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                $("#result").text(data);
                console.log("SUCCESS : ", data);
                $("#btnJoin").prop("disabled", false);

            },
            error: function (e) {

                $("#result").text(e.responseText);
                console.log("ERROR : ", e);
                $("#btnJoin").prop("disabled", false);

            }
        });

	});
	
	
});

function joinValidation(){
	if( emptyCheck('id')
		|| emptyCheck('pw') 
		|| emptyCheck('lv') 
		|| emptyCheck('ac') 
		|| emptyCheck('region') 
		|| emptyCheck('sward') 
		|| emptyCheck('earring') 
		|| emptyCheck('ring') 
		|| emptyCheck('intro') 
		|| emptyCheck('kakaoid') 
			){
		alert('내용을 적어주세요');
		return;
	}
	
	var idRegEx =/^[가-힣|a-z|A-Z|0-9|\*]+$/g;
	if(idRegEx.test($('#id').val())){
		alert('아이디를 확인해주세요');
		return;
	}
	
	
}
function emptyCheck(id){
	var chk = $('#'+id);
	if(chk == null || chk == 'undefined' || chk.trim == ''){
		chk.focus();
		return false;
	}
	return true;
}
