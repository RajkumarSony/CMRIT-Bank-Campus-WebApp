function signup_validate(){

	var uname = $('#signup-name').val();
	var mobile = $('#signup-mob').val();
	var email = $('#signup-email').val();
	var upass1 = $('#signup-password').val();
  var upass2 = $('#signup-re-password').val();

  var regex1 = /^([0-9+])+$/;
  var regex2 = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  var len = $('#signup-mob').val().length;

	if(uname == "" || mobile == "" || email == "" || upass1 == "" || upass2 == ""){

		swal({
        title: "Oops!",
        text: "Please, Fill the required fields. Thank You!",
        icon: "error",
        dangerMode: true,
              
        buttons:{           
            confirm:{ 
                text: "RETRY ?",
                value: "retry",
            },
        },
    })
    .then((value) => {
        if(`${value}` == "retry")
        {
            return false;
        }
    });
	}    
	else if(!regex1.test(mobile) || !(len == 10)){
    	
	    	swal({
	              title: "Oops!",
    	          text: "Please, Enter your valid mobile number. Thank You!",
        	      icon: "error",
            	  dangerMode: true,
              
            	  buttons:{
          	         
     	        	   confirm:{ 
        	        	  text: "RETRY ?",
     	                  value: "retry",
         	      	   },
            	  },
        	})
        	.then((value) => {
                if(`${value}` == "retry")
                {
                  return false;
                }
        	});
  }
  else if(!regex2.test(email)){
    		swal({
              title: "Oops!",
              text: "Please, Enter your valid email-id. Thank You!",
              icon: "error",
              dangerMode: true,
              
              buttons:{
                   
                confirm:{ 
                  text: "RETRY ?",
                  value: "retry",
                },
              },
        	})
        	.then((value) => {
                if(`${value}` == "retry")
                {
                  return false;
                }
        	});
  }
  else{

    	var n = upass1.localeCompare(upass2);
    	//console.log(n);
    	if((n == '-1') || n == '1')
    	{
    		swal({
              title: "Oops!",
              text: "Your password and re-password must be same. Thank You!",
              icon: "error",
              dangerMode: true,
              
              buttons:{
                   
                confirm:{ 
                  text: "RETRY ?",
                  value: "retry",
                },
              },
        	})
        	.then((value) => {
                if(`${value}` == "retry")
                {
                  return false;
                }
        	});
    	}
      else{
    	  document.getElementById('myform').submit();
      }
  }
}

function login_validate(){

    var email = $('#login-email').val();
    var upass = $('#login-password').val();

    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if(email == "" || upass == ""){

      swal({
          title: "Oops!",
          text: "Please, Fill the required fields. Thank You!",
          icon: "error",
          dangerMode: true,
              
          buttons:{           
            confirm:{ 
                text: "RETRY ?",
                value: "retry",
            },
          },
      })
     .then((value) => {
        if(`${value}` == "retry")
        {
            return false;
        }
      });

    }

    else if(!regex.test(email)){
      
        swal({
              title: "Oops!",
              text: "Please, Enter your valid email-id. Thank You!",
              icon: "error",
              dangerMode: true,
              
              buttons:{
                   
                confirm:{ 
                  text: "RETRY ?",
                  value: "retry",
                },
              },
        })
        .then((value) => {
            if(`${value}` == "retry")
            {
                return false;
            }
        });
    }
    else{
      //window.location = "page-auth.jsp";
      document.getElementById('myform').submit();
    }
}

function signup_remember(){
      var x = document.getElementById("signup-remember").checked;
      //console.log(x);
      if(x == true){
          swal("Hurry Up!", "I remembered my all details.", "success");
          document.getElementById("signup-remember").value = true;
      }
      else{
          swal("Oops!", "I forgot my all details.", "warning");
          document.getElementById("signup-remember").value = false;
      }
}

function login_remember(){
      var x = document.getElementById("login-remember").checked;
      //console.log(x);
      if(x == true){
          swal("Hurry Up!", "I remembered my all details.", "success");
          document.getElementById("login-remember").value = true;
      }
      else{
          swal("Oops!", "I forgot my all details.", "warning");
          document.getElementById("login-remember").value = false;
      }
}

function db_login(){
    swal({
        title: "Sorry!",
        text: "Please, Enter your valid email-id and password. Thank You!",
        icon: "error",
        dangerMode: true,
              
        buttons:{               
            confirm:{ 
                text: "RETRY ?",
                value: "retry",
            },
        },
    })
    .then((value) => {
        if(`${value}` == "retry")
        {
              return false;
        }
    });
}

function code_validate(){

  var opening_amount = $('#opening-amount').val();
  var validate_code = $('#validate-code').val();

  var regex = /^([0-9+])+$/;
  var len = $('#validate-code').val().length;

  if(opening_amount == "" || validate_code == ""){

    swal({
        title: "Oops!",
        text: "Please, Fill the required fields. Thank You!",
        icon: "error",
        dangerMode: true,
              
        buttons:{           
            confirm:{ 
                text: "RETRY ?",
                value: "retry",
            },
        },
    })
    .then((value) => {
        if(`${value}` == "retry")
        {
            return false;
        }
    });
  }
    
  else if(!regex.test(opening_amount)){
      
        swal({
                title: "Oops!",
                text: "Please, Enter your valid Amount. Thank You!",
                icon: "error",
                dangerMode: true,
              
                buttons:{
                     
                   confirm:{ 
                      text: "RETRY ?",
                        value: "retry",
                     },
                },
          })
          .then((value) => {
                if(`${value}` == "retry")
                {
                  return false;
                }
          });
  }
  else if(!regex.test(validate_code) || !(len == 8)){
      
        swal({
                title: "Oops!",
                text: "Validation code must be 8-digit numeric code. Thank You!",
                icon: "error",
                dangerMode: true,
              
                buttons:{
                     
                   confirm:{ 
                      text: "RETRY ?",
                        value: "retry",
                     },
                },
          })
          .then((value) => {
                if(`${value}` == "retry")
                {
                  return false;
                }
          });
  }
  else{
        document.getElementById('myform').submit();
  }
}

function acc_info(){
  swal({
        title: "Are you sure?",
        text: "Please, Confirm your given A/c info. is either valid or not!",
        icon: "warning",
        button: {
          confirm: {
            text: "CONFIRM ?",
            value: "okey",
          },
        },
        dangerMode: true,
      })
      .then((value) => {
        if (`${value}` == "okey") {
          swal({
            title: "Awesome!",
            text: "Your given A/c info. is submitted successfully. Thank You!",
            icon: "success",
          });
        } else {
          swal({
            title: "Try Again!",
            text: "Please, Confirm with valid information! Thank You!",
            icon: "info",
            button: "OKEY !",
          });
        }
      });
}

function accNoError(){

	  var acc_num = $('#acc_num').val();
	  var re_acc_num = $('#re_acc_num').val();
	  var regex = /^([0-9+])+$/;

	  if(!regex.test(acc_num) || !regex.test(re_acc_num)){
	      
	        swal({
	                title: "Oops!",
	                text: "Given A/c number is not valid. Please, try again!",
	                icon: "error",
	                dangerMode: true,
	              
	                buttons:{
	                     
	                   confirm:{ 
	                      text: "RETRY ?",
	                        value: "retry",
	                     },
	                },
	          })
	          .then((value) => {
	                if(`${value}` == "retry")
	                {
	                	window.location = "add-beneficiery.jsp";
	                  return false;
	                }
	                else{
	  	        	  window.location = "add-beneficiery.jsp";
	  	              return false;
	  	          }
	          });
	  }
	  else{
		  swal({
	          title: "A/c Number Invalid!",
	          text: "Given A/c number is not valid. Please, try again!",
	          icon: "error",
	          dangerMode: true,
	        
	          buttons:{
	               
	             confirm:{ 
	                text: "RETRY ?",
	                  value: "retry",
	               },
	          },
	    })
	    .then((value) => {
	          if(`${value}` == "retry")
	          {
	        	  window.location = "add-beneficiery.jsp";
	            return false;
	          }
	          else{
	        	  window.location = "add-beneficiery.jsp";
	              return false;
	          }
	    });
	  }
}

function amountbeneError(){

	  var max_limit = $('#max_limit').val();
	  var regex = /^([0-9+])+$/;

	  if(!regex.test(acc_num)){
	      
	        swal({
	                title: "Oops!",
	                text: "Max. limit of balance must be numeric code. Thank You!",
	                icon: "error",
	                dangerMode: true,
	              
	                buttons:{
	                     
	                   confirm:{ 
	                      text: "RETRY ?",
	                        value: "retry",
	                     },
	                },
	          })
	          .then((value) => {
	                if(`${value}` == "retry")
	                {
	                	window.location = "add-beneficiery.jsp";
	                  return false;
	                }
	                else{
	  	        	  window.location = "add-beneficiery.jsp";
	  	              return false;
	  	          }
	          });
	  }
	  else{
		  swal({
	          title: "A/c Number Invalid!",
	          text: "Given A/c number is not valid. Please, try again!",
	          icon: "error",
	          dangerMode: true,
	        
	          buttons:{
	               
	             confirm:{ 
	                text: "RETRY ?",
	                  value: "retry",
	               },
	          },
	    })
	    .then((value) => {
	          if(`${value}` == "retry")
	          {
	        	  window.location = "add-beneficiery.jsp";
	            return false;
	          }
	          else{
	        	  window.location = "add-beneficiery.jsp";
	              return false;
	          }
	    });
	  }
}

function amount_deposit(){

	  var amount = $('#amount').val();

	  var regex = /^([0-9+])+$/;

	  if(!regex.test(amount)){
	      
		  swal({
	            title: "Oops!",
	            text: "Please, Enter valid Amount balance. Thank You!",
	            icon: "error",
	            dangerMode: true,
	          
	            buttons:{
	                 
	               confirm:{ 
	                  text: "RETRY ?",
	                    value: "retry",
	                 },
	            },
	      })
	      .then((value) => {
	            if(`${value}` == "retry")
	            {
	          	  window.location = "page-deposit.jsp";
	              return false;
	            }
	            else{
	          	  window.location = "page-deposit.jsp";
	                return false;
	            }
	      });
	  }
}

function amount_withdraw(){

	  var amount = $('#amount').val();

	  var regex = /^([0-9+])+$/;

	  if(!regex.test(amount)){

		  swal({
	            title: "Oops!",
	            text: "Please, Enter valid Amount balance. Thank You!",
	            icon: "error",
	            dangerMode: true,
	          
	            buttons:{
	                 
	               confirm:{ 
	                  text: "RETRY ?",
	                    value: "retry",
	                 },
	            },
	      })
	      .then((value) => {
	            if(`${value}` == "retry")
	            {
	          	  window.location = "page-withdraw.jsp";
	              return false;
	            }
	            else{
	          	  window.location = "page-withdraw.jsp";
	                return false;
	            }
	      });
	  }
}

function search_acc_withdraw(){

	  var acc_num = $('#acc_num').val();

	  var regex = /^([0-9+])+$/;

	  if(!regex.test(acc_num)){
	      
		  swal({
	            title: "Oops!",
	            text: "Please, Enter valid A/c number. Thank You!",
	            icon: "error",
	            dangerMode: true,
	          
	            buttons:{
	                 
	               confirm:{ 
	                  text: "RETRY ?",
	                    value: "retry",
	                 },
	            },
	      })
	      .then((value) => {
	            if(`${value}` == "retry")
	            {
	          	  window.location = "search-acc-withdraw.jsp";
	              return false;
	            }
	            else{
	          	  window.location = "search-acc-withdraw.jsp";
	                return false;
	            }
	      });
	  }
}

function search_acc_deposit(){

	  var acc_num = $('#acc_num').val();

	  var regex = /^([0-9+])+$/;

	  if(!regex.test(acc_num)){
	      
		  swal({
	            title: "Oops!",
	            text: "Please, Enter valid A/c number. Thank You!",
	            icon: "error",
	            dangerMode: true,
	          
	            buttons:{
	                 
	               confirm:{ 
	                  text: "RETRY ?",
	                    value: "retry",
	                 },
	            },
	      })
	      .then((value) => {
	            if(`${value}` == "retry")
	            {
	          	  window.location = "search-acc-deposit.jsp";
	              return false;
	            }
	            else{
	          	  window.location = "search-acc-deposit.jsp";
	                return false;
	            }
	      });
	  }
}
