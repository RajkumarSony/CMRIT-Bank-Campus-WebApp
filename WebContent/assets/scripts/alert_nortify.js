
  function nortify(){
      toastr.options.closeButton = true;
      toastr.options.timeOut = 2000;
      toastr.success('Validation code has been sent on your email-id!','Successfully Sent!');
  }
  

 //... sweet alert box ///

  function code_verify(){
      swal({
        title: "Are you sure?",
        text: "Please, Confirm your code is either valid or not!",
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
            text: "Your code validation is successful. Thank You!",
            icon: "success",
          });
        } else {
          swal({
            title: "Try Again!",
            text: "Please, Enter your validation code! Thank You!",
            icon: "info",
            button: "OKEY !",
          });
        }
      });
  }
  
  function login_error(){
	  swal({
            title: "Oops!",
            text: "Please, Enter valid email-id or password. Thank You!",
            icon: "error",
            buttons:{
                confirm: "Try Again !",
                //cancel: "CANCEL"
            },
	  })
	  .then((value) =>{
			  setTimeout(open_login, 300);
	  }); 
  }
	 
  function auth_error(){
	  swal({
            title: "Oops!",
            text: "Please, Enter valid profile password. Thank You!",
            icon: "error",
            buttons:{
                confirm: "Try Again !",
                //cancel: "CANCEL"
            },
	  })
	  .then((value) =>{
			  setTimeout(open_auth, 300);
	  }); 
  }
  function login(){
	  swal({
	            title: "Good Job!",
	            text: "You are login successfully. Thank You!",
	            icon: "success",
	            buttons:{
	                confirm: "Done !",
	                //cancel: "CANCEL"
	            },
	  })
	  .then((value) =>{
				  setTimeout(open_dashboard, 300);
	  }); 
  }
  
  function open_dashboard(){
    window.location = "dashboard.jsp";
  }

  function personal(){
	  window.location = "personal-details.jsp";
  }
  function signup_error(){
    swal({
    	title: "Oops!",
        text: "Sorry, We Can not accept duplicate information. Try again !",
        icon: "error",
        buttons:{
            confirm: "Try Again !",
            //cancel: "CANCEL"
        },
    })
    .then((value) =>{
      setTimeout(open_signup, 0);
    }); 
  }
  
  function signup(){
	    swal({
	            title: "Awesome!",
	            text: "You are register successfully. Thank You!",
	            icon: "success",
	            buttons:{
	                confirm: "DONE !",
	                //cancel: "CANCEL"
	            },
	    })
	    .then((value) =>{
	      setTimeout(sent_pass, 0);
	    }); 
  }
  
  function open_login(){
    window.location = "page-login.jsp";
  }

  function open_signup(){
	    window.location = "page-signup.jsp";
  }
  
  function open_auth(){
    window.location = "page-auth.jsp";
  }

  function sent_pass(){
    swal({
            title: "Successfully Sent!",
            text: "Your profile password has been sent on your email-id!",
            icon: "success",
            buttons:{
                confirm: "DONE !",
                //cancel: "CANCEL"
            },
    })
    .then((value) =>{
    	setTimeout(open_login, 0);
    });
  }
  function sent_pass2(){
	    swal({
	            title: "Successfully Sent!",
	            text: "Your profile password has been sent on your email-id!",
	            icon: "success",
	            buttons:{
	                confirm: "DONE !",
	                //cancel: "CANCEL"
	            },
	    })
	    .then((value) =>{
	    	setTimeout(open_auth, 0);
	    });
  }
  
  function sent_valid_code(){
	    swal({
	            title: "Successfully Sent!",
	            text: "A/c validation code has been sent on your email-id!",
	            icon: "success",
	            buttons:{
	                confirm: "DONE !",
	                //cancel: "CANCEL"
	            },
	    })
	    .then((value) =>{
	    	window.location = "account-validate.jsp";
	    });
  }
  
  function send_accNum(){
	    swal({
	            title: "Successfully Sent!",
	            text: "A/c information has been sent on customer email-id!",
	            icon: "success",
	            buttons:{
	                confirm: "DONE !",
	                //cancel: "CANCEL"
	            },
	    })
	    .then((value) =>{
	    	window.location = "account-info.jsp";
	    });
}
  
  function resent_pass(){
    swal({
            title: "Successfully Sent!",
            text: "Your profile password has been sent on your email-id!",
            icon: "success",
            buttons:{
                confirm: "DONE !",
                //cancel: "CANCEL"
            },
    })
    .then((value) =>{
      return false;
    });
  }

  function forgot(){
      var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
      swal({
          title: "Enter Your Registered Email-Id:",
          content: "input",
      })
      .then((value) => {

          //$('#email').val(value);
          //swal(`You typed: ${value}`);
          if (`${value}` == 0) {
            swal({
              title: "Oops!",
              text: "Please, Enter your valid or registered email-id!",
              icon: "warning",
              dangerMode: true,
              
              buttons:{
                cancel: "CANCEL",
                   
                confirm:{ 
                  text: "RETRY ?",
                  value: "retry",
                },
              },
            })
            .then((value) => {
                if(`${value}` == "retry")
                {
                  setTimeout(forgot, 0);
                }
            });
          }
          else if(!regex.test(`${value}`))
          {
            swal({
              title: "Oops!",
              text: "Please, Enter your valid or registered email-id!",
              icon: "error",
              dangerMode: true,
              
              buttons:{
                cancel: "CANCEL",
                   
                confirm:{ 
                  text: "RETRY ?",
                  value: "retry",
                },
              },
            })
            .then((value) => {
                if(`${value}` == "retry")
                {
                  setTimeout(forgot, 0);
                }
            });
          }
          else{
        	  /////////////// sending request to the server//////////////
          $.ajax({
                  url: 'sending',
                  data: {email:value},
                  type: 'POST'
          });
          swal({
              title: "Successfully Sent!",
              text: "Your information has been sent on your email-id!",
              icon: "success",
              buttons:{
                confirm: "DONE !",
                //cancel: "CANCEL"
                 
              },
          });
        }
      });
  }

  function isEmail(email) {
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email);
  }

  function confirm_beneficiary()
  {
      swal({
            title: "Are you sure?",
            text: "Please, Confirm your given informations are either valid or not!",
            icon: "warning",
            dangerMode: true,
              
            buttons:{
              cancel: "CANCEL",
                   
              confirm: {
                text: "CONFIRM ?",
                value : "okey",
              }
            },
      })
      .then((value) => {
            if(`${value}` == "okey")
            {
                ++step;
                next(1);
            }
            else {
              swal({
                title: "Try Again!",
                text: "Please, Enter the valid informations! Thank You!",
                icon: "info",
                button: "OKEY !",
              });
            }
      });

  }

  function add_beneficiary(){

      swal({
          title: "Successfully Added!",
          text: "New beneficiary is added successfully. Thank You!",
          icon: "success",
          buttons:{
              confirm:{ 
                  text: "DONE !",
                  value: "done",
              },
          },
      })
      .then((value) =>{
          if(`${value}` == "done")
          {
              setTimeout(open_dashboard, 0);
          }
      });
  }

  function confirm_account()
  {
      swal({
            title: "Are you sure?",
            text: "Please, Confirm your given informations are either valid or not!",
            icon: "warning",
            dangerMode: true,
              
            buttons:{
              cancel: "CANCEL",
                   
              confirm: {
                text: "CONFIRM ?",
                value : "okey",
              }
            },
      })
      .then((value) => {
            if(`${value}` == "okey")
            {
                ++step1;
                console.log("confirm true = "+step1);
                next_Acc(1);
            }
            else {
              console.log("confirm = "+step1);
              swal({
                title: "Try Again!",
                text: "Please, Enter the valid informations! Thank You!",
                icon: "info",
                button: "OKEY !",
              });
            }
      });
  }

  function add_account(){
      swal({
          title: "Successfully Opened!",
          text: "New account is opened successfully. Thank You!",
          icon: "success",
          buttons:{
              confirm:{ 
                  text: "DONE !",
                  value: "done",
              },
          },
      })
      .then((value) =>{
          if(`${value}` == "done")
          {
              setTimeout(open_dashboard, 0);
          }
      });
  }
  
  n = 0;
  function add_debit_amount(){
      var regex_num = /^([0-9.-])+$/;
      if (n == 1) {
        return false;
      }
      swal({
          title: "Enter the Amount to be Deposited:",
          content: "input",
      })
      .then((value) => {
          //swal(`You typed: ${value}`);
          if (`${value}` == 0) {
            swal({
              title: "Oops!",
              text: "Please, Enter your valid Amount!",
              icon: "warning",
              dangerMode: true,
              
              buttons:{
                cancel: "CANCEL",
                   
                confirm:{ 
                  text: "RETRY ?",
                  value: "retry",
                },
              },
            })
            .then((value) => {
                if(`${value}` == "retry")
                {
                  setTimeout(add_debit_amount, 0);
                }
            });
          }
          else if (!regex_num.test(`${value}`)) {
            swal({
              title: "Oops!",
              text: "Please, Enter your valid Amount!",
              icon: "error",
              dangerMode: true,
              
              buttons:{
                cancel: "CANCEL",
                   
                confirm:{ 
                  text: "RETRY ?",
                  value: "retry",
                },
              },
            })
            .then((value) => {
                if(`${value}` == "retry")
                {
                  setTimeout(add_debit_amount, 0);
                }
            });
          }
          else if (`${value}` != "null") {
            ++n;
            console.log(`${value}`);
            swal({
              title: "Successfully Added!",
              text: "Amount is added in list & ready for Deposited!",
              icon: "success",
              buttons:{
                confirm: "DONE !",
                //cancel: "CANCEL"
              },
            });
          }
      });
  }

  n1 = 0;
  function add_withdraw_amount(){
      var regex_num = /^([0-9.-])+$/;
      if (n1 == 1) {
        return false;
      }
      swal({
          title: "Enter the Amount to be Withdrawn:",
          content: "input",
      })
      .then((value) => {
          //swal(`You typed: ${value}`);
          if (`${value}` == 0) {
            swal({
              title: "Oops!",
              text: "Please, Enter your valid Amount!",
              icon: "warning",
              dangerMode: true,
              
              buttons:{
                cancel: "CANCEL",
                   
                confirm:{ 
                  text: "RETRY ?",
                  value: "retry",
                },
              },
            })
            .then((value) => {
                if(`${value}` == "retry")
                {
                  setTimeout(add_debit_amount, 0);
                }
            });
          }
          else if (!regex_num.test(`${value}`)) {
            swal({
              title: "Oops!",
              text: "Please, Enter your valid Amount!",
              icon: "error",
              dangerMode: true,
              
              buttons:{
                cancel: "CANCEL",
                   
                confirm:{ 
                  text: "RETRY ?",
                  value: "retry",
                },
              },
            })
            .then((value) => {
                if(`${value}` == "retry")
                {
                  setTimeout(add_withdraw_amount, 0);
                }
            });
          }
          else if (`${value}` != "null") {
            ++n1;
            console.log(`${value}`);
            swal({
              title: "Successfully Added!",
              text: "Amount is added in list & ready for Withdrawn!",
              icon: "success",
              buttons:{
                confirm: "DONE !",
                //cancel: "CANCEL"
              },
            });
          }
      });
  }

  function comming(){
    swal({
        title: "Comming Soon!",
        text: "Please wait, This service is not available now. Thank You!",
        buttons: false,
        icon: "error",
    })
    .then((value)=>{
        return false;
    });
  }

  function apply_card(){
      swal({
            title: "Are you sure?",
            text: "Please confirm, Are you agree for apply the card or not!",
            icon: "warning",
            dangerMode: true,
              
            buttons:{
              cancel: "CANCEL",
                   
              confirm: {
                text: "CONFIRM ?",
                value : "okey",
              }
            },
      })
      .then((value) =>{
          if(`${value}` == "okey")
          {
              swal({
                  title: "Successfully Applied!",
                  text: "ATM Card is applied successfully. Thank You!",
                  icon: "success",
                  button:{
                    confirm: {
                      text: "DONE",
                      value : "okey",
                    }
                  },
              })
              .then((value)=>{
                  return false;
              });
          }
      });
  }

  function apply_checkbook(){

      swal({
            title: "Are you sure?",
            text: "Please confirm, Are you agree for apply the cheque book or not!",
            icon: "warning",
            dangerMode: true,
              
            buttons:{
              cancel: "CANCEL",
                   
              confirm: {
                text: "CONFIRM ?",
                value : "okey",
              }
            },
      })
      .then((value) =>{
          if(`${value}` == "okey")
          {
              swal({
                  title: "Successfully Applied!",
                  text: "Cheque book is applied successfully. Thank You!",
                  icon: "success",
                  button:{
                    confirm: {
                        text: "DONE !",
                        value : "okey",
                    }
                  },
              })
              .then((value)=>{
                  return false;
              });
          }
      });
  }
  
  function openAcc(){
	  swal({
          title: "Are you sure?",
          text: "Please confirm, Given A/c information is either valid or not!",
          icon: "warning",
          dangerMode: true,
            
          buttons:{
            cancel: "CANCEL",
                 
            confirm: {
              text: "CONFIRM ?",
              value : "okey",
            }
          },
    })
    .then((value) =>{
        if(`${value}` == "okey")
        {
            swal({
                title: "Successfully Applied!",
                text: "Account info. has been submitted successfully. Thank You!",
                icon: "success",
                button:{
                  confirm: {
                      text: "DONE !",
                      value : "okey",
                  }
                },
            })
            .then((value)=>{
            		setTimeout(sent_valid_code, 0);	
            		return false;
            });
        }
        else{
        	window.location = "description.jsp";
        	return false;
        }
    });
  }
  

  function openAccErr(){
	    swal({
	            title: "Oops!",
	            text: "There are some problems. Please try again!",
	            icon: "error",
	            buttons:{
	                confirm: "TRY AGAIN !",
	                //cancel: "CANCEL"
	            },
	    })
	    .then((value) =>{
	    	window.location = "open-account.jsp"
	    }); 
  }
  
  function account_opened(){
      swal({
          title: "Successfully Opened!",
          text: "New account has been opened successfully. Thank You!",
          icon: "success",
          buttons:{
              confirm:{ 
                  text: "DONE !",
                  value: "done",
              },
          },
      })
      .then((value) =>{
          if(`${value}` == "done")
          {
              setTimeout(send_accNum, 0);
          }
      });
  }
  
  function invalid_valid_code(){
      swal({
          title: "Oops!",
          text: "Given validation code is not valid. Please try again!",
          icon: "error",
          buttons:{
              confirm:{ 
                  text: "TRY AGAIN !",
                  value: "done",
              },
          },
      })
      .then((value) =>{
          if(`${value}` == "done")
          {
        	  window.location = "account-validate.jsp";
          }
      });
  }

  
  
  function open_deposit(){
	  window.location = "page-deposit.jsp"
  }
  
  function open_withdraw(){
	  window.location = "page-withdraw.jsp"
  }
  
  function amount_deposited(){
	  swal({
          title: "Are you sure?",
          text: "Please confirm, Given A/c information is either valid or not!",
          icon: "warning",
          dangerMode: true,
            
          buttons:{
            cancel: "CANCEL",
                 
            confirm: {
              text: "CONFIRM ?",
              value : "okey",
            }
          },
    })
    .then((value) =>{
        if(`${value}` == "okey")
        {
            swal({
                title: "Successfully Deposited!",
                text: "Amount has been deposited successfully. Thank You!",
                icon: "success",
                button:{
                  confirm: {
                      text: "DONE !",
                      value : "okey",
                  }
                },
            })
            .then((value)=>{
            		window.location = "search-acc-deposit.jsp";
            		return false;
            });
        }
        else{
        	setTimeout(open_dashboard, 0);
        	return false;
        }
    });
  }

  function amount_withdrawn(){
	  swal({
          title: "Are you sure?",
          text: "Please confirm, Given A/c information is either valid or not!",
          icon: "warning",
          dangerMode: true,
            
          buttons:{
            cancel: "CANCEL",
                 
            confirm: {
              text: "CONFIRM ?",
              value : "okey",
            }
          },
    })
    .then((value) =>{
        if(`${value}` == "okey")
        {
            swal({
                title: "Successfully Withdrawn!",
                text: "Amount has been withdrawn successfully. Thank You!",
                icon: "success",
                button:{
                  confirm: {
                      text: "DONE !",
                      value : "okey",
                  }
                },
            })
            .then((value)=>{
            		window.location = "search-acc-withdraw.jsp";
            		return false;
            });
        }
        else{
        	setTimeout(open_dashboard, 0);
        	return false;
        }
    });
  }
  
 
  
  function depositErr(){
      swal({
              title: "Transaction Failed!",
              text: "Given A/c information is not valid. Thank You!",
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
  
  function withdrawErr(){
      swal({
              title: "Transaction Failed!",
              text: "Given A/c information is not valid. Thank You!",
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
  
  function ServerError(){
	  swal({
          title: "Server Failed!",
          text: "Server or Database not found. Try again!",
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
        	  window.location = "dashboard.jsp";
            return false;
          }
          else{
        	  window.location = "dashboard.jsp";
              return false;
          }
    });
  } 
  
  function add_beneficiary(){
	  swal({
          title: "Are you sure?",
          text: "Please confirm, Given A/c information is either valid or not!",
          icon: "warning",
          dangerMode: true,
            
          buttons:{
            cancel: "CANCEL",
                 
            confirm: {
              text: "CONFIRM ?",
              value : "okey",
            }
          },
    })
    .then((value) =>{
        if(`${value}` == "okey")
        {
            swal({
                title: "Successfully Added!",
                text: "Beneficiary details has been added successfully. Thank You!",
                icon: "success",
                button:{
                  confirm: {
                      text: "DONE !",
                      value : "okey",
                  }
                },
            })
            .then((value)=>{
            		window.location = "dashboard.jsp";
            		return false;
            });
        }
        else{
        	window.location = "add-beneficiery.jsp";
        	return false;
        }
    });
  }
 
  
  
  
  function BeneficiaryError(){
	  swal({
          title: "Oops!",
          text: "Given A/c information is not valid. Please, try again!",
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
 function amountbError(){
		  swal({
	          title: "Oops!",
	          text: "Given A/c information is not valid. Please, try again!",
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
	        	  window.location = "amount-beneficiery.jsp";
	            return false;
	          }
	          else{
	        	  window.location = "amount-beneficiery.jsp";
	              return false;
	          }
	    });
  } 
 
 function sufficient_bal(){
	  swal({
         title: "Oops!",
         text: "This A/c has no sufficient balance. Please, try again!",
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