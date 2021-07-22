
/*============================//
//    Variables & Methods  	  //
//============================*/

    drop = 0;
    counter = 2;
    count = 1;
    store = 1
    number = 0;
    img = 0; sign = 0;
    filenum = 0;
    status1 = new Array();
    fileName = new Array();
    path = new Array();
    while(store<=10){
        fileName[store] = 0;
        status1[store] = 0;
        path[store] = 0;
        //console.log("status"+store+"="+status1[store]);
        store++;
    }
 		function img_reader(event,num) 
		{
 			  reader = new FileReader();
 		   	proc = event;
        number = num;
        status1[filenum] = 0;
        //console.log("status["+filenum+"] = "+status1[filenum]);
		}
		function upload_img(n1){
      if(number == n1)
      {
          reader.onload = function()
          {
              var output = document.getElementById('output_img');
              output.src = reader.result;
              console.log(output);
          }
          try{
              img = proc.target.files[0];
              console.log(img);
              reader.readAsDataURL(img);
              proc = null;
          }catch(err){
              alert("Image is already uploaded!");
              return false;
          }
      }
      else if(img != 0){
          alert("Image is already uploaded!");
          return false;
      }
      else{
          alert("Please, Choose any one image file!");
          return false;
      }
		}
		function upload_sign(n2){
 			if(number == n2){
          reader.onload = function()
          {
              var output = document.getElementById('output_sign');
              output.src = reader.result;
          }
          try{
              sign = proc.target.files[0];
              reader.readAsDataURL(sign);
              proc = null;
          }catch(err){
              alert("Signature is already uploaded!");
          }
      }
      else if(sign != 0){
          alert("Signature is already uploaded!");
          return false;
      }
      else{
          alert("Please, Choose any one image file!");
          return false;
      }
      proc = null;
		}
    function upload_file(num, pos){
      n = num;
      filenum = pos;
      //console.log("number = "+number+", n = "+n+", fileName["+pos+"] = "+fileName[pos]+", status["+pos+"] = "+status1[pos]);
      
      if(fileName[pos] != 0){
          alert("Document is already uploaded!");
          return false;
      }
      else if(number == n && pos != status1[pos]){
          try{
              
              fileName[pos] = proc.target.files[0].name;
              path[pos] = document.getElementById("file1").value;
              
              console.log("catch");
              var code = '<div style="text-align: left; font-size: small; margin-top: 10px;" onchange="setFileName(1'+counter+')">'
                    +'<span>Uploaded File : </span>'
                    +'<span id="fileText" style="color: #a6b033"><a herf="'+path[pos]+'">'+fileName[filenum]+'</a></span>'
                +'</div>';

              $("#UploadedFileName"+pos).append(code);
              proc = null;
          }catch(err){
              alert("Document is already uploaded!");
          }
      }
      else{
          alert("Please, Choose any one document file!");
          return false;
      }
      count++;
    }
    function upload_all(){
        alert("Comming Soon, Bye!");
    }
		function appendCode(){	
			    if(counter>10+drop){
            	alert("Only 10 files allowed to upload!");
            	return false;
      		}
          var code = '<div id="TextBoxDiv'+counter+'" class="form-row">'
                        +'<div class="form-group col-md-8" style="margin-top: 10px;">'
                          +'<p style="text-align: left; font-size: small;">Upload Document*</p>'
                          +'<input type="file" name="img[]" class="file" accept=".xlsx,.xls,image/*,.doc, .docx,.ppt, .pptx,.txt,.pdf" onchange="img_reader(event, 1'+counter+');">'
                          +'<div class="input-group">'
                            +'<input  type="text" id="file'+counter+'" class="browse form-control" placeholder="Choose File...">'
                            +'<span class="input-group-btn">'
                              +'<button class="browse btn btn-default" type="button">BROWSE !</button>'
                            +'</span>'
                          +'</div>'
                          +'<div id="UploadedFileName'+counter+'"><!-- Insert Here --></div>'
                        +'</div>'
                        +'<div class="form-group col-md-4" style="margin-top: 8px;">'
                          +'<button type="button" class="btn btn-success" style="margin-top: 30px; margin-right: 10px;" onclick="upload_file(1'+counter+','+counter+');"><i class="fa fa-check-circle"></i>&nbsp; UPLOAD</button>'
                          +'<button type="button" class="btn btn-danger" style="margin-top: 30px; margin-left: 10px;" onclick="removeCode('+counter+');"><i class="fa fa-trash-o"></i></i>&nbsp; REMOVE</button>'
                        +'</div>'
                      +'</div>';

  			  $("#TextBoxesGroup").append(code);	
  			  counter++;
          proc = null;
		}
		function removeCode(num)
		{
			if(counter<=1)
			{
            	alert("No more textbox to remove");
            	return false;
          	}   
            status1[filenum] = filenum;
            drop++;
            //console.log("status="+status1[num]);
            fileName[filenum] = 0;
            //console.log("status["+filenum+"] = "+status1[filenum]+", fileName ["+filenum+"] = "+fileName[filenum]);
          	$("#TextBoxDiv" + num).remove();
		}

    //===== Browse Images and Files =====//

    $(document).on('click', '.browse', function(){
        var file = $(this).parent().parent().parent().find('.file');
        file.trigger('click');
    });
    $(document).on('change', '.file', function(){
      $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''));
    });


    function showAccDeposit(){
    	var acc_num = $('#acc_num').val();
    	alert(acc_num);
        var code='<%'
        		  		+'try {'
        		  			+'Connection con = connection.DbConnect.initializeDatabase();'
        		  			+'String query = "Select * from accounts where acc_num=?";'
        		            +'PreparedStatement pst = conn.prepareStatement(query);'
        		            
        		            +'String acc_num="'+acc_num+'";'
        		            
        		            +'pst.setString(1, acc_num);'
        		  			+'if(rs.next()){'
        		  +'%>'
        		  +'<div class="panel">'
                    +'<div class="panel-heading">'
                      +'<h4 class="lead" style="text-align: left; margin-bottom: 20px;">Account Details</h4>'
                      +'<div class="right">'
                          +'<button type="button" class="btn-toggle-collapse1"><i class="lnr lnr-chevron-up"></i></button>'
                        +'</div>'
                      +'</div>'
                      +'<div class="panel-body1 no-padding" style="display: block; overflow-x:auto; margin-top: -30px;">'
                        +'<table class="table table-striped">'
                          +'<thead>'
                            +'<tr>'
                              +'<th style="text-align: center; font-size: small;">A/c Number</th>'
                                +'<th style="text-align: center; font-size: small;">A/c Holder Name</th>'
                                +'<th style="text-align: center; font-size: small;">Available Balance</th>'
                                +'<th style="text-align: center; font-size: small;">Action</th>'
                              +'</tr>'
                            +'</thead>'
                            +'<tbody>'
                              +'<tr>'
                                +'<td><a href="#"><%=rs.getString("acc_num") %></a></td>'
                                +'<td><%=rs.getString("holder_name") %></td>'
                                +'<td>&#x20B9; <span style="font-weight: bold;"><%=rs.getString("closing_bal") %></span></td>'
                                +'<td>'
                                  +'<a class="label label-primary" href="javascript:add_debit_amount();">Open</a> | '
                                  +'<a class="label label-success" href="#">View</a>'
                                +'</td>'
                              +'</tr>'
                              +'<%		}'
								+'} catch (SQLException | ClassNotFoundException ex) {'
								+'}'
							   +'%>'
                            +'</tbody>'
                          +'</table>'
                        +'</div>'
                      +'</div>';

        $("#showTable").append(code);
    }

    function showAccWithdraw(){
        var code='<div class="panel">'
                    +'<div class="panel-heading">'
                      +'<h4 class="lead" style="text-align: left; margin-bottom: 20px;">Account Details</h4>'
                      +'<div class="right">'
                          +'<button type="button" class="btn-toggle-collapse1"><i class="lnr lnr-chevron-up"></i></button>'
                        +'</div>'
                      +'</div>'
                      +'<div class="panel-body1 no-padding" style="display: block; overflow-x:auto; margin-top: -30px;">'
                        +'<table class="table table-striped">'
                          +'<thead>'
                            +'<tr>'
                              +'<th style="text-align: center; font-size: small;">A/c Number</th>'
                                +'<th style="text-align: center; font-size: small;">A/c Holder Name</th>'
                                +'<th style="text-align: center; font-size: small;">Credit Amount</th>'
                                +'<th style="text-align: center; font-size: small;">Available Balance</th>'
                                +'<th style="text-align: center; font-size: small;">Action</th>'
                              +'</tr>'
                            +'</thead>'
                            +'<tbody>'
                              +'<tr>'
                                +'<td><a href="#">XXXXXX63481</a></td>'
                                +'<td>RAJ KUMAR SONY</td>'
                                +'<td>&#x20B9; <span style="font-weight: bold;">5000.00</span></td>'
                                +'<td>&#x20B9; <span style="font-weight: bold;">20000.00</span></td>'
                                +'<td>'
                                  +'<a class="label label-primary" href="javascript:add_withdraw_amount();">Open</a> | '
                                  +'<a class="label label-success" href="#">View</a>'
                                +'</td>'
                              +'</tr>'
                            +'</tbody>'
                          +'</table>'
                        +'</div>'
                      +'</div>';

        $("#showTable").append(code);
    }

		// $(".custom-file-input").on("change", function() {
		// 	var fileName = $(this).val().split("\\").pop();
  // 			$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
		// });

		// function readURL(input) {
  //       	if (input.files && input.files[0]) {
  //           	var reader = new FileReader();
  //           	reader.onload = function (e) {
  //           	    $('.img-thumbnail')
  //           	    .attr('src', e.target.result);
  //           	};
  //           	reader.readAsDataURL(input.files[0]);
  //       	}
  //   	}
  